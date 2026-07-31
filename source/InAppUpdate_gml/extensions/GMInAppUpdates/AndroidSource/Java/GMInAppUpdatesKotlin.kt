package ${YYAndroidPackageName}

import ${YYAndroidPackageName}.GMExtWire
import ${YYAndroidPackageName}.GMExtWire.GMFunction
import ${YYAndroidPackageName}.enums.*

import android.app.Activity
import android.content.Intent
import android.util.Log

import com.google.android.play.core.appupdate.AppUpdateInfo
import com.google.android.play.core.appupdate.AppUpdateManager
import com.google.android.play.core.appupdate.AppUpdateManagerFactory
import com.google.android.play.core.appupdate.AppUpdateOptions
import com.google.android.play.core.install.InstallState
import com.google.android.play.core.install.InstallStateUpdatedListener
import com.google.android.play.core.install.model.ActivityResult
import com.google.android.play.core.install.model.InstallStatus
import com.google.android.play.core.install.model.UpdateAvailability
import com.google.android.play.core.ktx.requestAppUpdateInfo
import com.google.android.play.core.ktx.requestCompleteUpdate

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch


/**
 * Extension Generator Kotlin implementation for Google Play In-App Updates.
 *
 * Dependencies:
 *   com.google.android.play:app-update:2.1.0
 *   com.google.android.play:app-update-ktx:2.1.0
 *
 * KTX is used for requestAppUpdateInfo() and requestCompleteUpdate().
 * The update UI uses the current AppUpdateOptions overload rather than the
 * deprecated integer-only startUpdateFlowForResult overload.
 */
class GMInAppUpdatesKotlin : GMInAppUpdatesInterface
{
    companion object
    {
        private const val TAG = "GMInAppUpdates"
        private const val UPDATE_REQUEST_CODE = 289

        private const val NO_INFO_INT = -4
        private const val NO_INFO_LONG = -4L
    }

    private val scope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    private var appUpdateManager: AppUpdateManager? = null
    private var appUpdateInfo: AppUpdateInfo? = null
    private var appUpdateInfoConsumed = false

    private var installStateUpdatedListener:
        InstallStateUpdatedListener? = null

    private var updateFlowCallback: GMFunction? = null
    private var installStatusCallback: GMFunction? = null

    private fun activity(): Activity? =
        RunnerActivity.CurrentActivity

    private fun manager(): AppUpdateManager?
    {
        val existing = appUpdateManager
        if (existing != null)
            return existing

        val currentActivity = activity() ?: return null
        return AppUpdateManagerFactory
            .create(currentActivity)
            .also { appUpdateManager = it }
    }

    private fun errorMessage(throwable: Throwable?): String
    {
        if (throwable == null)
            return "Unknown in-app update error."

        return throwable.message ?: throwable.toString()
    }

    private fun invokeCallback(
        callback: GMFunction?,
        payload: GMExtWire.StructStream
    )
    {
        if (callback == null)
            return

        try
        {
            callback.call(payload)
        }
        catch (exception: Exception)
        {
            Log.e(TAG, "Could not invoke GML callback.", exception)
        }
    }

    private fun updateTypeValue(
        updateType: InAppUpdateType
    ): Int =
        updateType.value().toInt()

    private fun installStatusEnum(
        value: Int
    ): InAppUpdateInstallStatus =
        InAppUpdateInstallStatus.values().firstOrNull {
            it.value().toInt() == value
        } ?: InAppUpdateInstallStatus.Unknown

    private fun availabilityEnum(
        value: Int
    ): InAppUpdateAvailability =
        InAppUpdateAvailability.values().firstOrNull {
            it.value().toInt() == value
        } ?: InAppUpdateAvailability.Unknown

    private fun activityResultEnum(
        value: Int
    ): InAppUpdateActivityResult =
        InAppUpdateActivityResult.values().firstOrNull {
            it.value().toInt() == value
        } ?: InAppUpdateActivityResult.Unknown

    private fun infoResult(
        success: Boolean,
        info: AppUpdateInfo?,
        errorMessage: String
    ): GMExtWire.StructStream
    {
        val stalenessDays =
            info?.clientVersionStalenessDays() ?: -1

        return GMExtWire.StructStream()
            .kv("success", success)
            .kv("info_available", info != null)
            .kv(
                "available_version_code",
                info?.availableVersionCode() ?: NO_INFO_INT
            )
            .kv(
                "bytes_downloaded",
                info?.bytesDownloaded() ?: NO_INFO_LONG
            )
            .kv(
                "client_version_staleness_days",
                if (info != null) stalenessDays else NO_INFO_INT
            )
            .kv(
                "install_status",
                installStatusEnum(
                    info?.installStatus()
                        ?: InstallStatus.UNKNOWN
                ).value().toInt()
            )
            .kv("package_name", info?.packageName() ?: "")
            .kv(
                "total_bytes_to_download",
                info?.totalBytesToDownload() ?: NO_INFO_LONG
            )
            .kv(
                "update_availability",
                availabilityEnum(
                    info?.updateAvailability()
                        ?: UpdateAvailability.UNKNOWN
                ).value().toInt()
            )
            .kv(
                "update_priority",
                info?.updatePriority() ?: NO_INFO_INT
            )
            .kv("error_message", errorMessage)
    }

