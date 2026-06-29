package Battery_simulation;

public class PowerAllocator {
    LightBulb light;
    Fan fan;
    Outlet outlet;
    Radio radio;
    BMSObjects priority = null;
    int priorityNum;
    int kiloWatt = 30;

    PowerAllocator(LightBulb lt, Fan fn, Outlet ot, Radio rd) {
        light = lt;
        fan = fn;
        outlet = ot;
        radio = rd;

    }

    public void Queue(BMSObjects variable) {
        Queue queue=new Queue(variable);
        queue.Enqueue();
        powerRequirement=queue.device.getRequirement()

    }

}
