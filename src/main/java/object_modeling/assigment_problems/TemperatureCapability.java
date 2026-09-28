package object_modeling.assigment_problems;

public class TemperatureCapability implements Capability {
    private double temperature;

    public TemperatureCapability() {
        this.temperature = 24.0;
    }

    @Override
    public String getCapabilityName() {
        return "Temperature";
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String applyCommand(String deviceName, String command, Object value) {
        double temp = Double.parseDouble(String.valueOf(value));
        if (temp < 16 || temp > 30) {
            return "Rejected: " + deviceName + " temperature must be between 16°C and 30°C.";
        }
        this.temperature = temp;
        return deviceName + ": temperature set to " + (int) temp + "°C.";
    }
}
