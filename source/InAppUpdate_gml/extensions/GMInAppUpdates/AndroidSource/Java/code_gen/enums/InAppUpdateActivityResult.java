// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum InAppUpdateActivityResult
{
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