package Battery_simulation;

import java.util.Queue;

public class PowerAllocator {
    LightBulb light;
    Fan fan;
    Outlet outlet;
    Radio radio;
    BMSObjects pirority = null;
    int pirority;

    PowerAllocator(LightBulb lt, Fan fn, Outlet ot, Radio rd) {
        light = lt;
        fan = fn;
        outlet = ot;
        radio = rd;

    }

    public void Queue(BMSObjects variable) {

    }

}
