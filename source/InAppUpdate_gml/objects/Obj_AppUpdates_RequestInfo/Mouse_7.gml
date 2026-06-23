
inappupdate_request_info(function(_info)
{
    show_debug_message("inappupdate_request_info:");
    show_debug_message(_info);

    if (!_info.success)
    {
        show_debug_message(
            "Failed to request update information: " + _info.error);

        return;
    }

    if (!_info.info_available)
    {
        show_debug_message("Update information is not available.");
        return;
    }

    show_debug_message("AvailableVersionCode: " + string(_info.available_version_code));
    show_debug_message("PackageName: " + _info.package_name);
	show_debug_message("Priority: "+ string(_info.update_priority));
    show_debug_message("UpdateAvailability: " + string(_info.update_availability));
    show_debug_message("Immediate allowed: " + string(inappupdate_is_update_type_allowed(InAppUpdateType.Immediate)));

    show_debug_message("Flexible allowed: " + string(inappupdate_is_update_type_allowed(InAppUpdateType.Flexible)));

    if (_info.update_availability!= InAppUpdateAvailability.UpdateAvailable)
    {
        show_debug_message("No update is currently available.");
        return;
    }

    var _update_type;
    if (inappupdate_is_update_type_allowed(InAppUpdateType.Immediate))
        _update_type = InAppUpdateType.Immediate;
    else if (inappupdate_is_update_type_allowed(InAppUpdateType.Flexible))
        _update_type = InAppUpdateType.Flexible;
    else
    {
        show_debug_message("No supported update type is currently allowed.");
        return;
    }

    inappupdate_show(_update_type,
        function(_result)
        {
            show_debug_message("inappupdate_show:");
            show_debug_message(_result);

            if (!_result.success)
            {
                show_debug_message("Could not start the update flow: " + _result.error);
                return;
            }

            switch (_result.result)
            {
                case InAppUpdateActivityResult.Failed:
                    show_debug_message("inappupdate_show Failed");
                break;

                case InAppUpdateActivityResult.Accepted:
                    show_debug_message("inappupdate_show Accepted");
                break;

                case InAppUpdateActivityResult.Cancelled:
                    show_debug_message("inappupdate_show Cancelled");
                break;
            }
        },
        // Flexible-update download/install status callback
        function(_status)
        {
            show_debug_message("Install status update:");
            show_debug_message(_status);

            if (!_status.success)
            {
                show_debug_message(
                    "Install status error: "
                    + _status.error
                );

                return;
            }

            var _install_status = _status.install_status;
            var _bytes_downloaded = _status.bytes_downloaded;
            var _bytes_total = _status.total_bytes_to_download;

            switch (_install_status)
            {
                case InAppUpdateInstallStatus.Unknown:
                    show_debug_message("Install Status: UNKNOWN");
                break;

                case InAppUpdateInstallStatus.Pending:
                    show_debug_message("Install Status: PENDING");
                break;

                case InAppUpdateInstallStatus.Downloading:
                    var _percent = 0;

                    if (_bytes_total > 0)
                    {
                        _percent = (_bytes_downloaded / _bytes_total) * 100;
                    }

                    show_debug_message("Install Status: DOWNLOADING " + string(_percent) + "%");
                break;

                case InAppUpdateInstallStatus.Installing:
                    show_debug_message("Install Status: INSTALLING");
                break;

                case InAppUpdateInstallStatus.Installed:
                    show_debug_message("Install Status: INSTALLED");
                break;

                case InAppUpdateInstallStatus.Failed:
                    show_debug_message("Install Status: FAILED");
                    show_debug_message("Install error code: " + string(_status.install_error_code));
                break;

                case InAppUpdateInstallStatus.Cancelled:
                    show_debug_message("Install Status: CANCELLED");
                break;

                case InAppUpdateInstallStatus.Downloaded:
                    show_debug_message(
                        "Install Status: DOWNLOADED"
                    );

                    // Ask the user before completing the flexible update.
                    /*
                    inappupdate_complete_flexible_update(
                        function(_success, _error)
                        {
                            if (_success)
                                show_debug_message("Flexible update completion started.");
                            else
                                show_debug_message("Could not complete update: " + _error);
                        }
                    );
                    */
                break;
            }
        }
    );
});