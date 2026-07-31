// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.records;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.codecs.*;
import ${YYAndroidPackageName}.enums.*;

import java.nio.ByteBuffer;

public record InAppUpdateInstallStateResult(boolean success, InAppUpdateInstallStatus install_status, long bytes_downloaded, long total_bytes_to_download, int install_error_code, String package_name, String error_message) implements GMExtWire.ITypedStruct
{
    public static final int CODEC_ID = 2;
    @Override
    public void encode(ByteBuffer b)
    {
        InAppUpdateInstallStateResultCodec.write(b, this);
    }
}
