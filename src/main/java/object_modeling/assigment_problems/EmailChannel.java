package object_modeling.assigment_problems;

public class EmailChannel implements NotificationChannel {

    @Override
    public String notify(String parcelId, ParcelStatus status) {
        return String.format("[Email] %s is now %s.", parcelId, status);
    }
}
