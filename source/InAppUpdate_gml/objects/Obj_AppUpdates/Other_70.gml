
switch(async_load[?"type"])
{
	case "inappupdate_request_info":
	
		if(async_load[?"success"])
		{
			if(!inappupdate_info_availability())
				exit;
			
			show_debug_message("AvailableVersionCode: " + string(inappupdate_available_version_code()))
			show_debug_message("PackageName: " + inappupdate_package_name())
			show_debug_message("Priority: " + string(inappupdate_update_priority()))
		
			show_debug_message("inappupdate_UpdateAvailability(): " + string(inappupdate_update_availability()))
			show_debug_message("inappupdate_IsUpdateTypeAllowed(inappupdate_IMMEDIATE): " + string(inappupdate_is_update_type_allowed(InAppUpdate_IMMEDIATE)))
			show_debug_message("inappupdate_IsUpdateTypeAllowed(inappupdate_FLEXIBLE): " + string(inappupdate_is_update_type_allowed(InAppUpdate_FLEXIBLE)))
			
			if(inappupdate_update_availability() == InAppUpdate_UPDATE_AVAILABLE)
			{

				if(inappupdate_is_update_type_allowed(InAppUpdate_IMMEDIATE))
				{
					inappupdate_show(InAppUpdate_IMMEDIATE)
				}
				else if(inappupdate_is_update_type_allowed(InAppUpdate_FLEXIBLE))
				{
					inappupdate_show(InAppUpdate_FLEXIBLE)
				}		
			}
		}
	break
	
	case "inappupdate_show":
		
		switch(async_load[?"result"])
		{
			case InAppUpdate_UPDATE_FAILED:
				show_debug_message("inappupdate_show Failed")
			break
		
			case InAppUpdate_UPDATE_OK:
				show_debug_message("inappupdate_show OK")
			break
		
			case InAppUpdate_UPDATE_CANCELED:
				show_debug_message("inappupdate_show Canceled")
			break
		}
		
	break
	
	case "inappupdate_install_status_update":
		// Get install status info
		var _installStatus = ds_map_find_value(async_load, "install_status");
		var _bytesDownloaded = ds_map_find_value(async_load, "bytes_downloaded");
		var _bytesTotal = ds_map_find_value(async_load, "total_bytes_to_download");
		
		// React to install status
		switch (_installStatus)
		{
			case InAppUpdate_UNKNOWN:
				show_debug_message("Install Status: UNKNOWN");
			break;
			
			case InAppUpdate_PENDING:
				show_debug_message("Install Status: PENDING");
			break;
			
			case InAppUpdate_DOWNLOADING:
				// Get the download progress
				var _percent = 0;
				
				if (_bytesTotal > 0)
				{
					_percent = (_bytesDownloaded / _bytesTotal) * 100;
				}
				
				// Print debug info to console
				show_debug_message("Install Status: DOWNLOADING " + string(_percent) + "%");
			break;
			
			case InAppUpdate_INSTALLING:
				show_debug_message("Install Status: INSTALLING");
			break;
			
			case InAppUpdate_INSTALLED:
				show_debug_message("Install Status: INSTALLED");
			break;
			
			case InAppUpdate_FAILED:
				show_debug_message("Install Status: FAILED");
			break;
			
			case InAppUpdate_CANCELED:
				show_debug_message("Install Status: CANCELED");
			break;
			
			case InAppUpdate_DOWNLOADED:
				show_debug_message("Install Status: DOWNLOADED");
				
				// Download Complete - We can now call inappupdate_complete_flexible_update(), but we should ask the user for confirmation before doing so
			break;
		}
	break
}
