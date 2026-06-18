package Battery_simulation;
import java.util.Random;
import java.lang.Thread;
import java.util.Map;
import java.util.HashMap;

public class VoltageReader {
    static Random initialVolt = new Random();
    final float maxVolt = 4.20f;
    Map<String, Double> containMap = new HashMap<>();
    double valToReturn=0.00d;

    private void logVoltage(double v) {
        String key = "Voltage" + Double.toString(v);
        containMap.put(key, v);
    }

    public Map<String, Double> VoltReader ()throws InterruptedException {
        Random noise = new Random();
        for (int i=0; i < 6; i++) {
            float voltRead = initialVolt.nextFloat(maxVolt);
            double res = voltRead + noise.nextDouble(.99);
            logVoltage(res);
            Thread.sleep(1000);
        }
        return containMap;
    }

    public boolean isOverVoltage(float v) {
        return v > 4.2;
    }

    public boolean isUnderVoltage(float v) {
        return v < 1.0;
    }

    public double getAverageVolt() {
        for(double elements : containMap.values()){
            valToReturn+=elements;
        }
        return valToReturn/containMap.size();
    }
    public double SoC(){
        return valToReturn;
    }

}
