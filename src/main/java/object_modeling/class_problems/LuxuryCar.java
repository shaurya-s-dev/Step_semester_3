package object_modeling.class_problems;

public class LuxuryCar extends Vehicle {
    private static final double DAILY_RATE = 100.0;

    public LuxuryCar(String model) {
        super(model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * DAILY_RATE;
    }
}
