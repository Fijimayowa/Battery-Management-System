package Battery_simulation;

public class ThermalModel extends PIDController {
    public void sendTempReading(BMSObjects device) throws InterruptedException {
        for (int i = 0; i < 6; i++) {
            super.intergral += device.getTemperture();
            Thread.sleep(1000);
        }
    }

    public double pidControllerGain(BMSObjects device){
        PIDController pidController=new PIDController();
        return pidController.proportionalGain(device.optimalTemp-device.temperture)+pidController.intergralGain()+pidController.derivativeGain(2, 1.5f);
    }

}
