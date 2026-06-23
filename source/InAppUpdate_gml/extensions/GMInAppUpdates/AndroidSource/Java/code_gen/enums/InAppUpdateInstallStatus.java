// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum InAppUpdateInstallStatus
{
    Unknown((int)0),
    Pending((int)1),
    Downloading((int)2),
    Installing((int)3),
    Installed((int)4),
    Failed((int)5),
    Cancelled((int)6),
    Downloaded((int)11);

    private final int value;
    private InAppUpdateInstallStatus(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static InAppUpdateInstallStatus from(int v)
    {
        switch (v)
        {
            case 0:
                return InAppUpdateInstallStatus.Unknown;
            case 1:
                return InAppUpdateInstallStatus.Pending;
            case 2:
                return InAppUpdateInstallStatus.Downloading;
            case 3:
                return InAppUpdateInstallStatus.Installing;
            case 4:
                return InAppUpdateInstallStatus.Installed;
            case 5:
                return InAppUpdateInstallStatus.Failed;
            case 6:
                return InAppUpdateInstallStatus.Cancelled;
            case 11:
                return InAppUpdateInstallStatus.Downloaded;
            default:
                throw new IllegalArgumentException("Unknown InAppUpdateInstallStatus value: " + v);
        }
    }
}