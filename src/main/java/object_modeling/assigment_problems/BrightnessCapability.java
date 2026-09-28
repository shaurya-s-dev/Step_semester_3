package object_modeling.assigment_problems;

public class BrightnessCapability implements Capability {
    private int brightness;

    public BrightnessCapability() {
        this.brightness = 0;
    }

    @Override
    public String getCapabilityName() {
        return "Brightness";
    }

    public int getBrightness() {
        return brightness;
    }

    @Override
    public String applyCommand(String deviceName, String command, Object value) {
        int level = Integer.parseInt(String.valueOf(value));
        if (level < 0 || level > 100) {
            return "Rejected: " + deviceName + " brightness must be between 0% and 100%.";
        }
        this.brightness = level;
        return deviceName + ": brightness set to " + level + "%.";
    }
}
