package week4.assignment_problems;

public class DeliveryAccount {
    protected String studentId;
    protected double orderValue;
    private static String platformName;

    static {
        platformName = "CampusEats";
    }

    public DeliveryAccount(String studentId, double orderValue) {
        this.studentId = studentId;
        this.orderValue = orderValue;
    }

    public DeliveryAccount(String studentId) {
        this(studentId, 500.0);
    }

    public final double calculateSurgeFee(int delayMinutes) {
        SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
        return calc.calculateSurgeFee(orderValue, delayMinutes);
    }
}