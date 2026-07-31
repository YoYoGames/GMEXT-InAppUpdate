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
    Unknown = -2,
    Accepted = -1,
    Cancelled = 0,
    Failed = 1
}

// #####################################################################
// # Constructors
// #####################################################################

/**
 * @returns {Struct.InAppUpdateInfoResult}
 */
function InAppUpdateInfoResult() constructor
{
    /**
     * Internally generated hash for quick validation
     * @ignore
     */
    static __uid = 2558741217;

    self.success = undefined;
    self.info_available = undefined;
    self.available_version_code = undefined;
    self.bytes_downloaded = undefined;
    self.client_version_staleness_days = undefined;
    self.install_status = undefined;
    self.package_name = undefined;
    self.total_bytes_to_download = undefined;
    self.update_availability = undefined;
    self.update_priority = undefined;
    self.error_message = undefined;

}

/**
 * @returns {Struct.InAppUpdateFlowResult}
 */
function InAppUpdateFlowResult() constructor
{
    /**
     * Internally generated hash for quick validation
     * @ignore
     */
    static __uid = 2301085957;

    self.success = undefined;
    self.result = undefined;
    self.accepted = undefined;
    self.cancelled = undefined;
    self.failed = undefined;
    self.error_message = undefined;

}

/**
 * @returns {Struct.InAppUpdateInstallStateResult}
 */
function InAppUpdateInstallStateResult() constructor
{
    /**
     * Internally generated hash for quick validation
     * @ignore
     */
    static __uid = 2266300233;

    self.success = undefined;
    self.install_status = undefined;
    self.bytes_downloaded = undefined;
    self.total_bytes_to_download = undefined;
    self.install_error_code = undefined;
    self.package_name = undefined;
    self.error_message = undefined;

}

/**
 * @returns {Struct.InAppUpdateCompleteResult}
 */
function InAppUpdateCompleteResult() constructor
{
    /**
     * Internally generated hash for quick validation
     * @ignore
     */
    static __uid = 2561322146;

    self.success = undefined;
    self.error_message = undefined;

}

// #####################################################################
// # Codecs
// #####################################################################

/**
 * @func __InAppUpdateInfoResult_encode(_inst, _buffer, _offset, _where)
 * @param {Struct.InAppUpdateInfoResult} _inst
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @param {String} _where
 * @ignore
 */
function __InAppUpdateInfoResult_encode(_inst, _buffer, _offset, _where = _GMFUNCTION_)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);
    with (_inst)
    {
        // field: success, type: Bool
        if (!is_bool(self.success)) show_error($"{_where} :: self.success expected bool", true);
        buffer_write(_buffer, buffer_bool, self.success);

        // field: info_available, type: Bool
        if (!is_bool(self.info_available)) show_error($"{_where} :: self.info_available expected bool", true);
        buffer_write(_buffer, buffer_bool, self.info_available);

        // field: available_version_code, type: Int32
        if (!is_numeric(self.available_version_code)) show_error($"{_where} :: self.available_version_code expected number", true);
        buffer_write(_buffer, buffer_s32, self.available_version_code);

        // field: bytes_downloaded, type: Int64
        if (!is_numeric(self.bytes_downloaded)) show_error($"{_where} :: self.bytes_downloaded expected number", true);
        buffer_write(_buffer, buffer_u64, self.bytes_downloaded);

        // field: client_version_staleness_days, type: Int32
        if (!is_numeric(self.client_version_staleness_days)) show_error($"{_where} :: self.client_version_staleness_days expected number", true);
        buffer_write(_buffer, buffer_s32, self.client_version_staleness_days);

        // field: install_status, type: enum InAppUpdateInstallStatus

        if (!is_numeric(self.install_status)) show_error($"{_where} :: self.install_status expected number", true);
        buffer_write(_buffer, buffer_s32, self.install_status);

        // field: package_name, type: String
        if (!is_string(self.package_name)) show_error($"{_where} :: self.package_name expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.package_name));
        buffer_write(_buffer, buffer_string, self.package_name);

        // field: total_bytes_to_download, type: Int64
        if (!is_numeric(self.total_bytes_to_download)) show_error($"{_where} :: self.total_bytes_to_download expected number", true);
        buffer_write(_buffer, buffer_u64, self.total_bytes_to_download);

        // field: update_availability, type: enum InAppUpdateAvailability

        if (!is_numeric(self.update_availability)) show_error($"{_where} :: self.update_availability expected number", true);
        buffer_write(_buffer, buffer_s32, self.update_availability);

        // field: update_priority, type: Int32
        if (!is_numeric(self.update_priority)) show_error($"{_where} :: self.update_priority expected number", true);
        buffer_write(_buffer, buffer_s32, self.update_priority);

        // field: error_message, type: String
        if (!is_string(self.error_message)) show_error($"{_where} :: self.error_message expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.error_message));
        buffer_write(_buffer, buffer_string, self.error_message);

    }
}

/**
 * @func __InAppUpdateInfoResult_decode(_buffer, _offset)
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @returns {Struct.InAppUpdateInfoResult}
 * @ignore
 */
function __InAppUpdateInfoResult_decode(_buffer, _offset)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);

    _inst = new InAppUpdateInfoResult();
    with (_inst)
    {
        // field: success, type: Bool
        self.success = buffer_read(_buffer, buffer_bool);

        // field: info_available, type: Bool
        self.info_available = buffer_read(_buffer, buffer_bool);

        // field: available_version_code, type: Int32
        self.available_version_code = buffer_read(_buffer, buffer_s32);

        // field: bytes_downloaded, type: Int64
        self.bytes_downloaded = buffer_read(_buffer, buffer_u64);

        // field: client_version_staleness_days, type: Int32
        self.client_version_staleness_days = buffer_read(_buffer, buffer_s32);

        // field: install_status, type: enum InAppUpdateInstallStatus
        self.install_status = buffer_read(_buffer, buffer_s32);

        // field: package_name, type: String
        buffer_read(_buffer, buffer_u32);
        self.package_name = buffer_read(_buffer, buffer_string);

        // field: total_bytes_to_download, type: Int64
        self.total_bytes_to_download = buffer_read(_buffer, buffer_u64);

        // field: update_availability, type: enum InAppUpdateAvailability
        self.update_availability = buffer_read(_buffer, buffer_s32);

        // field: update_priority, type: Int32
        self.update_priority = buffer_read(_buffer, buffer_s32);

        // field: error_message, type: String
        buffer_read(_buffer, buffer_u32);
        self.error_message = buffer_read(_buffer, buffer_string);

    }

    return _inst;
}

