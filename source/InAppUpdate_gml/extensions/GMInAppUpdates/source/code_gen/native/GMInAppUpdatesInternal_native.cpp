// ##### extgen :: Auto-generated file do not edit!! #####

#include "GMInAppUpdatesInternal_native.h"
#include "GMInAppUpdatesInternal_exports.h"

using namespace gm_structs;
using namespace gm::wire::codec;

static gm::runtime::DispatchQueue __dispatch_queue;

// Internal function used for fetching dispatched function calls to GML
GMEXPORT double __EXT_NATIVE__GMInAppUpdates_invocation_handler(char* __ret_buffer, double __ret_buffer_length)
{
    gm::byteio::BufferWriter __bw{ __ret_buffer, static_cast<size_t>(__ret_buffer_length) };
    return __dispatch_queue.fetch(__bw);
}

GMEXPORT double __EXT_NATIVE__inappupdate_request_info(char* __arg_buffer, double __arg_buffer_length)
{
    gm::byteio::BufferReader __br{__arg_buffer, static_cast<size_t>(__arg_buffer_length)};

    // field: callback, type: Function
    gm::wire::GMFunction callback = gm::wire::codec::readFunction(__br, &__dispatch_queue);

    inappupdate_request_info(callback);
    return 0;
}

GMEXPORT double __EXT_NATIVE__inappupdate_show(char* __arg_buffer, double __arg_buffer_length)
{
    gm::byteio::BufferReader __br{__arg_buffer, static_cast<size_t>(__arg_buffer_length)};

    // field: update_type, type: enum InAppUpdateType
    gm_enums::InAppUpdateType update_type = gm::wire::codec::readValue<gm_enums::InAppUpdateType>(__br);

    // field: callback, type: Function
    gm::wire::GMFunction callback = gm::wire::codec::readFunction(__br, &__dispatch_queue);

    // field: install_status_callback, type: Function
    gm::wire::GMFunction install_status_callback = gm::wire::codec::readFunction(__br, &__dispatch_queue);

    inappupdate_show(update_type, callback, install_status_callback);
    return 0;
}

GMEXPORT double __EXT_NATIVE__inappupdate_available_version_code()
{
    auto&& __result = inappupdate_available_version_code();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_bytes_downloaded()
{
    auto&& __result = inappupdate_bytes_downloaded();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_client_version_staleness_days()
{
    auto&& __result = inappupdate_client_version_staleness_days();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_install_status()
{
    auto&& __result = inappupdate_install_status();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_is_update_type_allowed(char* __arg_buffer, double __arg_buffer_length)
{
    gm::byteio::BufferReader __br{__arg_buffer, static_cast<size_t>(__arg_buffer_length)};

    // field: update_type, type: enum InAppUpdateType
    gm_enums::InAppUpdateType update_type = gm::wire::codec::readValue<gm_enums::InAppUpdateType>(__br);

    auto&& __result = inappupdate_is_update_type_allowed(update_type);
    return static_cast<double>(__result);
}

GMEXPORT char* __EXT_NATIVE__inappupdate_package_name()
{
    static std::string __result;
    __result = inappupdate_package_name();
    return (char*)__result.c_str();
}

GMEXPORT double __EXT_NATIVE__inappupdate_total_bytes_to_download()
{
    auto&& __result = inappupdate_total_bytes_to_download();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_update_availability()
{
    auto&& __result = inappupdate_update_availability();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_info_availability()
{
    auto&& __result = inappupdate_info_availability();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_update_priority()
{
    auto&& __result = inappupdate_update_priority();
    return static_cast<double>(__result);
}

GMEXPORT double __EXT_NATIVE__inappupdate_complete_flexible_update(char* __arg_buffer, double __arg_buffer_length)
{
    gm::byteio::BufferReader __br{__arg_buffer, static_cast<size_t>(__arg_buffer_length)};

    // field: callback, type: Function
    gm::wire::GMFunction callback = gm::wire::codec::readFunction(__br, &__dispatch_queue);

    inappupdate_complete_flexible_update(callback);
    return 0;
}

