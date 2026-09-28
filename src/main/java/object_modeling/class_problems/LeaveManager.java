package object_modeling.class_problems;

import java.time.LocalDate;

public class LeaveManager {

    public LeaveRequest submitRequest(LeaveEmployee employee, LocalDate startDate, LocalDate endDate) {
        LeaveRequest req = new LeaveRequest(employee, startDate, endDate);
        return req;
    }

    public String formatSubmission(LeaveRequest req) {
        return String.format("Leave request submitted by %s for %s to %s. Status: %s.",
                req.getEmployee().getName(), req.getStartDate(), req.getEndDate(), req.getStatus().getDisplay());
    }

    public String approveRequest(LeaveRequest req) {
        req.transitionTo(LeaveStatus.APPROVED);
        return String.format("Leave request for %s approved. Status: Approved.", req.getEmployee().getName());
    }

    public String rejectRequest(LeaveRequest req) {
        req.transitionTo(LeaveStatus.REJECTED);
        return String.format("Leave request for %s rejected. Status: Rejected.", req.getEmployee().getName());
    }

    public String changeStatus(LeaveRequest req, LeaveStatus newStatus) {
        return req.transitionTo(newStatus);
    }
}
