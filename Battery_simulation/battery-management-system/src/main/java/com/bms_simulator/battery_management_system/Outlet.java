package Battery_simulation;
import java.lang.Thread;
import java.util.Random;

public class Outlet {
    static boolean powerSwitch, completeCircuit;
    float current, voltage, resistance;
    BMSObjects device = null;

    Outlet(float current, float voltage, float resistance) {
        this.current = current;
        this.voltage = voltage;
        this.resistance = resistance;
    }

    public void plugIn(BMSObjects var) throws InterruptedException {
        if (powerSwitch == false) {
            return;
        }
        Random noise = new Random();
        float avgVolt = 0.99f + noise.nextFloat(.13f);
        while (powerSwitch) {
            var.charge(var.getSoc() + avgVolt, (int) var.getSoc(), var.getTemperture(), var.getBatteryCapacity());
            Thread.sleep(1000);

        }

    }

    public void unplug() {
        current = 0;
        voltage = 0;
        powerSwitch = false;
    }

    public boolean turnOn() {
        return powerSwitch = true;

    }

    public boolean turnOff() {
        return powerSwitch = false;

    }

    boolean isOccupied() {
        return powerSwitch && isPowerOn() && getConnectedDevice()!=null;

    }

    boolean isPowerOn() {
        return current > 0 && voltage > 0;

    }

    float getVoltage() {
        return voltage;
    }

    float getCurrent() {
        return current;
    }

    float getPower() {
        return current * voltage;
    }

    boolean hasGround() {
        if (resistance >= 1) {
            return true;
        }
        return false;
    }

    boolean isGrounded(float resistanceOfDevice) {
        return resistance > resistanceOfDevice;
    }

    void tripBreaker() {
        completeCircuit = false;
    }

    void resetBreaker() {
        completeCircuit = true;
    }

    BMSObjects getConnectedDevice() {
        return device;

    }

    void setConnectedDevice(BMSObjects var) {
        device = var;

    }

    boolean isCircuitComplete() {
        return completeCircuit;

    }

}
