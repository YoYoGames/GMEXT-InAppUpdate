// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName};
import ${YYAndroidPackageName}.GMExtWire.GMFunction;
import ${YYAndroidPackageName}.GMExtWire.GMValue;
import ${YYAndroidPackageName}.enums.*;

public interface GMInAppUpdatesInterface {
    public void inappupdate_request_info(GMFunction callback);
    public void inappupdate_show(InAppUpdateType update_type, GMFunction callback, GMFunction install_status_callback);
    public double inappupdate_available_version_code();
    public double inappupdate_bytes_downloaded();
    public double inappupdate_client_version_staleness_days();
    public double inappupdate_install_status();
    public boolean inappupdate_is_update_type_allowed(InAppUpdateType update_type);
    public String inappupdate_package_name();
    public double inappupdate_total_bytes_to_download();
    public double inappupdate_update_availability();
    public boolean inappupdate_info_availability();
    public double inappupdate_update_priority();
    public void inappupdate_complete_flexible_update(GMFunction callback);
}