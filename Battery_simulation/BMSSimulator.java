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
                    [5] Use Outlet
                    [6] Quit""");
            int value = scanner.nextInt();
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

            switch (value) {
                case 1:
                    BMSObjects po = dec.get(option);
                    System.out.println(po.getStatus());
                    break;

                default:
                    break;
            }
        }
        userInfo.putIfAbsent("fan", fan);
        userInfo.putIfAbsent("lightbulb", lightbulb);
        userInfo.putIfAbsent("radio", radio);
        Scanner userInput = new Scanner(System.in);
        System.out.println("How would you like to begin?\n" + "[1] Get device status\n" + "[2] Charge Device");
        System.out.println("[3] Charge Device\n" + "[4] Turn Device on\n" + "[5] Turn Device Off" + "[6] Use Outlet");
        int option = userInput.nextInt();
        System.out.println("Select Device\n" + "1) Ceiling Fan\n2) Lightbulb\n3) Radio");
        String decision = userInput.nextLine();
        switch (option) {
            case 1:
                System.out.println((userInfo.get(decision).getStatus()));
            case 2:
                PowerAllocator pAlloc = new PowerAllocator((LightBulb) lightbulb, (CeilingFan) fan, (Radio) radio);
                pAlloc.Queue(userInfo.get(decision));
                if (pAlloc.prior.peek()) {
                    System.out.println("lo");
                }
                userInfo.get(decision).charge(0, 0, 71.2f, 1200);

            default:
                break;
        }

    }

}
