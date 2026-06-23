package Battery_simulation;

import java.util.Random;

public class CoulombCounter extends VoltageReader {
    double SoC = super.SoC();
    int curr;
    int batteryCapacity;
    float perrorCovarince = 0.0f;

    CoulombCounter(int curr, int batteryCapacity) {
        this.curr = curr;
        this.batteryCapacity = batteryCapacity;
    }

    private void kalmanFilter(double socEstimate, float uncGain, float noiseV, float uncMeasure) {
        float kalmanGain;
        Random systemNoise = new Random();
        double socEstimatePredict = socEstimate + noiseV;
        perrorCovarince = perrorCovarince + systemNoise.nextDouble(1.111);
        kalmanGain = perrorCovarince / (perrorCovarince + uncMeasure);
        socEstimate = socEstimate + kalmanGain * (SoC - socEstimatePredict);
        perrorCovarince = kalmanGain * perrorCovarince;

    }

    static public float CoulombCount(double bC, int curr) {
        double totalVolt = super.VoltageReader().sum();
        double res = SoC + (1 / bC) + curr;
        return res;

    }
}
