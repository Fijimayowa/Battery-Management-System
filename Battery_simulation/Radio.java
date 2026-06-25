package Battery_simulation;

public class Radio extends BMSObjects {
    float size, rpm, voltage, power, temperture, current;
    String color, brand, model;
    int batCapacity = 2500, begOfLifeCapacity = 2500;
    double soC, battery_percentage;

    Radio(float size, float rpm, float voltage, float current, float temperture, double soC, String color, String brand,
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

    public void charge() {
        super.charge(battery_percentage, batCapacity, temperture, batCapacity);

    }

    public void run() {
        super.run(battery_percentage, temperture, batCapacity);
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

    public String getRequirement() {
        return super.getRequirement(size, voltage, temperture, current, batCapacity);
    }

    public String getStatus() {
        return super.getStatus(brand, color, model);
    }

}
