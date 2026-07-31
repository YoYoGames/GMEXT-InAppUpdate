event_inherited();

inappupdate_request_info(
    function(_info)
    {
        show_debug_message("Flexible update information:");
        show_debug_message(_info);

        if (!_info.success)
        {
            show_debug_message("Could not request update information: {_info.error_message}");
            return;
        }

        if (!_info.info_available)
        {
            show_debug_message("Google Play did not return update information.");
            return;
        }

        if (_info.update_availability != InAppUpdateAvailability.UpdateAvailable)
        {
            show_debug_message("No Google Play update is currently available.");
            return;
        }

        if (!inappupdate_is_update_type_allowed(InAppUpdateType.Flexible))
        {
            show_debug_message("A flexible update is not currently allowed.");
            return;
        }

        inappupdate_show(InAppUpdateType.Flexible,
            function(_flow)
            {
                show_debug_message($"Flexible update flow result: {_flow}");

                if (!_flow.success)
                {
                    show_debug_message($"Could not start the flexible update: {_flow.error_message}");
                    return;
                }

                switch (_flow.result)
                {
                    case InAppUpdateActivityResult.Accepted:
                        show_debug_message("Flexible update accepted.");
                    break;

                    case InAppUpdateActivityResult.Cancelled:
                        show_debug_message("Flexible update cancelled.");
                    break;

                    case InAppUpdateActivityResult.Failed:
                        show_debug_message("Flexible update flow failed.");
                    break;

                    case InAppUpdateActivityResult.Unknown:
                        show_debug_message("Unknown flexible update result.");
                    break;
                }
            },

            function(_state)
            {
                show_debug_message($"Flexible update install state: {_state}");

                if (!_state.success)
                {
                    show_debug_message("Install-state error: {_state.error_message}");
                    return;
                }

                switch (_state.install_status)
                {
                    case InAppUpdateInstallStatus.Pending:
                        show_debug_message("Flexible update pending.");
                    break;

                    case InAppUpdateInstallStatus.Downloading:
                        var _percent = 0;

                        if (_state.total_bytes_to_download > 0)
                        {
                            _percent = 100 * (_state.bytes_downloaded / _state.total_bytes_to_download);
                        }

                        show_debug_message($"Flexible update downloading: {_percent}%");
                    break;

                    case InAppUpdateInstallStatus.Downloaded:
                        show_debug_message("Flexible update downloaded. Completing update...");

                        inappupdate_complete_flexible_update(
                            function(_complete)
                            {
                                if (_complete.success)
                                {
                                    show_debug_message("Flexible update completion started.");
                                }
                                else
                                {
                                    show_debug_message("Could not complete the flexible update: {_complete.error_message}");
                                }
                            }
                        );
                    break;

                    case InAppUpdateInstallStatus.Installing:
                        show_debug_message("Flexible update installing.");
                    break;

                    case InAppUpdateInstallStatus.Installed:
                        show_debug_message("Flexible update installed.");
                    break;

                    case InAppUpdateInstallStatus.Failed:
                        show_debug_message($"Flexible update failed. Error code: {_state.install_error_code}");
                    break;

                    case InAppUpdateInstallStatus.Cancelled:
                        show_debug_message("Flexible update cancelled.");
                    break;

                    case InAppUpdateInstallStatus.Unknown:
                        show_debug_message("Unknown flexible update state.");
                    break;
                }
            }
        );
    }
);
