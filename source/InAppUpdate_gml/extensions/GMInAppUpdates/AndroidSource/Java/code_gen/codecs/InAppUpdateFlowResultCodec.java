// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.codecs;

import java.nio.ByteBuffer;

import ${YYAndroidPackageName}.GMExtWire;
import ${YYAndroidPackageName}.enums.*;
import ${YYAndroidPackageName}.records.*;

public final class InAppUpdateFlowResultCodec {
    private InAppUpdateFlowResultCodec()
    {
    }
    public static InAppUpdateFlowResult read(ByteBuffer b)
    {
        boolean success = GMExtWire.readBool(b);

        InAppUpdateActivityResult result = InAppUpdateActivityResult.from(GMExtWire.readI32(b));

        boolean accepted = GMExtWire.readBool(b);

        boolean cancelled = GMExtWire.readBool(b);

        boolean failed = GMExtWire.readBool(b);

        String error_message = GMExtWire.readString(b);

        return new InAppUpdateFlowResult(success, result, accepted, cancelled, failed, error_message);
    }

    public static void write(ByteBuffer b, InAppUpdateFlowResult obj)
    {
        GMExtWire.writeBool(b, obj.success());

        GMExtWire.writeI32(b, obj.result().value());

        GMExtWire.writeBool(b, obj.accepted());

        GMExtWire.writeBool(b, obj.cancelled());

        GMExtWire.writeBool(b, obj.failed());

        GMExtWire.writeString(b, obj.error_message());

    }
}