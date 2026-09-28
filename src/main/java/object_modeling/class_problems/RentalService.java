package object_modeling.class_problems;

public class RentalService {

    public String rentVehicle(RentalCustomer customer, Vehicle vehicle, int days) {
        if (!vehicle.isAvailable()) {
            return "Rental failed: " + vehicle.getModel() + " is already rented.";
        }
        vehicle.setAvailable(false);
        double charge = vehicle.calculateRentalCharge(days);
        return String.format("%s rented for %d days. Total charge: $%.2f.", vehicle.getModel(), days, charge);
    }

    public String returnVehicle(Vehicle vehicle) {
        vehicle.setAvailable(true);
        return vehicle.getModel() + " returned. Now available.";
    }
}
