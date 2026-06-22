package Battery_simulation;

import java.util.Map;

public class CoulombCounter extends VoltageReader {
    double SoC = super.SoC();
    int curr;
    int batteryCapacity;
    float perrorCovarince = 0.0f;

    CoulombCounter(double SoC, int curr, int batteryCapacity) {
        this.SoC = SoC;
        this.curr = curr;
        this.batteryCapacity = batteryCapacity;
    }

    private float kalmanFilter(float uncGain, float noiseV, float perrorC, float uncMeasure){
        float systemNoise=0.0f, kalmanGain;
        double socEstimatePredict=SoC + noiseV;
        perrorCovarince=perrorC+uncGain;
        kalmanGain=perrorC/(perrorC+uncMeasure);
        socEstimate=socEstimate+kalmanGain*()


    }

    static public float CoulombCount(double bC, int curr) {
        double totalVolt = super.VoltageReader().sum();
        double res = SoC + (1 / bC) + curr;
        return res;

    }
}
