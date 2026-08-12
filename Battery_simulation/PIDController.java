package Battery_simulation;

public class PIDController {
    double intergral = 0.00d;
    private final double h = 1e-8;
    private final int kp=10;

    public float proportionalGain(float error) {
        return kp*error;

    }

    public double intergralGain() {
        return intergral;

    }

    public double derivativeGain(int f, float x){
        return (f*(x+h)-f*(x))/h;
        

    }
}
