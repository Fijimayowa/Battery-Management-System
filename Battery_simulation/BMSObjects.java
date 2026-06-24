package Battery_simulation;

public interface BMSObjects {
    void charge();

    float getstatus();

    void run();

    void getRequirement();

    boolean isSafeToCharge();

    double getSoc();

}
