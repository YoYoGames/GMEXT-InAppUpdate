
package ${YYAndroidPackageName};

import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.GMExtWire.GMFunction;

import android.app.Activity;
import android.content.Intent;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.install.InstallState;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.model.ActivityResult;


public class GMInAppUpdates extends GMInAppUpdatesInternal
{
    private static final int UPDATE_REQUEST_CODE = 289;

    private final Activity activity;
    private final AppUpdateManager appUpdateManager;

    private AppUpdateInfo appUpdateInfo;
    private InstallStateUpdatedListener installStateUpdatedListener;

    private GMFunction updateFlowCallback;
    private GMFunction installStatusCallback;

    public GMInAppUpdates()
    {
        activity = RunnerActivity.CurrentActivity;
        appUpdateManager = AppUpdateManagerFactory.create(activity);
    }

    private static String safeString(String value)
    {
        return value != null ? value : "";
    }

    private static String error(Throwable throwable)
    {
        if (throwable == null)
            return "Unknown in-app update error.";

        String message = throwable.getMessage();
        return message != null ? message : throwable.toString();
    }

    private static GMExtWire.StructStream infoResult(
        boolean success,
        AppUpdateInfo info,
        String error)
    {
        Integer stalenessDays =
            info != null ? info.clientVersionStalenessDays() : null;

        return new GMExtWire.StructStream()
            .kv("success", success)
            .kv("info_available", info != null)
            .kv("available_version_code",
                info != null ? info.availableVersionCode() : -4)
            .kv("bytes_downloaded",
                info != null ? info.bytesDownloaded() : -4L)
            .kv("client_version_staleness_days",
                stalenessDays != null ? stalenessDays : -1)
            .kv("install_status",
                info != null ? info.installStatus() : -4)
            .kv("package_name",
                info != null ? safeString(info.packageName()) : "")
            .kv("total_bytes_to_download",
                info != null ? info.totalBytesToDownload() : -4L)
            .kv("update_availability",
                info != null ? info.updateAvailability() : -4)
            .kv("update_priority",
                info != null ? info.updatePriority() : -4)
            .kv("error", safeString(error));
    }

    private static GMExtWire.StructStream updateFlowResult(
        boolean success,
        int resultCode,
        String error)
    {
        return new GMExtWire.StructStream()
            .kv("success", success)
            .kv("result_code", resultCode)
            .kv("accepted", resultCode == Activity.RESULT_OK)
            .kv("cancelled", resultCode == Activity.RESULT_CANCELED)
            .kv("failed",
                resultCode == ActivityResult.RESULT_IN_APP_UPDATE_FAILED)
            .kv("error", safeString(error));
    }

    private static GMExtWire.StructStream installStateResult(
        boolean success,
        InstallState state,
        String error)
    {
        return new GMExtWire.StructStream()
            .kv("success", success)
            .kv("install_status",
                state != null ? state.installStatus() : -4)
            .kv("bytes_downloaded",
                state != null ? state.bytesDownloaded() : 0L)
            .kv("total_bytes_to_download",
                state != null ? state.totalBytesToDownload() : 0L)
            .kv("install_error_code",
                state != null ? state.installErrorCode() : 0)
            .kv("package_name",
                state != null ? safeString(state.packageName()) : "")
            .kv("error", safeString(error));
    }

    public void onActivityResult(
        int requestCode,
        int resultCode,
        Intent data)
    {
        if (requestCode != UPDATE_REQUEST_CODE)
            return;

        GMFunction callback = updateFlowCallback;
        updateFlowCallback = null;

        if (callback == null)
            return;

        boolean success =
            resultCode == Activity.RESULT_OK
            || resultCode == Activity.RESULT_CANCELED;

        String resultError =
            resultCode == ActivityResult.RESULT_IN_APP_UPDATE_FAILED
                ? "The in-app update flow failed."
                : "";

        callback.call(
            updateFlowResult(
                success,
                resultCode,
                resultError
            )
        );
    }

    public void inappupdate_request_info(
        final GMFunction callback)
    {
        Task<AppUpdateInfo> task =
            appUpdateManager.getAppUpdateInfo();

        task.addOnCompleteListener(completedTask ->
        {
            if (!completedTask.isSuccessful())
            {
                appUpdateInfo = null;

                callback.call(
                    infoResult(
                        false,
                        null,
                        error(completedTask.getException())
                    )
                );
                return;
            }

            appUpdateInfo = completedTask.getResult();

            if (appUpdateInfo == null)
            {
                callback.call(
                    infoResult(
                        false,
                        null,
                        "No in-app update information was returned."
                    )
                );
                return;
            }

            callback.call(
                infoResult(
                    true,
                    appUpdateInfo,
                    ""
                )
            );
        });
    }

