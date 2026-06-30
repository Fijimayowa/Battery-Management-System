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
    Outlet outlet;
    Radio radio;
    BMSObjects priority = null;
    int priorityNum;
    float kiloWatt = 30;
    float curr=1.25f, vol=1.25f;
    Map<String, float> prior=new HashMap<>();

    PowerAllocator(LightBulb lt, Fan fn, Outlet ot, Radio rd) {
        light = lt;
        fan = fn;
        outlet = ot;
        radio = rd;

    }

    public void Queue(BMSObjects variable) throws InterruptedException{
        Queue<BMSObjects> queue= new LinkedList<>();
        queue.add(variable);
        float powerRequirement=queue.poll().getPowerRequirement(), avgDep=0.99f;
        Random noise=new Random();
        while (powerRequirement>0.5) {
            float var=noise.nextFloat(0.99f)+avgDep;
            kiloWatt-=var;
            powerRequirement-=var;
            Thread.sleep(1000);
        }

    }

}
