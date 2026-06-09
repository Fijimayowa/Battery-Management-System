package Battery_simulation;

import java.util.Map;

public class CoulombCounter extends VoltageReader {
    double SoC = super.SoC();
    int curr;
    int batteryCapacity;

    CoulombCounter(double SoC, int curr, int batteryCapacity) {
        this.SoC = SoC;
        this.curr = curr;
        this.batteryCapacity = batteryCapacity;
        System.out.println();
    }

    private float kalmanFilter(){
        float uncertaintyGain=;

    }

    static public float CoulombCount(double bC, int curr) {
        double totalVolt = super.VoltageReader().sum();
        double res = SoC + (1 / bC) + curr;
        return res;

    }
}
