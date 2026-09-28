package object_modeling.assigment_problems;

public class PowerCapability implements Capability {
    private boolean powerOn;

    public PowerCapability() {
        this.powerOn = false;
    }

    @Override
    public String getCapabilityName() {
        return "Power";
    }

    public boolean isPowerOn() {
        return powerOn;
    }

    @Override
    public String applyCommand(String deviceName, String command, Object value) {
        if ("POWER".equalsIgnoreCase(command) || "SET".equalsIgnoreCase(command)) {
            String state = String.valueOf(value);
            this.powerOn = "ON".equalsIgnoreCase(state);
            return deviceName + ": " + (powerOn ? "ON" : "OFF");
        }
        return deviceName + ": unsupported command";
    }
}
