package object_modeling.class_problems;

public class StandardCar extends Vehicle {
    private static final double DAILY_RATE = 50.0;

    public StandardCar(String model) {
        super(model);
    }

    @Override
    public double calculateRentalCharge(int days) {
        return days * DAILY_RATE;
    }
}
