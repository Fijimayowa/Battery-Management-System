package Battery_simulation;

public class Device {
    public enum Device {
        ceilingfan(7200, 9000, 90.07),
        radio(3600, 4000, 87.024),
        lightbulb(1200, 15000, 75.67);

        final int batC, begOfLifeCapacity;
        final double soC;

        Device(int batC, int begOfLifeCapacity, double soC) {
            this.batC = batC;
            this.begOfLifeCapacity = begOfLifeCapacity;
            this.soC = soC;

        }

    }
}
