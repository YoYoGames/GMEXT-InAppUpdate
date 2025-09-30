
package ${YYAndroidPackageName};

import ${YYAndroidPackageName}.R;
import com.yoyogames.runner.RunnerJNILib;

import android.app.Activity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.play.core.appupdate.AppUpdateManager;
import com.google.android.play.core.appupdate.AppUpdateManagerFactory;
import com.google.android.play.core.appupdate.AppUpdateInfo;
import com.google.android.play.core.install.model.UpdateAvailability;
import com.google.android.play.core.install.model.AppUpdateType;
import com.google.android.play.core.install.InstallStateUpdatedListener;
import com.google.android.play.core.install.InstallState;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.OnCompleteListener;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.lang.Exception;

import android.content.Intent;

import android.util.Log;

public class InAppUpdates extends RunnerSocial {
	Activity activity = RunnerActivity.CurrentActivity;

	private static final int EVENT_OTHER_SOCIAL = 70;
	private static final int UPDATE_REQUEST_CODE = 289;

	AppUpdateInfo mAppUpdateInfo = null;
	InstallStateUpdatedListener installStateUpdatedListener = null;

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		if (requestCode == UPDATE_REQUEST_CODE) {
			int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
			RunnerJNILib.DsMapAddString(dsMapIndex, "type", "inappupdate_show");
			RunnerJNILib.DsMapAddDouble(dsMapIndex, "result", (double) resultCode);
			RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
		}
	}

	public void inappupdate_request_info() {
		AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(activity);
		Task<AppUpdateInfo> appUpdateInfoTask = appUpdateManager.getAppUpdateInfo();
		appUpdateInfoTask.addOnCompleteListener(/* activity, */new OnCompleteListener<AppUpdateInfo>() {
			@Override
			public void onComplete(@NonNull Task<AppUpdateInfo> task) {
				if (task.isSuccessful())
					mAppUpdateInfo = task.getResult();

				int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
				RunnerJNILib.DsMapAddString(dsMapIndex, "type", "inappupdate_request_info");
				RunnerJNILib.DsMapAddDouble(dsMapIndex, "success", task.isSuccessful() ? 1.0 : 0.0);
				RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
			}
		});
	}

	public void inappupdate_show(double options) {
		AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(activity);
		try {
			// Start update flow
			appUpdateManager.startUpdateFlowForResult(mAppUpdateInfo, (int) options, RunnerActivity.CurrentActivity,
					UPDATE_REQUEST_CODE);

			// Register listener for install/download updates
			if (installStateUpdatedListener != null) {
				appUpdateManager.unregisterListener(installStateUpdatedListener);
				installStateUpdatedListener = null;
			}
			installStateUpdatedListener = new InstallStateUpdatedListener() {
				@Override
				public void onStateUpdate(InstallState state) {
					int dsMapIndex = RunnerJNILib.jCreateDsMap(null, null, null);
					RunnerJNILib.DsMapAddString(dsMapIndex, "type", "inappupdate_install_status_update");
					RunnerJNILib.DsMapAddDouble(dsMapIndex, "install_status", (double) state.installStatus());
					RunnerJNILib.DsMapAddDouble(dsMapIndex, "bytes_downloaded", (double) state.bytesDownloaded());
					RunnerJNILib.DsMapAddDouble(dsMapIndex, "total_bytes_to_download", (double) state.totalBytesToDownload());
					RunnerJNILib.CreateAsynEventWithDSMap(dsMapIndex, EVENT_OTHER_SOCIAL);
				}
			};
			appUpdateManager.registerListener(installStateUpdatedListener);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public double inappupdate_available_version_code() {
		if (mAppUpdateInfo == null)
			return -4;

		return (double) mAppUpdateInfo.availableVersionCode();
	}

	public double inappupdate_bytes_downloaded() {
		if (mAppUpdateInfo == null)
			return -4;

		return (double) mAppUpdateInfo.bytesDownloaded();
	}

	public double inappupdate_client_version_staleness_days() {
		if (mAppUpdateInfo == null)
			return -4;

		return mAppUpdateInfo.clientVersionStalenessDays().doubleValue();
	}

	public double inappupdate_install_status() {
		if (mAppUpdateInfo == null)
			return -4;

		return mAppUpdateInfo.installStatus();
	}

	public double inappupdate_is_update_type_allowed(double options) {
		if (mAppUpdateInfo == null)
			return -4;

		if (mAppUpdateInfo.isUpdateTypeAllowed((int) options))
			return 1.0;
		else
			return 0.0;
	}

	public String inappupdate_package_name() {
		if (mAppUpdateInfo == null)
			return "";

		return mAppUpdateInfo.packageName();
	}

	public double inappupdate_total_bytes_to_download() {
		if (mAppUpdateInfo == null)
			return -4;

		return (double) mAppUpdateInfo.totalBytesToDownload();
	}

	public double inappupdate_update_availability() {
		if (mAppUpdateInfo == null)
			return -4;

		return (double) mAppUpdateInfo.updateAvailability();
	}

	public double inappupdate_info_availability() {
		if (mAppUpdateInfo == null)
			return 0.0;
		else
			return 1.0;
	}

	public double inappupdate_update_priority() {
		if (mAppUpdateInfo == null)
			return -4;

		return (double) mAppUpdateInfo.updatePriority();
	}

	public void inappupdate_complete_flexible_update() {
		AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(activity);
		appUpdateManager.completeUpdate();
	}

    public void onDestroy() {
		// Unregister installStateUpdatedListener listener if it exists
        if (installStateUpdatedListener != null) {
			AppUpdateManager appUpdateManager = AppUpdateManagerFactory.create(activity);
			appUpdateManager.unregisterListener(installStateUpdatedListener);
			installStateUpdatedListener = null;
		}
	}
}
