package Battery_simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BMSSimulator {
    public static void main(String[] arg) {
        Boolean running = true;
        Device fan = Device.ceilingfan;
        Device radio = Device.radio;
        Device lightbulb = Device.lightbulb;
        while (running) {
            Map<Integer, BMSObjects> dec = new HashMap<>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("""
                    How would you like to begin?
                    [1] Get device status
                    [2] Charge Device
                    [3] Turn Device On
                    [4] Turn Device Off
                    [5] Power Allocater
                    [6] Use Outlet
                    [7] Quit""");
            int value = scanner.nextInt();
            if (value>6) {
                Scanner option = new Scanner(System.in);
                System.out.println("""
                        Select Device
                        [1]Radio
                        [2]Fan
                        [3]LightBulb
                        """);
                int decision = option.nextInt();
                LightBulb light = new LightBulb(2.9f, 120.2f, 18f, 60f, 74d, "White", "GE lighting", "Incandescent");
                CeilingFan fn = new CeilingFan(15f, 300f, 12f, 1.5f, 90f, 98d, "Black", "Ikea", "SuperFan");
                Radio rd = new Radio(3.5f, 9f, 0.20f, 70f, 98.02d, "Black", "Sony", "Rf12V");
                dec.put(1, light);
                dec.put(2, fn);
                dec.put(3, rd);
                BMSObjects dv=dec.get(decision);
                switch (value) {
                    case 1:
                        System.out.println(dv.getStatus());
                        break;
                    case 2:
                        dv.charge(decision, decision, value, decision);
                    case 3:
                        if(dv.getSoc()<5){
                            System.out.println("Battery low");
                        }
                        dv.run(decision, value, decision);
                        break;
                    case 5:
                        PowerAllocator pw=new PowerAllocator(light, fn, rd);
                        pw.Queue(dec.get(decision));
                    case 6:
                        Outlet outlet=new Outlet(15f,120f,0.1f);
                        if (!outlet.isOccupied()) {
                            outlet.turnOn();
                            outlet.plugIn(dv);
                        }
                        System.out.println("--------------\n"+"Device in use:");
                        outlet.turnOff();
                        outlet.unplug();
                    default:
                        break;
                }
                }
            running=false;
        }

    }

}
