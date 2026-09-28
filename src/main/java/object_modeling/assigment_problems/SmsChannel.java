package object_modeling.assigment_problems;

public class SmsChannel implements NotificationChannel {

    @Override
    public String notify(String parcelId, ParcelStatus status) {
        return String.format("[SMS] %s is now %s.", parcelId, status);
    }
}
