
if (!inappupdate_info_availability())
{
    exit;
}

draw_set_font(Font_YoYo_15);
draw_set_valign(fa_top);
draw_set_halign(fa_left);

var _bytes_downloaded = inappupdate_bytes_downloaded();

var _bytes_total = inappupdate_total_bytes_to_download();

var _progress = 0;

if (_bytes_total > 0)
{
    _progress = 100 * (_bytes_downloaded / _bytes_total);
}

var _install_status = inappupdate_install_status();

var _install_status_text = "UNKNOWN";

switch (_install_status)
{
    case InAppUpdateInstallStatus.Pending:
        _install_status_text = "PENDING";
    break;

    case InAppUpdateInstallStatus.Downloading:
        _install_status_text = "DOWNLOADING";
    break;

    case InAppUpdateInstallStatus.Downloaded:
        _install_status_text = "DOWNLOADED";
    break;

    case InAppUpdateInstallStatus.Installing:
        _install_status_text = "INSTALLING";
    break;

    case InAppUpdateInstallStatus.Installed:
        _install_status_text = "INSTALLED";
    break;

    case InAppUpdateInstallStatus.Failed:
        _install_status_text = "FAILED";
    break;

    case InAppUpdateInstallStatus.Cancelled:
        _install_status_text = "CANCELLED";
    break;
}

var _availability = inappupdate_update_availability();

var _availability_text = "UNKNOWN";

switch (_availability)
{
    case InAppUpdateAvailability.UpdateNotAvailable:
        _availability_text = "NOT AVAILABLE";
    break;

    case InAppUpdateAvailability.UpdateAvailable:
        _availability_text = "AVAILABLE";
    break;

    case InAppUpdateAvailability.DeveloperTriggeredUpdateInProgress:
        _availability_text = "DEVELOPER UPDATE IN PROGRESS";
    break;
}

draw_text(x,y,$"AvailableVersionCode: {inappupdate_available_version_code()}");

draw_text(x,y + 30,$"Progress: {_progress}%");

draw_text(x,y + 60,$"PackageName: {inappupdate_package_name()}");

draw_text(x,y + 90,$"InstallStatus: {_install_status_text}");

draw_text(x,y + 120,$"ClientVersionStalenessDays: {inappupdate_client_version_staleness_days()}");

draw_text(x,y + 150,$"UpdatePriority: {inappupdate_update_priority()})");

draw_text(x,y + 180,$"IMMEDIATE: {inappupdate_is_update_type_allowed(InAppUpdateType.Immediate)}");

draw_text(x,y + 210,$"FLEXIBLE: {inappupdate_is_update_type_allowed(InAppUpdateType.Flexible)}");

draw_text(x,y + 240,$"UpdateAvailability: {_availability_text}");
