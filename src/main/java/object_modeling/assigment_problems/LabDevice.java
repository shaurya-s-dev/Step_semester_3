package object_modeling.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class LabDevice {
    private String name;
    private List<Capability> capabilities;

    public LabDevice(String name) {
        this.name = name;
        this.capabilities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addCapability(Capability capability) {
        this.capabilities.add(capability);
    }

    public boolean hasCapability(String capabilityName) {
        for (Capability c : capabilities) {
            if (c.getCapabilityName().equalsIgnoreCase(capabilityName)) {
                return true;
            }
        }
        return false;
    }

    public String applyCommand(String capabilityName, String command, Object value) {
        for (Capability c : capabilities) {
            if (c.getCapabilityName().equalsIgnoreCase(capabilityName)) {
                return c.applyCommand(name, command, value);
            }
        }
        return name + ": does not support " + capabilityName + ".";
    }
}
