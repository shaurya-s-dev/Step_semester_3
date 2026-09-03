package week4.assignment_problems;

public final class SurgeFeeCalculator {
    private final double minimumSurgePercent;

    public SurgeFeeCalculator(double minimumSurgePercent) {
        this.minimumSurgePercent = minimumSurgePercent;
    }

    public final double calculateSurgeFee(double orderValue, int delayMinutes) {
        if (orderValue < 0 || delayMinutes < 0)
            throw new IllegalArgumentException("Negative values not allowed");
        if (delayMinutes == 0) return 0.0;

        double tiered = 0;
        if (delayMinutes <= 5) {
            tiered = delayMinutes * 0.005;
        } else if (delayMinutes <= 15) {
            tiered = 5 * 0.005 + (delayMinutes - 5) * 0.01;
        } else {
            tiered = 5 * 0.005 + 10 * 0.01 + (delayMinutes - 15) * 0.02;
        }
        double result = tiered * orderValue;
        double floor = minimumSurgePercent / 100.0 * orderValue;
        return Math.max(result, floor);
    }

    public static void main(String[] args) {
        SurgeFeeCalculator calc = new SurgeFeeCalculator(1.0);
        System.out.println(calc.calculateSurgeFee(500, 0));  // 0.0
        System.out.println(calc.calculateSurgeFee(500, 1));  // 5.0
        System.out.println(calc.calculateSurgeFee(500, 16)); // 72.5
    }
}