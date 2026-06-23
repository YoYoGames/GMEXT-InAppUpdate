// ##### extgen :: Auto-generated file do not edit!! #####

package ${YYAndroidPackageName}.enums;

public enum InAppUpdateAvailability
{
    Unknown((int)0),
    UpdateNotAvailable((int)1),
    UpdateAvailable((int)2),
    DeveloperTriggeredUpdateInProgress((int)3);

    private final int value;
    private InAppUpdateAvailability(int v)
    {
        this.value = v;
    }
    public int value()
    {
        return this.value;
    }
    public static InAppUpdateAvailability from(int v)
    {
        switch (v)
        {
            case 0:
                return InAppUpdateAvailability.Unknown;
            case 1:
                return InAppUpdateAvailability.UpdateNotAvailable;
            case 2:
                return InAppUpdateAvailability.UpdateAvailable;
            case 3:
                return InAppUpdateAvailability.DeveloperTriggeredUpdateInProgress;
            default:
                throw new IllegalArgumentException("Unknown InAppUpdateAvailability value: " + v);
        }
    }
}