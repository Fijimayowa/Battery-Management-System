package Battery_simulation;

import java.util.Map;
import java.util.Scanner;

public class BMSSimulator {
    public static void main(String[] arg) {
        Map<String,BMSObjects> user=new Array
        Scanner userInput= new Scanner(System.in);
        System.out.println("How would you like to begin?\n"+"[1] Get device status\n"+"[2] Charge Device");
        System.out.println("[3] Charge Device\n"+"[4] Turn Device on\n"+"[5] Turn Device Off");
        int option=userInput.nextInt();
        switch (option) {
            case 1:
                System.out.println("Select Device\n");

                break;
        
            default:
                break;
        }

    }

}
