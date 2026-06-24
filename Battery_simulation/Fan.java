package Battery_simulation;

import java.util.concurrent.*;
import java.util.Random;
import java.lang.Thread;

public class Fan implements BMSObjects {
    float size, rpm, voltage, power, temperture, battery_percentage = 0.0f;
    String color, brand, model;
    int batCapacity = 1200, begOfLifeCapacity = 1200;
    double soC;

    Fan(float size, float rpm, float voltage, float power, float temperture, double soC, String color, String brand,
            String model) {
        this.size = size;
        this.rpm = rpm;
        this.voltage = voltage;
        this.power = power;
        this.temperture = temperture;
        this.soC = soC;
        this.color = color;
        this.brand = brand;
        this.model = model;

    }

    @Override
    public void charge() {
        float avgVolt = 0.9f, socEstimate = 0.0f;
        Random noise = new Random();
        for (int i = 0; i < 6; i++) {
            socEstimate = socEstimate + (avgVolt + noise.nextFloat(0.99f));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Systems couldn't sleep due to " + e + "error");
            }
        }
        double estimate = socEstimate / batCapacity;
        CoulombCounter filter = new CoulombCounter();
        soC = filter.kalmanFilter(estimate, noise.nextFloat(.99f), noise.nextFloat(0.99f), noise.nextFloat(0.99f));
        ScheduledExecutorService now = new Executors.newScheduledThreadPool(2);
    }

}
