package object_modeling.class_problems;

public enum LeaveStatus {
    PENDING("Pending"),
    APPROVED("Approved"),
    REJECTED("Rejected");

    private final String display;

    LeaveStatus(String display) {
        this.display = display;
    }

    public String getDisplay() {
        return display;
    }
}
