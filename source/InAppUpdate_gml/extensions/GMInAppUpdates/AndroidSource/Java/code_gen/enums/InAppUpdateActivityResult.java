// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum InAppUpdateActivityResult
{
    Unknown((int)-2),
    Accepted((int)-1),
    Cancelled((int)0),
    Failed((int)1);

    private final int value;
    private InAppUpdateActivityResult(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static InAppUpdateActivityResult from(int v)
    {
        switch (v)
        {
            case -2:
                return InAppUpdateActivityResult.Unknown;
            case -1:
                return InAppUpdateActivityResult.Accepted;
            case 0:
                return InAppUpdateActivityResult.Cancelled;
            case 1:
                return InAppUpdateActivityResult.Failed;
            default:
                throw new IllegalArgumentException("Unknown InAppUpdateActivityResult value: " + v);
        }
    }
}