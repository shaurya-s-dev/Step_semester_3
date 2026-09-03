package week4.class_problems;

public class FareSplitter {
    private String tripID;
    private double totalFare;
    private int passengerCount;

    public FareSplitter(String tripID, double totalFare, int passengerCount) {
        if (totalFare < 0 || passengerCount <= 0)
            throw new IllegalArgumentException("Invalid fare or passenger count");
        this.tripID = tripID;
        this.totalFare = totalFare;
        this.passengerCount = passengerCount;
    }

    public FareSplitter(String tripID, double totalFare) {
        this(tripID, totalFare, 2); // default 2 passengers
    }

    public FareSplitter(String tripID) {
        this(tripID, 0.0, 2); // provisional zero fare
    }

    public double[] fareBreakdown() {
        double[] shares = new double[passengerCount];
        double base = Math.floor(totalFare / passengerCount * 100) / 100.0;
        double remainder = totalFare - base * passengerCount;
        for (int i = 0; i < passengerCount; i++) {
            shares[i] = base;
        }
        // add remainder to last share to avoid rounding loss
        shares[passengerCount - 1] += Math.round(remainder * 100) / 100.0;
        return shares;
    }

    public boolean isConfirmationOverdue(int confirmed, int expected) {
        return confirmed < expected;
    }

    public static void main(String[] args) {
        FareSplitter f1 = new FareSplitter("TRIP001", 100000, 3);
        double[] arr = f1.fareBreakdown();
        System.out.print("[");
        for (int i=0; i<arr.length; i++) {
            System.out.printf("%.2f", arr[i]);
            if (i < arr.length-1) System.out.print(", ");
        }
        System.out.println("]");

        FareSplitter f2 = new FareSplitter("TRIP003");
        arr = f2.fareBreakdown();
        System.out.print("[");
        for (int i=0; i<arr.length; i++) {
            System.out.printf("%.2f", arr[i]);
            if (i < arr.length-1) System.out.print(", ");
        }
        System.out.println("]");
    }
}