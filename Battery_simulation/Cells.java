package Battery_simulation;

import java.util.Random;

public class Cells {
    float current, batCapacity,resistance, begOfLifeCapacity;
    double voltage;

    Cells(float curr, double vol, int batC, float res, float bolC) {
        this.current = curr;
        this.voltage = vol;
        this.batCapacity = batC;
        this.resistance = res;
        this.begOfLifeCapacity = bolC;
    }

    public static double StateOfCharge() {
        CoulombCounter var = new CoulombCounter();
        Random noise = new Random();
        double fliteredSc = var.kalmanFilter(70.2d, noise.nextFloat(0.99f), noise.nextFloat(0.75f),
                noise.nextFloat(0.66f));
        return fliteredSc;

    }

    public float StateOfHealth() {
        return batCapacity / begOfLifeCapacity;
    }
}
