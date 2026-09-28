package object_modeling.assigment_problems;

public interface Capability {
    String getCapabilityName();
    String applyCommand(String deviceName, String command, Object value);
}