/**
 * @func __InAppUpdateFlowResult_encode(_inst, _buffer, _offset, _where)
 * @param {Struct.InAppUpdateFlowResult} _inst
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @param {String} _where
 * @ignore
 */
function __InAppUpdateFlowResult_encode(_inst, _buffer, _offset, _where = _GMFUNCTION_)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);
    with (_inst)
    {
        // field: success, type: Bool
        if (!is_bool(self.success)) show_error($"{_where} :: self.success expected bool", true);
        buffer_write(_buffer, buffer_bool, self.success);

        // field: result, type: enum InAppUpdateActivityResult

        if (!is_numeric(self.result)) show_error($"{_where} :: self.result expected number", true);
        buffer_write(_buffer, buffer_s32, self.result);

        // field: accepted, type: Bool
        if (!is_bool(self.accepted)) show_error($"{_where} :: self.accepted expected bool", true);
        buffer_write(_buffer, buffer_bool, self.accepted);

        // field: cancelled, type: Bool
        if (!is_bool(self.cancelled)) show_error($"{_where} :: self.cancelled expected bool", true);
        buffer_write(_buffer, buffer_bool, self.cancelled);

        // field: failed, type: Bool
        if (!is_bool(self.failed)) show_error($"{_where} :: self.failed expected bool", true);
        buffer_write(_buffer, buffer_bool, self.failed);

        // field: error_message, type: String
        if (!is_string(self.error_message)) show_error($"{_where} :: self.error_message expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.error_message));
        buffer_write(_buffer, buffer_string, self.error_message);

    }
}

/**
 * @func __InAppUpdateFlowResult_decode(_buffer, _offset)
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @returns {Struct.InAppUpdateFlowResult}
 * @ignore
 */
function __InAppUpdateFlowResult_decode(_buffer, _offset)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);

    _inst = new InAppUpdateFlowResult();
    with (_inst)
    {
        // field: success, type: Bool
        self.success = buffer_read(_buffer, buffer_bool);

        // field: result, type: enum InAppUpdateActivityResult
        self.result = buffer_read(_buffer, buffer_s32);

        // field: accepted, type: Bool
        self.accepted = buffer_read(_buffer, buffer_bool);

        // field: cancelled, type: Bool
        self.cancelled = buffer_read(_buffer, buffer_bool);

        // field: failed, type: Bool
        self.failed = buffer_read(_buffer, buffer_bool);

        // field: error_message, type: String
        buffer_read(_buffer, buffer_u32);
        self.error_message = buffer_read(_buffer, buffer_string);

    }

    return _inst;
}

/**
 * @func __InAppUpdateInstallStateResult_encode(_inst, _buffer, _offset, _where)
 * @param {Struct.InAppUpdateInstallStateResult} _inst
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @param {String} _where
 * @ignore
 */
