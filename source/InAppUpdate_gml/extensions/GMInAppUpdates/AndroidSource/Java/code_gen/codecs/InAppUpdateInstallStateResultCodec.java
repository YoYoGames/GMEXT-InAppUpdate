// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.codecs;

import java.nio.ByteBuffer;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public final class InAppUpdateInstallStateResultCodec {
    private InAppUpdateInstallStateResultCodec()
    {
    }
    public static InAppUpdateInstallStateResult read(ByteBuffer b)
    {
        boolean success = GMExtWire.readBool(b);

        InAppUpdateInstallStatus install_status = InAppUpdateInstallStatus.from(GMExtWire.readI32(b));

        long bytes_downloaded = GMExtWire.readI64(b);

        long total_bytes_to_download = GMExtWire.readI64(b);

        int install_error_code = GMExtWire.readI32(b);

        String package_name = GMExtWire.readString(b);

        String error_message = GMExtWire.readString(b);

        return new InAppUpdateInstallStateResult(success, install_status, bytes_downloaded, total_bytes_to_download, install_error_code, package_name, error_message);
    }

    public static void write(ByteBuffer b, InAppUpdateInstallStateResult obj)
    {
        GMExtWire.writeBool(b, obj.success());

        GMExtWire.writeI32(b, obj.install_status().value());

        GMExtWire.writeI64(b, obj.bytes_downloaded());

        GMExtWire.writeI64(b, obj.total_bytes_to_download());

        GMExtWire.writeI32(b, obj.install_error_code());

        GMExtWire.writeString(b, obj.package_name());

        GMExtWire.writeString(b, obj.error_message());

    }
}