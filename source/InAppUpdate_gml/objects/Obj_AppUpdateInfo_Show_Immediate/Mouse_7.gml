event_inherited();

inappupdate_request_info(
    function(_info)
    {
        show_debug_message($"Immediate update information: {_info}");

        if (!_info.success)
        {
            show_debug_message($"Could not request update information: {_info.error_message}");
            return;
        }

        if (!_info.info_available)
        {
            show_debug_message("Google Play did not return update information.");
            return;
        }

        if (
            _info.update_availability != InAppUpdateAvailability.UpdateAvailable
			&& _info.update_availability != InAppUpdateAvailability.DeveloperTriggeredUpdateInProgress)
        {
            show_debug_message("No immediate Google Play update is available.");
            return;
        }

        if (!inappupdate_is_update_type_allowed(InAppUpdateType.Immediate))
        {
            show_debug_message("An immediate update is not currently allowed.");
            return;
        }

        inappupdate_show(InAppUpdateType.Immediate,
            function(_flow)
            {
                show_debug_message($"Immediate update flow result: {_flow}");

                if (!_flow.success)
                {
                    show_debug_message($"Could not start the immediate update: {_flow.error_message}");
                    return;
                }

                switch (_flow.result)
                {
                    case InAppUpdateActivityResult.Accepted:
                        show_debug_message("Immediate update accepted.");
                    break;

                    case InAppUpdateActivityResult.Cancelled:
                        show_debug_message("Immediate update cancelled.");
                    break;

                    case InAppUpdateActivityResult.Failed:
                        show_debug_message("Immediate update flow failed.");
                    break;

                    case InAppUpdateActivityResult.Unknown:
                        show_debug_message("Unknown immediate update result.");
                    break;
                }
            },

            function(_state)
            {
                show_debug_message("Immediate update install state:");
                show_debug_message(_state);

                if (!_state.success)
                {
                    show_debug_message("Install-state error: {_state.error_message}");
                    return;
                }

                switch (_state.install_status)
                {
                    case InAppUpdateInstallStatus.Pending:
                        show_debug_message("Immediate update pending.");
                    break;

                    case InAppUpdateInstallStatus.Downloading:
                        show_debug_message("Immediate update downloading.");
                    break;

                    case InAppUpdateInstallStatus.Installing:
                        show_debug_message("Immediate update installing.");
                    break;

                    case InAppUpdateInstallStatus.Installed:
                        show_debug_message("Immediate update installed.");
                    break;

                    case InAppUpdateInstallStatus.Failed:
                        show_debug_message("Immediate update failed. Error code: {_state.install_error_code}");
                    break;

                    case InAppUpdateInstallStatus.Cancelled:
                        show_debug_message("Immediate update cancelled.");
                    break;

                    case InAppUpdateInstallStatus.Downloaded:
                        show_debug_message("Immediate update downloaded.");
                    break;

                    case InAppUpdateInstallStatus.Unknown:
                        show_debug_message("Unknown immediate update state.");
                    break;
                }
            }
        );
    }
);
