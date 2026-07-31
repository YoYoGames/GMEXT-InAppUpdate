// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.codecs;

import java.nio.ByteBuffer;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.records.*;

public final class InAppUpdateCompleteResultCodec {
    private InAppUpdateCompleteResultCodec()
    {
    }
    public static InAppUpdateCompleteResult read(ByteBuffer b)
    {
        boolean success = GMExtWire.readBool(b);

        String error_message = GMExtWire.readString(b);

        return new InAppUpdateCompleteResult(success, error_message);
    }

    public static void write(ByteBuffer b, InAppUpdateCompleteResult obj)
    {
        GMExtWire.writeBool(b, obj.success());

        GMExtWire.writeString(b, obj.error_message());

    }
}