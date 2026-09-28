package object_modeling.class_problems;

public enum OrderStatus {
    CREATED("Created"),
    PENDING_PAYMENT("Pending Payment"),
    PAID("Paid");

    private final String display;

    OrderStatus(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
