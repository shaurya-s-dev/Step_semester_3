package linked_list.class_problems;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem 1: Smart Home Platform
 *
 * TASK:
 * Create a smart home system to manage various devices. All devices have an ID and an on/off state.
 * Some devices might have additional capabilities: dimming (for lights), scheduling (for lights and fans),
 * or energy monitoring (for plugs). Implement a system that can process commands for these devices.
 * If a command is given for a capability that a specific device does not support, the system should reject the command.
 */
public class SmartHomePlatform {

    // Capability Interfaces
    public interface Dimmable {
        String dim(int level);
    }

    public interface Schedulable {
        String schedule(String time);
    }

    public interface EnergyMonitorable {
        String getEnergy();
    }

    // Abstract Base Device
    public static abstract class Device {
        protected String id;
        protected boolean isOn;

        public Device(String id) {
            this.id = id;
            this.isOn = false;
        }

        public String getId() {
            return id;
        }

        public boolean isOn() {
            return isOn;
        }

        public String turnOn() {
            this.isOn = true;
            return id + " is ON";
        }

        public String turnOff() {
            this.isOn = false;
            return id + " is OFF";
        }
    }

    // Concrete Devices
    public static class Light extends Device implements Dimmable, Schedulable {
        private int brightness;

        public Light(String id) {
            super(id);
            this.brightness = 100;
        }

        @Override
        public String dim(int level) {
            this.brightness = level;
            return id + " dimmed to " + level;
        }

        @Override
        public String schedule(String time) {
            return id + " scheduled " + time;
        }
    }

    public static class Fan extends Device implements Schedulable {
        public Fan(String id) {
            super(id);
        }

        @Override
        public String schedule(String time) {
            return id + " scheduled " + time;
        }
    }

    public static class SmartPlug extends Device implements EnergyMonitorable {
        private int energyKwh;

        public SmartPlug(String id, int energyKwh) {
            super(id);
            this.energyKwh = energyKwh;
        }

        @Override
        public String getEnergy() {
            return id + " energy " + energyKwh + " kWh";
        }
    }

    // Smart Home System Controller
    public static class SmartHomeSystem {
        private Map<String, Device> devices = new HashMap<>();

        public void addDevice(Device device) {
            devices.put(device.getId(), device);
        }

        public String processCommand(String commandLine) {
            if (commandLine == null || commandLine.trim().isEmpty()) {
                return "Empty command";
            }

            String[] parts = commandLine.trim().split("\\s+");
            String action = parts[0].toUpperCase();
            if (parts.length < 2) {
                return "Invalid command format";
            }
            String deviceId = parts[1];

            Device device = devices.get(deviceId);
            if (device == null) {
                return deviceId + " rejected: device not found";
            }

            switch (action) {
                case "ON":
                    return device.turnOn();

                case "OFF":
                    return device.turnOff();

                case "DIM":
                    if (device instanceof Dimmable) {
                        int level = parts.length > 2 ? Integer.parseInt(parts[2]) : 0;
                        return ((Dimmable) device).dim(level);
                    } else {
                        return deviceId + " rejected: DIM unsupported";
                    }

                case "SCHEDULE":
                    if (device instanceof Schedulable) {
                        String time = parts.length > 2 ? parts[2] : "";
                        return ((Schedulable) device).schedule(time);
                    } else {
                        return deviceId + " rejected: SCHEDULE unsupported";
                    }

                case "ENERGY":
                    if (device instanceof EnergyMonitorable) {
                        return ((EnergyMonitorable) device).getEnergy();
                    } else {
                        return deviceId + " rejected: ENERGY unsupported";
                    }

                default:
                    return deviceId + " rejected: unknown command " + action;
            }
        }
    }
}
