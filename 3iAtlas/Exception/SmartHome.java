package Exception;

class DeviceNotConnectedException extends Exception {
    public DeviceNotConnectedException(String msg) { super(msg); }
}

class InvalidDeviceCommandException extends Exception {
    public InvalidDeviceCommandException(String msg) { super(msg); }
}

class Device {
    String name;
    boolean connected;

    public Device(String name, boolean connected) {
        this.name = name; this.connected = connected;
    }

    public void performAction(String action)
            throws DeviceNotConnectedException, InvalidDeviceCommandException {
        if (!connected) throw new DeviceNotConnectedException(name + " is offline!");
        if (!action.equalsIgnoreCase("on") && !action.equalsIgnoreCase("off"))
            throw new InvalidDeviceCommandException("Invalid command: " + action);
        System.out.println(name + " turned " + action);
    }
}

public class SmartHome {
    public static void main(String[] args) {
        Device light = new Device("Light", true);
        Device ac = new Device("AC", false);

        try {
            light.performAction("on");
            ac.performAction("off");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            light.performAction("blink"); // invalid command
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
