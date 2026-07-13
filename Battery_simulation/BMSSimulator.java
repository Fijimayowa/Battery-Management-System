package Battery_simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BMSSimulator {
    public static void main(String[] arg) {
        Map<String, BMSObjects> userInfo = new HashMap<>();
        BMSObjects fan = new CeilingFan(0, 0, 0, 0, 0, 0, null, null, null),
                radio = new Radio(0, 0, 0, 0, 0, 0, null, null, null),
                lightbulb = new LightBulb(0, 0, 0, 0, 0, 0, null, null, null);
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
                System.out.println((userInfo.get(decision).getStatus());
            case 2:
                PowerAllocator pAlloc = new PowerAllocator((LightBulb) lightbulb, (CeilingFan) fan, (Radio) radio);
                userInfo.get(decision).charge(0, 0, 71.2f, 1200);

            default:
                break;
        }

    }

}
