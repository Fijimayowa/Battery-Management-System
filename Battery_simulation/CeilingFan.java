package Battery_simulation;

public class Fan extends BMSObjects {
    float size, rpm, voltage, power, temperture, current;
    String color, brand, model;
    int batCapacity = 1200, begOfLifeCapacity = 1200;
    double soC, battery_percentage;
    final double optimalTemp=78.00d;

    Fan(float size, float rpm, float voltage, float current, float temperture, double soC, String color, String brand,
            String model) {
        this.size = size;
        this.rpm = rpm;
        this.voltage = voltage;
        this.current = current;
        this.temperture = temperture;
        this.soC = soC;
        this.color = color;
        this.brand = brand;
        this.model = model;

    }

    public void charge(double soC, int batCapacity, float temperture, int batC) {
        super.charge(soC, batCapacity, temperture, batC);
    }

    public void run(double soC, float temperture, int batCapacity) {
        super.run(soC, temperture, batCapacity);
    }

    @Override
    public double getSoc() {
        return soC;
    }

    @Override
    public boolean isSafeToCharge() {
        return temperture < 80.5f;

    }

    @Override
    public double stateOfHeath() {
        return batCapacity / begOfLifeCapacity;
    }

    @Override
    public float getPowerRequirement() {
        return current * voltage;
    }

    public String getStatus() {
        return super.getStatus(brand, color, model);
    }

    @Override
    public int getBatteryCapacity() {
        return batCapacity;
    }

    @Override
    public float getTemperture() {
        return temperture;
    }
}
