package Battery_simulation;

import java.util.concurrent.*;
import java.util.Random;
import java.lang.Thread;

public abstract class BMSObjects {
    void charge(double sC, int batP, float temp, int batC) {
        float avgVolt = 0.9f, socEstimate = 0.0f;
        Random noise = new Random();
        for (int i = 0; i < 6; i++) {
            if (sC > 95.33f) {
                return;
            }
            socEstimate = socEstimate + (avgVolt + noise.nextFloat(0.99f));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Systems couldn't sleep due to " + e + "error");
            }
        }
        double estimate = socEstimate / batC;
        CoulombCounter filter = new CoulombCounter();
        sC = filter.kalmanFilter(estimate / batC, noise.nextFloat(.99f), noise.nextFloat(0.99f),
                noise.nextFloat(0.99f));
        ScheduledExecutorService now = Executors.newScheduledThreadPool(2);
        now.schedule(() -> {
            temp += 0.12f;
            batC -= 3;
        }, 7, TimeUnit.DAYS);
        batP = (int) sC;
    }

    void run(double sC, float temperture, int batCapacity) {
        float avgDep = 0.99f;
        Random noise = new Random();
        for (int i = 0; i < 6; i++) {
            if (sC <= 10.33f) {
                return;
            }
            sC = sC - (avgDep + noise.nextFloat(0.33f));
        }
        ScheduledExecutorService depreciation = Executors.newScheduledThreadPool(2);
        depreciation.schedule(() -> {
            temperture += 0.12f;
            batCapacity -= 3;

        }, 7, TimeUnit.DAYS);
    }

    String getRequirement(double size, float voltage, float temperture, float current, int batCapacity) {
        return "Size: " + Double.toString(size) + "Voltage: " + Float.toString(voltage) + "Temperture: "
                + Float.toString(temperture) + "\nCurrent: " + Float.toString(current) + "Power: "
                + Float.toString(current * voltage) + "Battery Percentage: " + Integer.toString(batCapacity);
    }

    String getStatus(String brand, String color, String model) {
        return "Brand: " + brand + "Color: " + color + "Model: " + model;
    }

    abstract boolean isSafeToCharge();

    abstract double getSoc();

    abstract double stateOfHeath();

    abstract int getBatteryCapacity();

    abstract float getTemperture();

}
