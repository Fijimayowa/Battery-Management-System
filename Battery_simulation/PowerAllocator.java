package Battery_simulation;

import java.util.Random;

public class PowerAllocator {
    LightBulb light;
    Fan fan;
    Outlet outlet;
    Radio radio;
    BMSObjects priority = null;
    int priorityNum;
    float kiloWatt = 30;

    PowerAllocator(LightBulb lt, Fan fn, Outlet ot, Radio rd) {
        light = lt;
        fan = fn;
        outlet = ot;
        radio = rd;

    }

    public void Queue(BMSObjects variable) {
        Queue queue=new Queue(variable);
        queue.Enqueue();
        float powerRequirement=queue.device.getPowerRequirement(), avgDep=0.99f;
        Random noise=new Random();
        Random noie=noise.
        while (powerRequirement>0.5) {
            kiloWatt-=powerRequirement;
            powerRequirement-=avgDep+noise;
            System.out.println("lol");
            
        }

    }

}
