package Battery_simulation;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BMSSimulator {
    public static void main(String[] arg) {
        Map<String, BMSObjects> userInfo = new HashMap<>();
        Scanner userInput = new Scanner(System.in);
        System.out.println("How would you like to begin?\n" + "[1] Get device status\n" + "[2] Charge Device");
        System.out.println("[3] Charge Device\n" + "[4] Turn Device on\n" + "[5] Turn Device Off" + "[6] Use Outlet");
        int option = userInput.nextInt();
        switch (option) {
            case 1:
                System.out.println("Select Device\n" + "1) Ceiling Fan\n2) Lightbulb\n3) Radio");
                String decision = userInput.nextLine();
                if (decision.strip().equals("CeilingFan")) {
                    float size = 42.0f, rpm = 275.0f, voltage = 120.0f, current = 0.8f;
                    double soC = 100.0;
                    String color = "Black", brand = "Ikea", model = "fastz";
                    BMSObjects fan = new CeilingFan(size, rpm, voltage, current, soC, color, brand, model);
                }
                break;

            default:
                break;
        }

    }

}
