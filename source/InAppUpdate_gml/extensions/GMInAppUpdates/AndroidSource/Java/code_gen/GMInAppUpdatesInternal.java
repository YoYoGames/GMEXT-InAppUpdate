// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName};

import java.nio.ByteBuffer;
import java.util.*;
import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.GMExtWire.GMFunction;
import ${YYAndroidPackageName}.GMExtWire.GMValue;
import ${YYAndroidPackageName}.records.*;
import ${YYAndroidPackageName}.codecs.*;
import ${YYAndroidPackageName}.enums.*;

public abstract class GMInAppUpdatesInternal extends RunnerSocial {

    private final GMInAppUpdatesKotlin __kotlin_instance = new GMInAppUpdatesKotlin();

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

        __kotlin_instance.inappupdate_request_info(callback);
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

        __kotlin_instance.inappupdate_show(update_type, callback, install_status_callback);
        return 0;
    }

    public double __EXT_NATIVE__inappupdate_complete_flexible_update(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: callback, type: Function
        GMFunction callback = GMExtWire.readGMFunction(__arg_buffer, __dispatch_queue);

        __kotlin_instance.inappupdate_complete_flexible_update(callback);
        return 0;
    }

    public double __EXT_NATIVE__inappupdate_available_version_code()
    {
        int __result = __kotlin_instance.inappupdate_available_version_code();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_bytes_downloaded(ByteBuffer __ret_buffer, double __ret_buffer_length)
    {
        long __result = __kotlin_instance.inappupdate_bytes_downloaded();

        GMExtWire.order(__ret_buffer);
        // return: __result, type: Int64
        GMExtWire.writeI64(__ret_buffer, __result);

        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_client_version_staleness_days()
    {
        int __result = __kotlin_instance.inappupdate_client_version_staleness_days();
        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_install_status(ByteBuffer __ret_buffer, double __ret_buffer_length)
    {
        InAppUpdateInstallStatus __result = __kotlin_instance.inappupdate_install_status();

        GMExtWire.order(__ret_buffer);
        // return: __result, type: enum InAppUpdateInstallStatus
        GMExtWire.writeI32(__ret_buffer, __result.value());

        return 0;
    }

    public double __EXT_NATIVE__inappupdate_is_update_type_allowed(ByteBuffer __arg_buffer, double __arg_buffer_length)
    {
        GMExtWire.order(__arg_buffer);

        // field: update_type, type: enum InAppUpdateType
        InAppUpdateType update_type = InAppUpdateType.from(GMExtWire.readI32(__arg_buffer));

        boolean __result = __kotlin_instance.inappupdate_is_update_type_allowed(update_type);
        return __result ? 1.0 : 0.0;
    }

    public String __EXT_NATIVE__inappupdate_package_name()
    {
        String __result = __kotlin_instance.inappupdate_package_name();
        return __result;
    }

    public double __EXT_NATIVE__inappupdate_total_bytes_to_download(ByteBuffer __ret_buffer, double __ret_buffer_length)
    {
        long __result = __kotlin_instance.inappupdate_total_bytes_to_download();

        GMExtWire.order(__ret_buffer);
        // return: __result, type: Int64
        GMExtWire.writeI64(__ret_buffer, __result);

        return (double)__result;
    }

    public double __EXT_NATIVE__inappupdate_update_availability(ByteBuffer __ret_buffer, double __ret_buffer_length)
    {
        InAppUpdateAvailability __result = __kotlin_instance.inappupdate_update_availability();

        GMExtWire.order(__ret_buffer);
        // return: __result, type: enum InAppUpdateAvailability
        GMExtWire.writeI32(__ret_buffer, __result.value());

        return 0;
    }

    public double __EXT_NATIVE__inappupdate_info_availability()
    {
        boolean __result = __kotlin_instance.inappupdate_info_availability();
        return __result ? 1.0 : 0.0;
    }

    public double __EXT_NATIVE__inappupdate_update_priority()
    {
        int __result = __kotlin_instance.inappupdate_update_priority();
        return (double)__result;
    }

}