event_inherited();

inappupdate_request_info(
    function(_info)
    {
        show_debug_message($"inappupdate_request_info: {_info}");

        if (!_info.success)
        {
            show_debug_message($"Failed to request update information: {_info.error_message}");
            return;
        }

        if (!_info.info_available)
        {
            show_debug_message("Update information is not available.");
            return;
        }

        show_debug_message($"Available version code: {_info.available_version_code}");

        show_debug_message($"Package name: {_info.package_name}");

        show_debug_message($"Update priority: {_info.update_priority}");

        show_debug_message($"Client version staleness days: {_info.client_version_staleness_days}");

        show_debug_message($"Downloaded bytes: {_info.bytes_downloaded}");

        show_debug_message($"Total download bytes: {_info.total_bytes_to_download}");

        switch (_info.update_availability)
        {
            case InAppUpdateAvailability.UpdateNotAvailable:
                show_debug_message(
                    "Update availability: NOT AVAILABLE"
                );
            break;

            case InAppUpdateAvailability.UpdateAvailable:
                show_debug_message("Update availability: AVAILABLE");
            break;

            case InAppUpdateAvailability.DeveloperTriggeredUpdateInProgress:
                show_debug_message(
                    "Update availability: DEVELOPER-TRIGGERED UPDATE IN PROGRESS"
                );
            break;

            case InAppUpdateAvailability.Unknown:
                show_debug_message("Update availability: UNKNOWN");
            break;
        }

        switch (_info.install_status)
        {
            case InAppUpdateInstallStatus.Pending:
                show_debug_message("Install status: PENDING");
            break;

            case InAppUpdateInstallStatus.Downloading:
                show_debug_message("Install status: DOWNLOADING");
            break;

            case InAppUpdateInstallStatus.Downloaded:
                show_debug_message("Install status: DOWNLOADED");
            break;

            case InAppUpdateInstallStatus.Installing:
                show_debug_message("Install status: INSTALLING");
            break;

            case InAppUpdateInstallStatus.Installed:
                show_debug_message("Install status: INSTALLED");
            break;

            case InAppUpdateInstallStatus.Failed:
                show_debug_message("Install status: FAILED");
            break;

            case InAppUpdateInstallStatus.Cancelled:
                show_debug_message("Install status: CANCELLED");
            break;

            case InAppUpdateInstallStatus.Unknown:
                show_debug_message("Install status: UNKNOWN");
            break;
        }

        show_debug_message($"Immediate update allowed: {inappupdate_is_update_type_allowed(InAppUpdateType.Immediate)}");

        show_debug_message($"Flexible update allowed: {inappupdate_is_update_type_allowed(InAppUpdateType.Flexible)}");
    }
);
