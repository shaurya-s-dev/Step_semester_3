package object_modeling.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class Parcel {
    private String parcelId;
    private double weightKg;
    private ShippingType shippingType;
    private ParcelStatus status;
    private List<NotificationChannel> channels;

    public Parcel(String parcelId, double weightKg, ShippingType shippingType) {
        this.parcelId = parcelId;
        this.weightKg = weightKg;
        this.shippingType = shippingType;
        this.status = ParcelStatus.BOOKED;
        this.channels = new ArrayList<>();
    }

    public String getParcelId() {
        return parcelId;
    }

    public double getWeightKg() {
        return weightKg;
    }

    public ShippingType getShippingType() {
        return shippingType;
    }

    public ParcelStatus getStatus() {
        return status;
    }

    public void addNotificationChannel(NotificationChannel channel) {
        this.channels.add(channel);
    }

    public double calculateCharge() {
        return shippingType.calculateCharge(weightKg);
    }

    public List<String> notifyChannels() {
        List<String> messages = new ArrayList<>();
        for (NotificationChannel channel : channels) {
            messages.add(channel.notify(parcelId, status));
        }
        return messages;
    }

    public String updateStatus(ParcelStatus newStatus) {
        if (!status.canTransitionTo(newStatus)) {
            return String.format("Invalid transition: %s -> %s is not allowed.", status, newStatus);
        }
        this.status = newStatus;
        return null;
    }

    public String cancel() {
        if (status != ParcelStatus.BOOKED) {
            return String.format("Cancellation failed: %s can be cancelled only while BOOKED.", parcelId);
        }
        this.status = ParcelStatus.CANCELLED;
        return String.format("Parcel %s cancelled successfully.", parcelId);
    }
}
