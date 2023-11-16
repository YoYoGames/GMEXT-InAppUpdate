
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
}
