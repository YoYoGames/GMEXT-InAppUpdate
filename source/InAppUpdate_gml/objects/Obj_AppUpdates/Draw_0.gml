
if(!inappupdate_info_availability())
	exit;

draw_set_font(Font_YoYo_15)
draw_set_valign(fa_top)
draw_set_halign(fa_left)

draw_text(x, y,"AvailableVersionCode: " + string(inappupdate_available_version_code()))
draw_text(x, y + 30,"process: " + string(100*inappupdate_bytes_downloaded()/inappupdate_total_bytes_to_download()) + "%")
draw_text(x, y + 60,"PackageName: " + inappupdate_package_name())
draw_text(x, y + 90,"InstallStatus: " + string(inappupdate_install_status()))
draw_text(x, y + 120,"ClientVersionStalenessDays: " + string(inappupdate_client_version_staleness_days()))
draw_text(x, y + 150,"IMMEDIATE: " + string(inappupdate_is_update_type_allowed(InAppUpdate_IMMEDIATE)))
draw_text(x, y + 180,"FLEXIBLE: " + string(inappupdate_is_update_type_allowed(InAppUpdate_FLEXIBLE)))
draw_text(x, y + 210,"UpdateAvailability: " + string(inappupdate_update_availability()))
