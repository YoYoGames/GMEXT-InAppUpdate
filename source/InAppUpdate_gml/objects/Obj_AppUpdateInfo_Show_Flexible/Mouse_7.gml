
inappupdate_request_info(function(_result)
{
    show_debug_message(_result);

    if (!_result.success)
    {
        show_debug_message(_result.error);
        return;
    }

    show_debug_message(
        "Available version: "
        + string(_result.available_version_code)
    );

    show_debug_message(
        "Package name: "
        + _result.package_name
    );

    show_debug_message(
        "Update availability: "
        + string(_result.update_availability)
    );
});
