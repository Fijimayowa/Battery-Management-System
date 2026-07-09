package Battery_simulation;

import java.util.Random;

public class CoolingFan {
    private final float coolingEffient = 0.99f;
    private int maxFanSpeed = 300;
    static Cells battery = new Cells(0.8f, 3.7, 2300, 4.2f, 2300f);

    public void coolDown(BMSObjects device, float desiredTemp, double gain) {
        while (turnOn(device) && battery.StateOfCharge() > 0) {
            Random noise = new Random();
            float dep = 0.005f;
            device.temperture -= gain * coolingEffient;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("System error " + e);
            }
            battery.begOfLifeCapacity -= dep + noise.nextFloat(0.009f);
        }

    }

    public int setSpeed(int speedPercentage) {
        return maxFanSpeed *= speedPercentage;
    }

    public int getSpeed() {
        return maxFanSpeed;
    }

    public float getCoolingPower() {
        return coolingEffient;
    }

    private boolean turnOn(BMSObjects device) {
        if (battery.StateOfCharge() < 0) {
            return false;
        }
        return device.optimalTemp > device.getPowerRequirement();
    }

    private boolean turnOff(BMSObjects device) {
        return device.getTemperture() <= device.optimalTemp;
    }
}
