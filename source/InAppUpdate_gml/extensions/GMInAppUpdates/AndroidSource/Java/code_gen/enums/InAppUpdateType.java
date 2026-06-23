// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum InAppUpdateType
{
    Flexible((int)0),
    Immediate((int)1);

    private final int value;
    private InAppUpdateType(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static InAppUpdateType from(int v)
    {
        switch (v)
        {
            case 0:
                return InAppUpdateType.Flexible;
            case 1:
                return InAppUpdateType.Immediate;
            default:
                throw new IllegalArgumentException("Unknown InAppUpdateType value: " + v);
        }
    }
}