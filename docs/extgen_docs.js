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
 * @function_partial inappupdate_complete_flexible_update
 * @param {Function} callback
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
 * @returns {Enum.InAppUpdateInstallStatus}
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
 * @returns {Enum.InAppUpdateAvailability}
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
 * @struct_partial InAppUpdateInfoResult
 * @member {Bool} success
 * @member {Bool} info_available
 * @member {Real} available_version_code
 * @member {Real} bytes_downloaded
 * @member {Real} client_version_staleness_days
 * @member {Enum.InAppUpdateInstallStatus} install_status
 * @member {String} package_name
 * @member {Real} total_bytes_to_download
 * @member {Enum.InAppUpdateAvailability} update_availability
 * @member {Real} update_priority
 * @member {String} error_message
 * @struct_end
 */

/**
 * @struct_partial InAppUpdateFlowResult
 * @member {Bool} success
 * @member {Enum.InAppUpdateActivityResult} result
 * @member {Bool} accepted
 * @member {Bool} cancelled
 * @member {Bool} failed
 * @member {String} error_message
 * @struct_end
 */

/**
 * @struct_partial InAppUpdateInstallStateResult
 * @member {Bool} success
 * @member {Enum.InAppUpdateInstallStatus} install_status
 * @member {Real} bytes_downloaded
 * @member {Real} total_bytes_to_download
 * @member {Real} install_error_code
 * @member {String} package_name
 * @member {String} error_message
 * @struct_end
 */

/**
 * @struct_partial InAppUpdateCompleteResult
 * @member {Bool} success
 * @member {String} error_message
 * @struct_end
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
 * @member Unknown
 * @member Accepted
 * @member Cancelled
 * @member Failed
 * @enum_end
 */

/**
 * @const_partial macros
 * @const_end
 */

