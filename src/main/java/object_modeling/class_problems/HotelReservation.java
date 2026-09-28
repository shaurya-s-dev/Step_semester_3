package object_modeling.class_problems;

import java.time.LocalDate;

public class HotelReservation {
    private HotelCustomer customer;
    private HotelRoom room;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private double totalPrice;
    private boolean active;

    public HotelReservation(HotelCustomer customer, HotelRoom room, LocalDate checkIn, LocalDate checkOut, double totalPrice) {
        this.customer = customer;
        this.room = room;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.totalPrice = totalPrice;
        this.active = true;
    }

    public HotelCustomer getCustomer() {
        return customer;
    }

    public HotelRoom getRoom() {
        return room;
    }

    public LocalDate getCheckIn() {
        return checkIn;
    }

    public LocalDate getCheckOut() {
        return checkOut;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean overlaps(LocalDate start, LocalDate end) {
        if (!active) {
            return false;
        }
        return start.isBefore(this.checkOut) && end.isAfter(this.checkIn);
    }
}
