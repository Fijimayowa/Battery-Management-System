package Battery_simulation;

import java.util.Random;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Thread;

public class PowerAllocator {
    LightBulb light;
    Fan fan;
    Radio radio;
    int priorityNum;
    float kiloWatt = 30;
    Map<String, Float> prior = new HashMap<>();

    PowerAllocator(LightBulb lt, Fan fn, Radio rd) {
        light = lt;
        fan = fn;
        radio = rd;
        prior.put("light", light.getPowerRequirement());
        prior.put("fan", fan.getPowerRequirement());
        prior.put("radio", radio.getPowerRequirement());

    }

    public void Queue(BMSObjects variable) throws InterruptedException {
        Queue<BMSObjects> queue = new LinkedList<>();
        queue.add(variable);
        float powerRequirement = queue.poll().getPowerRequirement(), avgDep = 0.99f;
        Random noise = new Random();
        while (powerRequirement > 0.5) {
            float var = noise.nextFloat(0.99f) + avgDep;
            kiloWatt -= var;
            powerRequirement -= var;
            Thread.sleep(1000);
        }

    }

    public void Priority(){
        float max=0.0f;
        String val;
        for(Map.Entry<String, Float> entry: prior.entrySet()){
            if (entry.getValue()>max) {
                max=entry.getValue();
                val=entry.getKey();
            }
        }


}
