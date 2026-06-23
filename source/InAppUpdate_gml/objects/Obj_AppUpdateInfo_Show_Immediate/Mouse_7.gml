
inappupdate_show(
    InAppUpdateType.Immediate,
    function(_result)
    {
        show_debug_message(_result);

        if (!_result.success)
        {
            show_debug_message(_result.error);
            return;
        }

        switch (_result.result)
        {
            case InAppUpdateActivityResult.Accepted:
                show_debug_message("Update accepted.");
            break;

            case InAppUpdateActivityResult.Cancelled:
                show_debug_message("Update cancelled.");
            break;

            case InAppUpdateActivityResult.Failed:
                show_debug_message("Update prompt failed.");
            break;
        }
    },

    function(_status)
    {
        show_debug_message(_status);

        if (!_status.success)
            show_debug_message(_status.error);
    }
);