package Battery_simulation;

import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Thread;

public class PowerAllocator extends VoltageReader {
    LightBulb light;
    CeilingFan fan;
    Radio radio;
    int priorityNum;
    float kiloWatt = 30;
    Map<BMSObjects, Float> prior = new HashMap<>();

    PowerAllocator(LightBulb lt, CeilingFan fn, Radio rd) {
        light = lt;
        fan = fn;
        radio = rd;
        prior.put(fan, light.getPowerRequirement());
        prior.put(light, fan.getPowerRequirement());
        prior.put(radio, radio.getPowerRequirement());

    }

    public void Queue(BMSObjects variable) throws InterruptedException {
        Queue<BMSObjects> queue = new LinkedList<>();
        queue.add(variable);
        float powerRequirement = queue.poll().getPowerRequirement(), avgDep = 0.99f;
        Random noise = new Random();
        boolean volTrue = true;
        while (powerRequirement > 0.5 && !volTrue && variable.isSafeToCharge()) {
            float var = noise.nextFloat(0.99f) + avgDep;
            volTrue = super.isUnderVoltage(var);
            kiloWatt -= var;
            powerRequirement -= var;
            Thread.sleep(1000);
        }

    }

    public BMSObjects Priority() {
        float max = 0.0f;
        BMSObjects deviceWithPriority;
        Random noise = new Random();
        for (Map.Entry<BMSObjects, Float> entry : prior.entrySet()) {
            double res = 0.99d + noise.nextDouble(0.31f);
            if (entry.getValue() > max) {
                max = entry.getValue();
                deviceWithPriority = entry.getKey();
                deviceWithPriority.charge(deviceWithPriority.getSoc() + res, (int) deviceWithPriority.getSoc(),
                        deviceWithPriority.getTemperture(), deviceWithPriority.getBatteryCapacity());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("Thread unable to sleep due to " + e + " Error");
                }
            }
        }
        return deviceWithPriority;
    }
}