    public void inappupdate_show(
        InAppUpdateType update_type,
        final GMFunction callback,
        final GMFunction install_status_callback)
    {
        if (appUpdateInfo == null)
        {
            callback.call(
                updateFlowResult(
                    false,
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                    "Call inappupdate_request_info before inappupdate_show."
                )
            );
            return;
        }

        int updateType = (int)update_type.value();

        if (!appUpdateInfo.isUpdateTypeAllowed(updateType))
        {
            callback.call(
                updateFlowResult(
                    false,
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                    "The requested update type is not allowed."
                )
            );
            return;
        }

        unregisterInstallListener();

        updateFlowCallback = callback;
        installStatusCallback = install_status_callback;

        installStateUpdatedListener = state ->
        {
            GMFunction statusCallback = installStatusCallback;

            if (statusCallback != null)
            {
                statusCallback.call(
                    installStateResult(
                        true,
                        state,
                        ""
                    )
                );
            }
        };

        appUpdateManager.registerListener(
            installStateUpdatedListener
        );

        try
        {
            boolean started =
                appUpdateManager.startUpdateFlowForResult(
                    appUpdateInfo,
                    updateType,
                    activity,
                    UPDATE_REQUEST_CODE
                );

            if (!started)
            {
                updateFlowCallback = null;

                callback.call(
                    updateFlowResult(
                        false,
                        ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                        "The in-app update flow could not be started."
                    )
                );
            }
        }
        catch (Exception exception)
        {
            updateFlowCallback = null;

            callback.call(
                updateFlowResult(
                    false,
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                    error(exception)
                )
            );
        }
    }

    public double inappupdate_available_version_code()
    {
        return appUpdateInfo != null
            ? (double)appUpdateInfo.availableVersionCode()
            : -4;
    }

    public double inappupdate_bytes_downloaded()
    {
        return appUpdateInfo != null
            ? (double)appUpdateInfo.bytesDownloaded()
            : -4;
    }

    public double inappupdate_client_version_staleness_days()
    {
        if (appUpdateInfo == null)
            return -4;

        Integer days =
            appUpdateInfo.clientVersionStalenessDays();

        return days != null ? days.doubleValue() : -1;
    }

    public double inappupdate_install_status()
    {
        return appUpdateInfo != null
            ? appUpdateInfo.installStatus()
            : -4;
    }

    public boolean inappupdate_is_update_type_allowed(
        InAppUpdateType update_type)
    {
        return appUpdateInfo != null
            && appUpdateInfo.isUpdateTypeAllowed(
                (int)update_type.value()
            );
    }

    public String inappupdate_package_name()
    {
        return appUpdateInfo != null
            ? safeString(appUpdateInfo.packageName())
            : "";
    }

    public double inappupdate_total_bytes_to_download()
    {
        return appUpdateInfo != null
            ? (double)appUpdateInfo.totalBytesToDownload()
            : -4;
    }

    public double inappupdate_update_availability()
    {
        return appUpdateInfo != null
            ? (double)appUpdateInfo.updateAvailability()
            : -4;
    }

    public boolean inappupdate_info_availability()
    {
        return appUpdateInfo != null;
    }

    public double inappupdate_update_priority()
    {
        return appUpdateInfo != null
            ? (double)appUpdateInfo.updatePriority()
            : -4;
    }

    public void inappupdate_complete_flexible_update(
        final GMFunction callback)
    {
        appUpdateManager.completeUpdate()
            .addOnCompleteListener(task ->
            {
                if (task.isSuccessful())
                    callback.call(true, "");
                else
                    callback.call(
                        false,
                        error(task.getException())
                    );
            });
    }

    private void unregisterInstallListener()
    {
        if (installStateUpdatedListener != null)
        {
            appUpdateManager.unregisterListener(
                installStateUpdatedListener
            );

            installStateUpdatedListener = null;
        }

        installStatusCallback = null;
    }

    public void onDestroy()
    {
        unregisterInstallListener();
        updateFlowCallback = null;
    }
}
