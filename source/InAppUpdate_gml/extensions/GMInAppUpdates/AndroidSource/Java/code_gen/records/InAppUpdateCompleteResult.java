// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.records;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.codecs.*;

import java.nio.ByteBuffer;

public record InAppUpdateCompleteResult(boolean success, String error_message) implements GMExtWire.ITypedStruct
{
    public static final int CODEC_ID = 3;
    @Override
    public void encode(ByteBuffer b)
    {
        InAppUpdateCompleteResultCodec.write(b, this);
    }
}
