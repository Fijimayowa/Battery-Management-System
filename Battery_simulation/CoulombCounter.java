package Battery_simulation;

import java.util.Random;

public class CoulombCounter extends VoltageReader {
    double SoC = super.SoC();
    float perrorCovarince = 0.0f;
    
    public double kalmanFilter(double socEstimate, float uncGain, float noiseV, float uncMeasure) {
        float kalmanGain, bound=0.99f;
        Random systemNoise = new Random();
        double socEstimatePredict = socEstimate + noiseV;
        perrorCovarince = perrorCovarince + systemNoise.nextFloat(bound);
        kalmanGain = perrorCovarince / (perrorCovarince + uncMeasure);
        socEstimate = socEstimate + kalmanGain * (SoC - socEstimatePredict);
        perrorCovarince = kalmanGain * perrorCovarince;
        return socEstimate;
 
    }
}
