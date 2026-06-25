package Battery_simulation;

import java.util.concurrent.*;
import java.util.Random;
import java.lang.Thread;

public class Fan extends BMSObjects {
    float size, rpm, voltage, power, temperture, current;
    String color, brand, model;
    int batCapacity = 1200, begOfLifeCapacity = 1200;
    double soC, battery_percentage;

    Fan(float size, float rpm, float voltage, float current, float temperture, double soC, String color, String brand,
            String model) {
        this.size = size;
        this.rpm = rpm;
        this.voltage = voltage;
        this.current = current;
        this.temperture = temperture;
        this.soC = soC;
        this.color = color;
        this.brand = brand;
        this.model = model;

    }

    public void charge(double soC, int batCapacity, float temperture, int batC) {
        super.charge(soC, batCapacity, temperture, batC);
    }

    public void run(double soC, float temperture, int batCapacity) {
        super.run(soC, temperture, batCapacity);
    }

    @Override
    public double getSoc() {
        return soC;
    }

    @Override
    public boolean isSafeToCharge() {
        return temperture < 80.5f;

    }

    @Override
    public double stateOfHeath() {
        return batCapacity / begOfLifeCapacity;
    }

    @Override
    public String getRequirement() {
        return "Size: " + Double.toString(size) + "Voltage: " + Float.toString(voltage) + "Temperture: "
                + Float.toString(temperture) + "\nCurrent: " + Float.toString(current) + "Power: "
                + Float.toString(current * voltage) + "Battery Percentage: " + Integer.toString(batCapacity);
    }

    @Override
    public String getStatus() {
        return "Brand: " + brand + "Color: " + color + "Model: " + model;
    }
}
