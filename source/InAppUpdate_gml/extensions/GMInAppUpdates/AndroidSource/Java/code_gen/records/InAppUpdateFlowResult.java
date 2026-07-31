// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.records;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.codecs.*;
import ${YYAndroidPackageName}.enums.*;

import java.nio.ByteBuffer;

public record InAppUpdateFlowResult(boolean success, InAppUpdateActivityResult result, boolean accepted, boolean cancelled, boolean failed, String error_message) implements GMExtWire.ITypedStruct
{
    public static final int CODEC_ID = 1;
    @Override
    public void encode(ByteBuffer b)
    {
        InAppUpdateFlowResultCodec.write(b, this);
    }
}
