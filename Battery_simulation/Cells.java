package Battery_simulation;

public class Cells {
    float current, resistance;
    double voltage;
    int storageCapacity, temperture;

    Cells(float curr, double vol, int storageC, float res) {
        this.current = curr;
        this.voltage = vol;
        this.storageCapacity = storageC;
        this.resistance = res;
    }

    public static float StateOfCharge() {
        return 2.1;
    }
}
