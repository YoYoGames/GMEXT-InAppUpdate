// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName};

import java.nio.ByteBuffer;
import java.util.*;
import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.GMExtWire.GMFunction;
import ${YYAndroidPackageName}.GMExtWire.GMValue;
import ${YYAndroidPackageName}.enums.*;

public abstract class GMInAppUpdatesInternal extends RunnerSocial implements GMInAppUpdatesInterface {

    private final GMExtWire.DispatchQueue __dispatch_queue = new GMExtWire.DispatchQueue();
    public double __EXT_NATIVE__GMInAppUpdates_invocation_handler(ByteBuffer __ret_buffer, double __ret_buffer_length)
    {
        return __dispatch_queue.fetch(__ret_buffer);
    }

    public double __EXT_NATIVE__inappupdate_request_info(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: callback, type: Function
        GMFunction callback = GMExtWire.readGMFunction(__arg_buffer, __dispatch_queue);

        inappupdate_request_info(callback);
        return 0;
    }

    public double __EXT_NATIVE__inappupdate_show(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: update_type, type: enum InAppUpdateType
        InAppUpdateType update_type = InAppUpdateType.from(GMExtWire.readI32(__arg_buffer));

        // field: callback, type: Function
        GMFunction callback = GMExtWire.readGMFunction(__arg_buffer, __dispatch_queue);

        // field: install_status_callback, type: Function
        GMFunction install_status_callback = GMExtWire.readGMFunction(__arg_buffer, __dispatch_queue);

        inappupdate_show(update_type, callback, install_status_callback);
        return 0;
    }

    public double __EXT_NATIVE__inappupdate_available_version_code()
    {
        double __result = inappupdate_available_version_code();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_bytes_downloaded()
    {
        double __result = inappupdate_bytes_downloaded();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_client_version_staleness_days()
    {
        double __result = inappupdate_client_version_staleness_days();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_install_status()
    {
        double __result = inappupdate_install_status();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_is_update_type_allowed(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: update_type, type: enum InAppUpdateType
        InAppUpdateType update_type = InAppUpdateType.from(GMExtWire.readI32(__arg_buffer));

        boolean __result = inappupdate_is_update_type_allowed(update_type);
        return __result ? 1.0 : 0.0;
    }

    public String __EXT_NATIVE__inappupdate_package_name()
    {
        String __result = inappupdate_package_name();
        return __result;
    }

    public double __EXT_NATIVE__inappupdate_total_bytes_to_download()
    {
        double __result = inappupdate_total_bytes_to_download();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_update_availability()
    {
        double __result = inappupdate_update_availability();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_info_availability()
    {
        boolean __result = inappupdate_info_availability();
        return __result ? 1.0 : 0.0;
    }

    public double __EXT_NATIVE__inappupdate_update_priority()
    {
        double __result = inappupdate_update_priority();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_complete_flexible_update(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: callback, type: Function
        GMFunction callback = GMExtWire.readGMFunction(__arg_buffer, __dispatch_queue);

        inappupdate_complete_flexible_update(callback);
        return 0;
    }

}