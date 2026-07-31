// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.codecs;

import java.nio.ByteBuffer;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public final class InAppUpdateInfoResultCodec {
    private InAppUpdateInfoResultCodec()
    {
    }
    public static InAppUpdateInfoResult read(ByteBuffer b)
    {
        boolean success = GMExtWire.readBool(b);

        boolean info_available = GMExtWire.readBool(b);

        int available_version_code = GMExtWire.readI32(b);

        long bytes_downloaded = GMExtWire.readI64(b);

        int client_version_staleness_days = GMExtWire.readI32(b);

        InAppUpdateInstallStatus install_status = InAppUpdateInstallStatus.from(GMExtWire.readI32(b));

        String package_name = GMExtWire.readString(b);

        long total_bytes_to_download = GMExtWire.readI64(b);

        InAppUpdateAvailability update_availability = InAppUpdateAvailability.from(GMExtWire.readI32(b));

        int update_priority = GMExtWire.readI32(b);

        String error_message = GMExtWire.readString(b);

        return new InAppUpdateInfoResult(success, info_available, available_version_code, bytes_downloaded, client_version_staleness_days, install_status, package_name, total_bytes_to_download, update_availability, update_priority, error_message);
    }

    public static void write(ByteBuffer b, InAppUpdateInfoResult obj)
    {
        GMExtWire.writeBool(b, obj.success());

        GMExtWire.writeBool(b, obj.info_available());

        GMExtWire.writeI32(b, obj.available_version_code());

        GMExtWire.writeI64(b, obj.bytes_downloaded());

        GMExtWire.writeI32(b, obj.client_version_staleness_days());

        GMExtWire.writeI32(b, obj.install_status().value());

        GMExtWire.writeString(b, obj.package_name());

        GMExtWire.writeI64(b, obj.total_bytes_to_download());

        GMExtWire.writeI32(b, obj.update_availability().value());

        GMExtWire.writeI32(b, obj.update_priority());

        GMExtWire.writeString(b, obj.error_message());

    }
}