package Battery_simulation;

public class LightBulb extends BMSObjects {
    float size, rpm, voltage, power, temperture, current;
    String color, brand, model;
    int batCapacity = 2000, begOfLifeCapacity = 2000;
    double soC, batteryPercentage;

    LightBulb(float size, float rpm, float voltage, float current, float temperture, double soC, String color,
            String brand,
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

    public void charge(double sC, int batP, float temp, int batC) {
        super.charge(sC, batP, temp, batC);
    }

    public void run(double sC, float temperture, int batCapacity) {
        super.run(sC, temperture, batCapacity);
    }

    public String getStatus() {
        return super.getStatus(brand, color, model);
    }

    public float getPowerRequirement() {
        return power = current * voltage;
    }

    @Override
    public double getSoc() {
        return soC;
    }

    @Override
    public boolean isSafeToCharge() {
        return temperture < 101.5f;

    }

    @Override
    public double stateOfHeath() {
        return batCapacity / begOfLifeCapacity;
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
