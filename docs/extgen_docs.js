/**
 * @function_partial inappupdate_request_info
 * @param {Function} callback
 * @function_end 
 */

/**
 * @function_partial inappupdate_show
 * @param {Enum.InAppUpdateType} update_type
 * @param {Function} callback
 * @param {Function} install_status_callback
 * @function_end 
 */

/**
 * @function_partial inappupdate_available_version_code
 * @returns {Real} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_bytes_downloaded
 * @returns {Real} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_client_version_staleness_days
 * @returns {Real} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_install_status
 * @returns {Real} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_is_update_type_allowed
 * @param {Enum.InAppUpdateType} update_type
 * @returns {Bool} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_package_name
 * @returns {String} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_total_bytes_to_download
 * @returns {Real} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_update_availability
 * @returns {Real} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_info_availability
 * @returns {Bool} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_update_priority
 * @returns {Real} 
 * @function_end 
 */

/**
 * @function_partial inappupdate_complete_flexible_update
 * @param {Function} callback
 * @function_end 
 */

/**
 * @enum_partial InAppUpdateType
 * @member Flexible
 * @member Immediate
 * @enum_end 
 */

/**
 * @enum_partial InAppUpdateAvailability
 * @member Unknown
 * @member UpdateNotAvailable
 * @member UpdateAvailable
 * @member DeveloperTriggeredUpdateInProgress
 * @enum_end 
 */

/**
 * @enum_partial InAppUpdateInstallStatus
 * @member Unknown
 * @member Pending
 * @member Downloading
 * @member Installing
 * @member Installed
 * @member Failed
 * @member Cancelled
 * @member Downloaded
 * @enum_end 
 */

/**
 * @enum_partial InAppUpdateActivityResult
 * @member Accepted
 * @member Cancelled
 * @member Failed
 * @enum_end 
 */

/**
 * @const_partial macros
 * @const_end 
 */

