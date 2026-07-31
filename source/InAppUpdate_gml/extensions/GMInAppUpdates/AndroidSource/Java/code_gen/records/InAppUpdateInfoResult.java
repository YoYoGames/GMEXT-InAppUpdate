// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.records;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.codecs.*;
import ${YYAndroidPackageName}.enums.*;

import java.nio.ByteBuffer;

public record InAppUpdateInfoResult(boolean success, boolean info_available, int available_version_code, long bytes_downloaded, int client_version_staleness_days, InAppUpdateInstallStatus install_status, String package_name, long total_bytes_to_download, InAppUpdateAvailability update_availability, int update_priority, String error_message) implements GMExtWire.ITypedStruct
{
    public static final int CODEC_ID = 0;
    @Override
    public void encode(ByteBuffer b)
    {
        InAppUpdateInfoResultCodec.write(b, this);
    }
}