function __InAppUpdateInstallStateResult_encode(_inst, _buffer, _offset, _where = _GMFUNCTION_)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);
    with (_inst)
    {
        // field: success, type: Bool
        if (!is_bool(self.success)) show_error($"{_where} :: self.success expected bool", true);
        buffer_write(_buffer, buffer_bool, self.success);

        // field: install_status, type: enum InAppUpdateInstallStatus

        if (!is_numeric(self.install_status)) show_error($"{_where} :: self.install_status expected number", true);
        buffer_write(_buffer, buffer_s32, self.install_status);

        // field: bytes_downloaded, type: Int64
        if (!is_numeric(self.bytes_downloaded)) show_error($"{_where} :: self.bytes_downloaded expected number", true);
        buffer_write(_buffer, buffer_u64, self.bytes_downloaded);

        // field: total_bytes_to_download, type: Int64
        if (!is_numeric(self.total_bytes_to_download)) show_error($"{_where} :: self.total_bytes_to_download expected number", true);
        buffer_write(_buffer, buffer_u64, self.total_bytes_to_download);

        // field: install_error_code, type: Int32
        if (!is_numeric(self.install_error_code)) show_error($"{_where} :: self.install_error_code expected number", true);
        buffer_write(_buffer, buffer_s32, self.install_error_code);

        // field: package_name, type: String
        if (!is_string(self.package_name)) show_error($"{_where} :: self.package_name expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.package_name));
        buffer_write(_buffer, buffer_string, self.package_name);

        // field: error_message, type: String
        if (!is_string(self.error_message)) show_error($"{_where} :: self.error_message expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.error_message));
        buffer_write(_buffer, buffer_string, self.error_message);

    }
}

/**
 * @func __InAppUpdateInstallStateResult_decode(_buffer, _offset)
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @returns {Struct.InAppUpdateInstallStateResult}
 * @ignore
 */
function __InAppUpdateInstallStateResult_decode(_buffer, _offset)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);

    _inst = new InAppUpdateInstallStateResult();
    with (_inst)
    {
        // field: success, type: Bool
        self.success = buffer_read(_buffer, buffer_bool);

        // field: install_status, type: enum InAppUpdateInstallStatus
        self.install_status = buffer_read(_buffer, buffer_s32);

        // field: bytes_downloaded, type: Int64
        self.bytes_downloaded = buffer_read(_buffer, buffer_u64);

        // field: total_bytes_to_download, type: Int64
        self.total_bytes_to_download = buffer_read(_buffer, buffer_u64);

        // field: install_error_code, type: Int32
        self.install_error_code = buffer_read(_buffer, buffer_s32);

        // field: package_name, type: String
        buffer_read(_buffer, buffer_u32);
        self.package_name = buffer_read(_buffer, buffer_string);

        // field: error_message, type: String
        buffer_read(_buffer, buffer_u32);
        self.error_message = buffer_read(_buffer, buffer_string);

    }

    return _inst;
}

/**
 * @func __InAppUpdateCompleteResult_encode(_inst, _buffer, _offset, _where)
 * @param {Struct.InAppUpdateCompleteResult} _inst
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @param {String} _where
 * @ignore
 */
function __InAppUpdateCompleteResult_encode(_inst, _buffer, _offset, _where = _GMFUNCTION_)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);
    with (_inst)
    {
        // field: success, type: Bool
        if (!is_bool(self.success)) show_error($"{_where} :: self.success expected bool", true);
        buffer_write(_buffer, buffer_bool, self.success);

        // field: error_message, type: String
        if (!is_string(self.error_message)) show_error($"{_where} :: self.error_message expected string", true);
        buffer_write(_buffer, buffer_u32, string_byte_length(self.error_message));
        buffer_write(_buffer, buffer_string, self.error_message);

    }
}

/**
 * @func __InAppUpdateCompleteResult_decode(_buffer, _offset)
 * @param {Id.Buffer} _buffer
 * @param {Real} _offset
 * @returns {Struct.InAppUpdateCompleteResult}
 * @ignore
 */
function __InAppUpdateCompleteResult_decode(_buffer, _offset)
{
    buffer_seek(_buffer, buffer_seek_start, _offset);

    _inst = new InAppUpdateCompleteResult();
    with (_inst)
    {
        // field: success, type: Bool
        self.success = buffer_read(_buffer, buffer_bool);

        // field: error_message, type: String
        buffer_read(_buffer, buffer_u32);
        self.error_message = buffer_read(_buffer, buffer_string);

    }

    return _inst;
}

// #####################################################################
// # Functions
// #####################################################################

/**
 * @param {Function} _callback
 */
