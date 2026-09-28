package object_modeling.class_problems;

public class SUV extends Vehicle {
    private static final double DAILY_RATE = 80.0;

    public SUV(String model) {
        super(model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * DAILY_RATE;
    }
}
