package Battery_simulation;

<<<<<<< HEAD
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
=======
import Battery_simulation.Cells;
import math

public class CoulombCounter {
    Cells battery = new Cells(0, 0, 0, 0);
    int s = 0;
>>>>>>> dc08120c08204da73d848702524f4dd8b24511e2
}
