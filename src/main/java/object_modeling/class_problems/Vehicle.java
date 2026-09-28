package object_modeling.class_problems;

public abstract class Vehicle {
    private String model;
    private boolean available;

    public Vehicle(String model) {
        this.model = model;
        this.available = true;
    }

    public String getModel() {
        return model;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public abstract double calculateRentalCharge(int days);
}
