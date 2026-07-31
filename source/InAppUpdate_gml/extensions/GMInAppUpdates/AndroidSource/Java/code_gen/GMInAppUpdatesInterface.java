// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName};
import ${YYAndroidPackageName}.GMExtWire.GMFunction;
import ${YYAndroidPackageName}.GMExtWire.GMValue;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public interface GMInAppUpdatesInterface {
    public void inappupdate_request_info(GMFunction callback);
    public void inappupdate_show(InAppUpdateType update_type, GMFunction callback, GMFunction install_status_callback);
    public void inappupdate_complete_flexible_update(GMFunction callback);
    public int inappupdate_available_version_code();
    public long inappupdate_bytes_downloaded();
    public int inappupdate_client_version_staleness_days();
    public InAppUpdateInstallStatus inappupdate_install_status();
    public boolean inappupdate_is_update_type_allowed(InAppUpdateType update_type);
    public String inappupdate_package_name();
    public long inappupdate_total_bytes_to_download();
    public InAppUpdateAvailability inappupdate_update_availability();
    public boolean inappupdate_info_availability();
    public int inappupdate_update_priority();
}