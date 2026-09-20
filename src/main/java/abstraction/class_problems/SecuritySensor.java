package abstraction.class_problems;

public class SecuritySensor {
    private String zoneName;

    public SecuritySensor(String zoneName) {
        this.zoneName = zoneName;
    }

    public String getZoneName() {
        return zoneName;
    }

    public static void broadcastAll(Alertable[] devices, String message) {
        Alertable.broadcastAll(devices, message);
    }

    public static String getZoneIfMotionSensor(Alertable a) {
        return Alertable.getZoneIfMotionSensor(a);
    }
}
