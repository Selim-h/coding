package Exception;

class FuelShortageException extends Exception {
    public FuelShortageException(String msg) { super(msg); }
}

class EngineFailureException extends Exception {
    public EngineFailureException(String msg) { super(msg); }
}

class WeatherNotSuitableException extends Exception {
    public WeatherNotSuitableException(String msg) { super(msg); }
}

class SpaceMission {
    public void checkFuel(int fuel) throws FuelShortageException {
        if (fuel < 70) throw new FuelShortageException("Fuel level too low for launch!");
        System.out.println("Fuel check passed.");
    }

    public void testEngine(boolean status) throws EngineFailureException {
        if (!status) throw new EngineFailureException("Engine test failed!");
        System.out.println("Engine check passed.");
    }

    public void checkWeather(String condition) throws WeatherNotSuitableException {
        if (!condition.equalsIgnoreCase("Clear"))
            throw new WeatherNotSuitableException("Weather not suitable: " + condition);
        System.out.println("Weather check passed.");
    }

    public void launch(int fuel, boolean engineStatus, String weather)
            throws FuelShortageException, EngineFailureException, WeatherNotSuitableException {
        checkFuel(fuel);
        testEngine(engineStatus);
        checkWeather(weather);
        System.out.println("🚀 Rocket launched successfully!");
    }
}

public class SpaceMissionControl {
    public static void main(String[] args) {
        SpaceMission mission = new SpaceMission();
        try {
            mission.launch(80, true, "Clear");
            mission.launch(50, true, "Clear");
        } catch (Exception e) {
            System.out.println("Launch Aborted: " + e.getMessage());
        }
    }
}

