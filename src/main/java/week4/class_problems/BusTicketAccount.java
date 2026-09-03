package week4.class_problems;

public class BusTicketAccount {
    protected String bookingId;
    protected double ticketFare;
    private static String companyName;

    static {
        companyName = "CityBus Corp.";
    }

    public BusTicketAccount(String bookingId, double ticketFare) {
        this.bookingId = bookingId;
        this.ticketFare = ticketFare;
    }

    public BusTicketAccount(String bookingId) {
        this(bookingId, 1000.0); // default fare
    }

    public final double calculatePenalty(int minutesLate) {
        BoardingPenaltyCalculator calc = new BoardingPenaltyCalculator(1.0);
        return calc.calculatePenalty(ticketFare, minutesLate);
    }

    public static void processBatch(BusTicketAccount[] accounts, double[] amounts, int[] minutesLateArray) {
        int processed = 0, nullSkipped = 0, sleeper = 0, regular = 0;
        double grandTotal = 0;
        int len = Math.min(accounts.length, Math.min(amounts.length, minutesLateArray.length));

        for (int i = 0; i < len; i++) {
            if (accounts[i] == null) {
                nullSkipped++;
                continue;
            }
            // we use amounts[i] as ticketFare? The problem says amount is given but we ignore? We'll compute penalty on account's fare.
            double penalty = accounts[i].calculatePenalty(minutesLateArray[i]);
            grandTotal += penalty;
            processed++;
            if (accounts[i] instanceof SleeperCoachAccount) sleeper++;
            else regular++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " +
                sleeper + " sleeper | " + regular + " regular | grand total penalties = " + grandTotal);
    }
}