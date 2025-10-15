
/**
 * @func inappupdate_package_name
 * @desc Returns the package name for the app to be updated.
 * @func_end
 */
function inappupdate_package_name() {}
  

/**
 * @func inappupdate_request_info
 * @desc Requests the update availability for the current app, an intent to start an update flow, and, if applicable, the state of updates currently in progress.
 *
 * @event social
 * @member {string} type The string value `"inappupdate_request_info"`
 * @member {bool} success The status code
 * @event_end
 *
 * @func_end
 */
function inappupdate_request_info() {}
  

/**
 * @func inappupdate_update_priority
 * @desc Returns the in-app update priority for this update, as defined by the developer in the Google Play Developer API. You can define in-app update priority of a release by setting inAppUpdatePriority field under
 * @return {number}
 * @func_end
 */
function inappupdate_update_priority() {}
  

/**
 * @func inappupdate_total_bytes_to_download
 * @desc Returns the total number of bytes to be downloaded for this update.
 * @return {number}
 * @func_end
 */  
function inappupdate_total_bytes_to_download() {}
  
  
/**
 * @func inappupdate_show
 * @desc Display a update popup and register a listener for install status updates.
 *
 * @event social
 * @desc Triggered when the update flow completes (user accepts/declines)
 * @member {string} type The string value `"inappupdate_show"`
 * @member {constant.UpdatePromptResult} result The result code from the update flow
 * @event_end
 * 
 * @event social
 * @desc Triggered during flexible updates to report download/install progress
 * @member {string} type The string value `"inappupdate_install_status_update"`
 * @member {constant.InstallStatus} install_status The current install status
 * @member {real} bytes_downloaded Number of bytes downloaded so far
 * @member {real} total_bytes_to_download Total bytes to download for this update
 * @event_end
 * 
 * @func_end
 */
function inappupdate_show() {}
  

/**
 * @func inappupdate_is_update_type_allowed
 * @desc Returns whether an update with the provided options is allowed.
 * @param {constant.AppUpdateType} update_option The update type to check.
 * @return {boolean}
 * @func_end
 */
function inappupdate_is_update_type_allowed(update_option) {}
        
		

/**
 * @func inappupdate_client_version_staleness_days
 * @desc If an update is available or in progress, this method returns the number of days since the Google Play Store app on the user's device has learnt about an available update.
 * @return {number}
 * @func_end
 */
function inappupdate_client_version_staleness_days() {}
  

/**
 * @func inappupdate_available_version_code
 * @desc If an update is available or in progress, this method returns the version code of the update. If no updates are available, this method returns an arbitrary value.
 * @return {string}
 * @func_end
 */
function inappupdate_available_version_code() {}
  
  
/**
 * @func inappupdate_info_availability
 * @desc 
 * @func_end
 */
function inappupdate_info_availability() {}
  

/**
 * @func inappupdate_install_status
 * @desc Returns the progress status of the update.
 * @returns {constant.InstallStatus}
 * @func_end
 */
function inappupdate_install_status() {}
  

/**
 * @func inappupdate_bytes_downloaded
 * @desc Returns the number of bytes downloaded so far.
 * @func_end
 */
function inappupdate_bytes_downloaded() {}
  

/**
 * @func inappupdate_update_availability
 * @desc Returns whether an update is available for the app.
 * @returns {constant.UpdateAvailability}
 * @func_end
 */
function inappupdate_update_availability() {}


/**
 * @func inappupdate_complete_flexible_update
 * @desc Completes a flexible in-app update that has finished downloading and triggers the installation process. The system will automatically restart the app once installation is complete. This function should only be called after receiving confirmation that a flexible update has been successfully downloaded (install status indicates download completion). Calling this function when no update is ready will have no effect.
 * @func_end
 */
function inappupdate_complete_flexible_update() {}



/**
 * @const AppUpdateType
 * @member InAppUpdate_FLEXIBLE
 * @member InAppUpdate_IMMEDIATE
 * @const_end
 */

/**
 * @const UpdateAvailability
 * @member InAppUpdate_UNKNOWN
 * @member InAppUpdate_UPDATE_NOT_AVAILABLE
 * @member InAppUpdate_UPDATE_AVAILABLE
 * @const_end
 */ 

/**
 * @const UpdatePromptResult
 * @member InAppUpdate_UPDATE_PROMPT_OK
 * @member InAppUpdate_UPDATE_PROMPT_FAILED
 * @member InAppUpdate_UPDATE_PROMPT_CANCELED
 * @const_end
 */ 
 
/**
 * @const InstallStatus
 * @member InAppUpdate_DEVELOPER_TRIGGERED_UPDATE_IN_PROGRESS
 * @member InAppUpdate_PENDING
 * @member InAppUpdate_DOWNLOADING
 * @member InAppUpdate_INSTALLING
 * @member InAppUpdate_INSTALLED
 * @member InAppUpdate_FAILED
 * @member InAppUpdate_CANCELED
 * @member InAppUpdate_DOWNLOADED
 * @member InAppUpdate_UPDATE_OK
 * @member InAppUpdate_UPDATE_FAILED
 * @member InAppUpdate_UPDATE_CANCELED
 * @const_end
 */


/**
 * @module home
 * @title In App Update
 * @desc 
 * @section_func
 *
 * @ref inappupdate_package_name
 * @ref inappupdate_request_info
 * @ref inappupdate_update_priority
 * @ref inappupdate_total_bytes_to_download
 * @ref inappupdate_show
 * @ref inappupdate_is_update_type_allowed
 * @ref inappupdate_client_version_staleness_days
 * @ref inappupdate_available_version_code
 * @ref inappupdate_info_availability
 * @ref inappupdate_install_status
 * @ref inappupdate_bytes_downloaded
 * @ref inappupdate_update_availability
 * @ref inappupdate_complete_flexible_update
 *
 * @section_end
 *
 * @section_const
 * @ref AppUpdateType
 * @ref UpdateAvailability
 * @ref UpdatePromptResult
 * @ref InstallStatus
 * @section_end
 *
 * @module_end
 */
 


 