    private fun updateFlowResult(
        success: Boolean,
        resultCode: Int,
        errorMessage: String
    ): GMExtWire.StructStream
    {
        return GMExtWire.StructStream()
            .kv("success", success)
            .kv(
                "result",
                activityResultEnum(resultCode).value().toInt()
            )
            .kv("accepted", resultCode == Activity.RESULT_OK)
            .kv(
                "cancelled",
                resultCode == Activity.RESULT_CANCELED
            )
            .kv(
                "failed",
                resultCode ==
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED
            )
            .kv("error_message", errorMessage)
    }

    private fun installStateResult(
        success: Boolean,
        state: InstallState?,
        errorMessage: String
    ): GMExtWire.StructStream
    {
        return GMExtWire.StructStream()
            .kv("success", success)
            .kv(
                "install_status",
                installStatusEnum(
                    state?.installStatus()
                        ?: InstallStatus.UNKNOWN
                ).value().toInt()
            )
            .kv(
                "bytes_downloaded",
                state?.bytesDownloaded() ?: 0L
            )
            .kv(
                "total_bytes_to_download",
                state?.totalBytesToDownload() ?: 0L
            )
            .kv(
                "install_error_code",
                state?.installErrorCode() ?: 0
            )
            .kv("package_name", state?.packageName() ?: "")
            .kv("error_message", errorMessage)
    }

    private fun completeResult(
        success: Boolean,
        errorMessage: String
    ): GMExtWire.StructStream
    {
        return GMExtWire.StructStream()
            .kv("success", success)
            .kv("error_message", errorMessage)
    }

    // -------------------------------------------------------------------------
    // Activity / extension lifecycle
    // -------------------------------------------------------------------------

    fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    )
    {
        if (requestCode != UPDATE_REQUEST_CODE)
            return

        val callback = updateFlowCallback
        updateFlowCallback = null

        if (callback == null)
            return

        val success =
            resultCode == Activity.RESULT_OK
                || resultCode == Activity.RESULT_CANCELED

        val resultError =
            if (
                resultCode ==
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED
            )
            {
                "The in-app update flow failed."
            }
            else
            {
                ""
            }

        invokeCallback(
            callback,
            updateFlowResult(
                success,
                resultCode,
                resultError
            )
        )
    }

    fun onDestroy()
    {
        unregisterInstallListener()
        updateFlowCallback = null
        appUpdateInfo = null
        appUpdateManager = null
        scope.cancel()
    }

    // -------------------------------------------------------------------------
    // Async operations
    // -------------------------------------------------------------------------

    override fun inappupdate_request_info(
        callback: GMFunction
    )
    {
        val manager = manager()

        if (manager == null)
        {
            invokeCallback(
                callback,
                infoResult(
                    false,
                    null,
                    "RunnerActivity.CurrentActivity is unavailable."
                )
            )
            return
        }

        scope.launch {
            try
            {
                val info = manager.requestAppUpdateInfo()

                appUpdateInfo = info
                appUpdateInfoConsumed = false

                invokeCallback(
                    callback,
                    infoResult(true, info, "")
                )
            }
            catch (throwable: Throwable)
            {
                appUpdateInfo = null
                appUpdateInfoConsumed = false

                invokeCallback(
                    callback,
                    infoResult(
                        false,
                        null,
                        errorMessage(throwable)
                    )
                )
            }
        }
    }

    override fun inappupdate_show(
        update_type: InAppUpdateType,
        callback: GMFunction,
        install_status_callback: GMFunction
    )
    {
        val currentActivity = activity()
        val manager = manager()
        val info = appUpdateInfo

        if (currentActivity == null || manager == null)
        {
            invokeCallback(
                callback,
                updateFlowResult(
                    false,
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                    "RunnerActivity.CurrentActivity is unavailable."
                )
            )
            return
        }

        if (info == null)
        {
            invokeCallback(
                callback,
                updateFlowResult(
                    false,
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                    "Call inappupdate_request_info before inappupdate_show."
                )
            )
            return
        }

        if (appUpdateInfoConsumed)
        {
            invokeCallback(
                callback,
                updateFlowResult(
                    false,
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                    "The cached AppUpdateInfo was already used. Request fresh update information."
                )
            )
            return
        }

        val options =
            AppUpdateOptions
                .newBuilder(updateTypeValue(update_type))
                .build()

        if (!info.isUpdateTypeAllowed(options))
        {
            invokeCallback(
                callback,
                updateFlowResult(
                    false,
                    ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                    "The requested update type is not allowed."
                )
            )
            return
        }

        unregisterInstallListener()

        updateFlowCallback = callback
        installStatusCallback = install_status_callback

        installStateUpdatedListener =
            InstallStateUpdatedListener { state ->
                invokeCallback(
                    installStatusCallback,
                    installStateResult(true, state, "")
                )

                when (state.installStatus())
                {
                    InstallStatus.INSTALLED,
                    InstallStatus.FAILED,
                    InstallStatus.CANCELED ->
                        unregisterInstallListener()
                }
            }

        manager.registerListener(
            installStateUpdatedListener!!
        )

        currentActivity.runOnUiThread {
            try
            {
                val started =
                    manager.startUpdateFlowForResult(
                        info,
                        currentActivity,
                        options,
                        UPDATE_REQUEST_CODE
                    )

                if (started)
                {
                    appUpdateInfoConsumed = true
                }
                else
                {
                    updateFlowCallback = null
                    unregisterInstallListener()

                    invokeCallback(
                        callback,
                        updateFlowResult(
                            false,
                            ActivityResult
                                .RESULT_IN_APP_UPDATE_FAILED,
                            "The in-app update flow could not be started."
                        )
                    )
                }
            }
            catch (throwable: Throwable)
            {
                updateFlowCallback = null
                unregisterInstallListener()

                invokeCallback(
                    callback,
                    updateFlowResult(
                        false,
                        ActivityResult.RESULT_IN_APP_UPDATE_FAILED,
                        errorMessage(throwable)
                    )
                )
            }
        }
    }

    override fun inappupdate_complete_flexible_update(
        callback: GMFunction
    )
    {
        val manager = manager()

        if (manager == null)
        {
            invokeCallback(
                callback,
                completeResult(
                    false,
                    "RunnerActivity.CurrentActivity is unavailable."
                )
            )
            return
        }

        scope.launch {
            try
            {
                manager.requestCompleteUpdate()
                invokeCallback(
                    callback,
                    completeResult(true, "")
                )
            }
            catch (throwable: Throwable)
            {
                invokeCallback(
                    callback,
                    completeResult(
                        false,
                        errorMessage(throwable)
                    )
                )
            }
        }
    }

    // -------------------------------------------------------------------------
    // Cached synchronous information
    // -------------------------------------------------------------------------

    override fun inappupdate_available_version_code(): Int =
        appUpdateInfo?.availableVersionCode()
            ?: NO_INFO_INT

    override fun inappupdate_bytes_downloaded(): Long =
        appUpdateInfo?.bytesDownloaded()
            ?: NO_INFO_LONG

    override fun inappupdate_client_version_staleness_days(): Int
    {
        val info = appUpdateInfo ?: return NO_INFO_INT
        return info.clientVersionStalenessDays() ?: -1
    }

    override fun inappupdate_install_status():
        InAppUpdateInstallStatus =
        installStatusEnum(
            appUpdateInfo?.installStatus()
                ?: InstallStatus.UNKNOWN
        )

    override fun inappupdate_is_update_type_allowed(
        update_type: InAppUpdateType
    ): Boolean
    {
        val info = appUpdateInfo ?: return false

        val options =
            AppUpdateOptions
                .newBuilder(updateTypeValue(update_type))
                .build()

        return info.isUpdateTypeAllowed(options)
    }

    override fun inappupdate_package_name(): String =
        appUpdateInfo?.packageName() ?: ""

    override fun inappupdate_total_bytes_to_download(): Long =
        appUpdateInfo?.totalBytesToDownload()
            ?: NO_INFO_LONG

    override fun inappupdate_update_availability():
        InAppUpdateAvailability =
        availabilityEnum(
            appUpdateInfo?.updateAvailability()
                ?: UpdateAvailability.UNKNOWN
        )

    override fun inappupdate_info_availability(): Boolean =
        appUpdateInfo != null

    override fun inappupdate_update_priority(): Int =
        appUpdateInfo?.updatePriority()
            ?: NO_INFO_INT

    // -------------------------------------------------------------------------
    // Listener cleanup
    // -------------------------------------------------------------------------

    private fun unregisterInstallListener()
    {
        val manager = appUpdateManager
        val listener = installStateUpdatedListener

        if (manager != null && listener != null)
        {
            try
            {
                manager.unregisterListener(listener)
            }
            catch (throwable: Throwable)
            {
                Log.w(
                    TAG,
                    "Could not unregister update listener.",
                    throwable
                )
            }
        }

        installStateUpdatedListener = null
        installStatusCallback = null
    }
}