// ##### extgen :: Auto-generated file do not edit!! #####

#pragma once
#include <cstdint>
#include <string_view>
#include <vector>
#include <array>
#include <optional>
#include "core/GMExtWire.h"

namespace gm_consts
{
}


namespace gm_enums
{
    enum class InAppUpdateType : std::int32_t
    {
        Flexible = 0,
        Immediate = 1
    };

    enum class InAppUpdateAvailability : std::int32_t
    {
        Unknown = 0,
        UpdateNotAvailable = 1,
        UpdateAvailable = 2,
        DeveloperTriggeredUpdateInProgress = 3
    };

    enum class InAppUpdateInstallStatus : std::int32_t
    {
        Unknown = 0,
        Pending = 1,
        Downloading = 2,
        Installing = 3,
        Installed = 4,
        Failed = 5,
        Cancelled = 6,
        Downloaded = 11
    };

    enum class InAppUpdateActivityResult : std::int32_t
    {
        Accepted = -1,
        Cancelled = 0,
        Failed = 1
    };

}


namespace gm_structs
{

}

namespace gm::wire::codec
{
}

namespace gm::wire::details
{
}

void inappupdate_request_info(const gm::wire::GMFunction& callback);
void inappupdate_show(gm_enums::InAppUpdateType update_type, const gm::wire::GMFunction& callback, const gm::wire::GMFunction& install_status_callback);
double inappupdate_available_version_code();
double inappupdate_bytes_downloaded();
double inappupdate_client_version_staleness_days();
double inappupdate_install_status();
bool inappupdate_is_update_type_allowed(gm_enums::InAppUpdateType update_type);
std::string inappupdate_package_name();
double inappupdate_total_bytes_to_download();
double inappupdate_update_availability();
bool inappupdate_info_availability();
double inappupdate_update_priority();
void inappupdate_complete_flexible_update(const gm::wire::GMFunction& callback);
