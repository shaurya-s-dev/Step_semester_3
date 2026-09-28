package object_modeling.class_problems;

public class HotelRoom {
    private String roomNumber;
    private String category;
    private double pricePerNight;

    public HotelRoom(String roomNumber, String category, double pricePerNight) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.pricePerNight = pricePerNight;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public String getCategory() {
        return category;
    }

    public double getPricePerNight() {
        return pricePerNight;
    }

    public String getDisplayName() {
        return category + " Room " + roomNumber;
    }
}