function inappupdate_request_info(_callback)
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __dispatcher__ = __GMInAppUpdates_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher__);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    var __return_value__ = __inappupdate_request_info(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

/**
 * @param {Enum.InAppUpdateType} _update_type
 * @param {Function} _callback
 * @param {Function} _install_status_callback
 */
function inappupdate_show(_update_type, _callback, _install_status_callback)
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __dispatcher__ = __GMInAppUpdates_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _update_type, type: enum InAppUpdateType

    if (!is_numeric(_update_type)) show_error($"{_GMFUNCTION_} :: _update_type expected number", true);
    buffer_write(__args_buffer, buffer_s32, _update_type);

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher__);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    // param: _install_status_callback, type: Function
    if (!is_callable(_install_status_callback)) show_error($"{_GMFUNCTION_} :: _install_status_callback expected callable type", true);
    var _install_status_callback_handle = __ext_core_function_register(_install_status_callback, __dispatcher__);
    buffer_write(__args_buffer, buffer_u64, _install_status_callback_handle);

    var __return_value__ = __inappupdate_show(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

/**
 * @param {Function} _callback
 */
function inappupdate_complete_flexible_update(_callback)
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __dispatcher__ = __GMInAppUpdates_get_dispatcher();

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _callback, type: Function
    if (!is_callable(_callback)) show_error($"{_GMFUNCTION_} :: _callback expected callable type", true);
    var _callback_handle = __ext_core_function_register(_callback, __dispatcher__);
    buffer_write(__args_buffer, buffer_u64, _callback_handle);

    var __return_value__ = __inappupdate_complete_flexible_update(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

// Skipping function inappupdate_available_version_code (no wrapper is required)


/**
 * @returns {Real}
 */
function inappupdate_bytes_downloaded()
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __ret_buffer = __ext_core_get_ret_buffer();

    var __return_value__ = __inappupdate_bytes_downloaded(buffer_get_address(__ret_buffer), buffer_get_size(__ret_buffer));

    var __result__ = undefined;
    __result__ = buffer_read(__ret_buffer, buffer_u64);
    return __result__;
}

// Skipping function inappupdate_client_version_staleness_days (no wrapper is required)


/**
 * @returns {Enum.InAppUpdateInstallStatus}
 */
function inappupdate_install_status()
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __ret_buffer = __ext_core_get_ret_buffer();

    var __return_value__ = __inappupdate_install_status(buffer_get_address(__ret_buffer), buffer_get_size(__ret_buffer));

    var __result__ = undefined;
    __result__ = buffer_read(__ret_buffer, buffer_s32);
    return __result__;
}

/**
 * @param {Enum.InAppUpdateType} _update_type
 * @returns {Bool}
 */
function inappupdate_is_update_type_allowed(_update_type)
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __args_buffer = __ext_core_get_args_buffer();

    // param: _update_type, type: enum InAppUpdateType

    if (!is_numeric(_update_type)) show_error($"{_GMFUNCTION_} :: _update_type expected number", true);
    buffer_write(__args_buffer, buffer_s32, _update_type);

    var __return_value__ = __inappupdate_is_update_type_allowed(buffer_get_address(__args_buffer), buffer_tell(__args_buffer));

    return __return_value__;
}

// Skipping function inappupdate_package_name (no wrapper is required)


/**
 * @returns {Real}
 */
function inappupdate_total_bytes_to_download()
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __ret_buffer = __ext_core_get_ret_buffer();

    var __return_value__ = __inappupdate_total_bytes_to_download(buffer_get_address(__ret_buffer), buffer_get_size(__ret_buffer));

    var __result__ = undefined;
    __result__ = buffer_read(__ret_buffer, buffer_u64);
    return __result__;
}

/**
 * @returns {Enum.InAppUpdateAvailability}
 */
function inappupdate_update_availability()
{
    var __available__ = __GMInAppUpdates_is_available();
    if (!__available__) return;

    var __ret_buffer = __ext_core_get_ret_buffer();

    var __return_value__ = __inappupdate_update_availability(buffer_get_address(__ret_buffer), buffer_get_size(__ret_buffer));

    var __result__ = undefined;
    __result__ = buffer_read(__ret_buffer, buffer_s32);
    return __result__;
}

// Skipping function inappupdate_info_availability (no wrapper is required)


// Skipping function inappupdate_update_priority (no wrapper is required)


/// @ignore
function __GMInAppUpdates_get_decoders()
{
    static __decoders__ = [
        __InAppUpdateInfoResult_decode,
        __InAppUpdateFlowResult_decode,
        __InAppUpdateInstallStateResult_decode,
        __InAppUpdateCompleteResult_decode
    ];
    return __decoders__;
}
/// @ignore
function __GMInAppUpdates_get_dispatcher()
{
    static __dispatcher__ = new __GMNativeFunctionDispatcher(__GMInAppUpdates_invocation_handler, __GMInAppUpdates_get_decoders());
    return __dispatcher__;
}
/// @ignore
function __GMInAppUpdates_is_available()
{
    static __available__ = extension_exists("GMInAppUpdates");
    return __available__;
}
