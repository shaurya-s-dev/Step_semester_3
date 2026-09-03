package week4.class_problems;

public class SleeperCoachAccount extends BusTicketAccount {
    public SleeperCoachAccount(String bookingId, double ticketFare) {
        super(bookingId, ticketFare);
    }

    // Override penalty if needed? Not required, but we keep.
}