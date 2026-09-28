package object_modeling.class_problems;

import java.time.LocalDate;

public class LeaveRequest {
    private LeaveEmployee employee;
    private LocalDate startDate;
    private LocalDate endDate;
    private LeaveStatus status;

    public LeaveRequest(LeaveEmployee employee, LocalDate startDate, LocalDate endDate) {
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = LeaveStatus.PENDING;
    }

    public LeaveEmployee getEmployee() {
        return employee;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LeaveStatus getStatus() {
        return status;
    }

    public String transitionTo(LeaveStatus newStatus) {
        if (newStatus == LeaveStatus.PENDING && (status == LeaveStatus.APPROVED || status == LeaveStatus.REJECTED)) {
            return "Cannot change status: " + status.getDisplay() + " request cannot revert to Pending.";
        }
        this.status = newStatus;
        return "Status changed to " + newStatus.getDisplay() + ".";
    }
}
