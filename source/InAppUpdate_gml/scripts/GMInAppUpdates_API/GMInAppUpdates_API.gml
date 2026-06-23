// ##### extgen :: Auto-generated file do not edit!! #####

// #####################################################################
// # Macros
// #####################################################################

// #####################################################################
// # Enums
// #####################################################################

enum InAppUpdateType
{
    Flexible = 0,
    Immediate = 1
}

enum InAppUpdateAvailability
{
    Unknown = 0,
    UpdateNotAvailable = 1,
    UpdateAvailable = 2,
    DeveloperTriggeredUpdateInProgress = 3
}

enum InAppUpdateInstallStatus
{
    Unknown = 0,
    Pending = 1,
    Downloading = 2,
    Installing = 3,
    Installed = 4,
    Failed = 5,
    Cancelled = 6,
    Downloaded = 11
}

enum InAppUpdateActivityResult
{
    Accepted = -1,
    Cancelled = 0,
    Failed = 1
}

// #####################################################################
// # Constructors
// #####################################################################

// #####################################################################
// # Codecs
// #####################################################################

// #####################################################################
// # Functions
// #####################################################################

/**
 * @param {Function} _callback
 */
function inappupdate_request_info(_callback)
{
    static __dispatcher = __GMInAppUpdates_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    var _return_value = __inappupdate_request_info(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return _return_value;
}

/**
 * @param {Enum.InAppUpdateType} _update_type
 * @param {Function} _callback
 * @param {Function} _install_status_callback
 */
function inappupdate_show(_update_type, _callback, _install_status_callback)
{
    static __dispatcher = __GMInAppUpdates_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _update_type, type: enum InAppUpdateType

    if (!is_numeric(_update_type)) show_error($"{_GMFUNCTION_} :: _update_type expected number", true);
    buffer_write(__args_buffer, buffer_s32, _update_type);

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    // param: _install_status_callback, type: Function
    if (!is_callable(_install_status_callback)) show_error($"{_GMFUNCTION_} :: _install_status_callback expected callable type", true);
    var _install_status_callback_handle = __ext_core_function_register(_install_status_callback, __dispatcher);
    buffer_write(__args_buffer, buffer_u64, _install_status_callback_handle);

    var _return_value = __inappupdate_show(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return _return_value;
}

// Skipping function inappupdate_available_version_code (no wrapper is required)


// Skipping function inappupdate_bytes_downloaded (no wrapper is required)


// Skipping function inappupdate_client_version_staleness_days (no wrapper is required)


// Skipping function inappupdate_install_status (no wrapper is required)


/**
 * @param {Enum.InAppUpdateType} _update_type
 * @returns {Bool} 
 */
function inappupdate_is_update_type_allowed(_update_type)
{
    var __args_buffer = __ext_core_get_args_buffer();

    // param: _update_type, type: enum InAppUpdateType

    if (!is_numeric(_update_type)) show_error($"{_GMFUNCTION_} :: _update_type expected number", true);
    buffer_write(__args_buffer, buffer_s32, _update_type);

    var _return_value = __inappupdate_is_update_type_allowed(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return _return_value;
}

// Skipping function inappupdate_package_name (no wrapper is required)


// Skipping function inappupdate_total_bytes_to_download (no wrapper is required)


// Skipping function inappupdate_update_availability (no wrapper is required)


// Skipping function inappupdate_info_availability (no wrapper is required)


// Skipping function inappupdate_update_priority (no wrapper is required)


/**
 * @param {Function} _callback
 */
function inappupdate_complete_flexible_update(_callback)
{
    static __dispatcher = __GMInAppUpdates_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    var _return_value = __inappupdate_complete_flexible_update(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return _return_value;
}

/// @ignore
function __GMInAppUpdates_get_decoders()
{
    static __decoders = [];
    return __decoders;
}
/// @ignore
function __GMInAppUpdates_get_dispatcher()
{
    static __dispatcher = new __GMNativeFunctionDispatcher(__GMInAppUpdates_invocation_handler, __GMInAppUpdates_get_decoders());
    return __dispatcher;
}
