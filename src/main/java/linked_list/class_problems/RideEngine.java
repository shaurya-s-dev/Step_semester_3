package linked_list.class_problems;

/**
 * Problem 2: Ride Fare Engine
 *
 * TASK:
 * Create an abstract Ride class with the distance and an abstract double calculateFare(),
 * and subclasses Auto, Cab and Bike. Store all rides in one Ride[] array, print each fare
 * and the grand total.
 * Auto: base 30 + 15 per km.
 * Cab: (base 50 + 20 per km) * surge factor.
 * Bike: base 20 + 10 per km + 2 per waiting minute.
 */
public class RideEngine {

    public static abstract class Ride {
        protected double distance;

        public Ride(double distance) {
            this.distance = distance;
        }

        public abstract double calculateFare();
        public abstract String getType();
    }

    public static class Auto extends Ride {
        public Auto(double distance) {
            super(distance);
        }

        @Override
        public double calculateFare() {
            return 30.0 + (15.0 * distance);
        }

        @Override
        public String getType() {
            return "Auto";
        }
    }

    public static class Cab extends Ride {
        private double surge;

        public Cab(double distance, double surge) {
            super(distance);
            this.surge = surge;
        }

        @Override
        public double calculateFare() {
            return (50.0 + (20.0 * distance)) * surge;
        }

        @Override
        public String getType() {
            return "Cab";
        }
    }

    public static class Bike extends Ride {
        private int waitingMinutes;

        public Bike(double distance, int waitingMinutes) {
            super(distance);
            this.waitingMinutes = waitingMinutes;
        }

        @Override
        public double calculateFare() {
            return 20.0 + (10.0 * distance) + (2.0 * waitingMinutes);
        }

        @Override
        public String getType() {
            return "Bike";
        }
    }

    public static void printRideFares(Ride[] rides) {
        double grandTotal = 0.0;
        for (Ride ride : rides) {
            double fare = ride.calculateFare();
            grandTotal += fare;
            System.out.println(ride.getType() + ": " + Math.round(fare));
        }
        System.out.println("Total: " + Math.round(grandTotal));
    }

    public static void main(String[] args) {
        Ride[] rides = new Ride[] {
            new Auto(4),
            new Cab(6, 1.5),
            new Bike(3, 5)
        };
        printRideFares(rides);
    }
}
