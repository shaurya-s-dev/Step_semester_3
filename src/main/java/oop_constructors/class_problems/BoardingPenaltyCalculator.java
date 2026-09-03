package week4.class_problems;

public final class BoardingPenaltyCalculator {
    private final double minimumPenaltyPercent;

    public BoardingPenaltyCalculator(double minimumPenaltyPercent) {
        this.minimumPenaltyPercent = minimumPenaltyPercent;
    }

    public final double calculatePenalty(double ticketFare, int minutesLate) {
        if (ticketFare < 0 || minutesLate < 0)
            throw new IllegalArgumentException("Negative values not allowed");
        if (minutesLate == 0) return 0.0;

        double tiered = 0;
        if (minutesLate <= 5) {
            tiered = minutesLate * 0.005;
        } else if (minutesLate <= 15) {
            tiered = 5 * 0.005 + (minutesLate - 5) * 0.01;
        } else {
            tiered = 5 * 0.005 + 10 * 0.01 + (minutesLate - 15) * 0.02;
        }
        double result = tiered * ticketFare;
        double floor = minimumPenaltyPercent / 100.0 * ticketFare;
        return Math.max(result, floor);
    }

    public static void main(String[] args) {
        BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0);
        System.out.println("Penalty for 1000, 0 min: " + calc.calculatePenalty(1000, 0));
        System.out.println("Penalty for 1000, 1 min: " + calc.calculatePenalty(1000, 1));
        System.out.println("Penalty for 1000, 16 min: " + calc.calculatePenalty(1000, 16));
    }
}