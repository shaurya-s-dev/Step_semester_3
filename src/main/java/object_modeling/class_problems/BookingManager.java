package object_modeling.class_problems;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class BookingManager {
    private List<HotelReservation> reservations;

    public BookingManager() {
        this.reservations = new ArrayList<>();
    }

    public String bookRoom(HotelCustomer customer, HotelRoom room, LocalDate checkIn, LocalDate checkOut) {
        for (HotelReservation r : reservations) {
            if (r.getRoom().getRoomNumber().equals(room.getRoomNumber()) && r.overlaps(checkIn, checkOut)) {
                return String.format("Booking failed: %s is not available for %s to %s.",
                        room.getDisplayName(), checkIn, checkOut);
            }
        }

        long nights = ChronoUnit.DAYS.between(checkIn, checkOut);
        double totalPrice = nights * room.getPricePerNight();
        HotelReservation res = new HotelReservation(customer, room, checkIn, checkOut, totalPrice);
        reservations.add(res);

        return String.format("%s booked from %s to %s. Total price: $%.2f.",
                room.getDisplayName(), checkIn, checkOut, totalPrice);
    }

    public String cancelReservation(HotelCustomer customer, HotelRoom room) {
        for (HotelReservation r : reservations) {
            if (r.getCustomer().getName().equals(customer.getName()) &&
                r.getRoom().getRoomNumber().equals(room.getRoomNumber()) &&
                r.isActive()) {
                r.setActive(false);
                return String.format("Reservation for %s cancelled successfully.", room.getDisplayName());
            }
        }
        return "Cancellation failed: No active reservation found.";
    }
}
