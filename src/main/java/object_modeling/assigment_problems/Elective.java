package object_modeling.assigment_problems;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elective {
    private String courseName;
    private int credits;
    private int seatCapacity;
    private List<ElectiveStudent> enrolledStudents;
    private Queue<ElectiveStudent> waitlist;

    public Elective(String courseName, int credits, int seatCapacity) {
        this.courseName = courseName;
        this.credits = credits;
        this.seatCapacity = seatCapacity;
        this.enrolledStudents = new ArrayList<>();
        this.waitlist = new LinkedList<>();
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getAvailableSeats() {
        return seatCapacity - enrolledStudents.size();
    }

    public String enroll(ElectiveStudent student) {
        if (enrolledStudents.contains(student)) {
            return String.format("Enrollment failed: %s is already enrolled in %s.", student.getName(), courseName);
        }
        if (waitlist.contains(student)) {
            return String.format("Enrollment failed: %s is already on the waitlist for %s.", student.getName(), courseName);
        }
        if (!student.canEnroll(credits)) {
            return String.format("Enrollment failed: %s would exceed credit limit (%d/%d).",
                    student.getName(), student.getEnrolledCredits(), student.getType().getCreditLimit());
        }
        if (getAvailableSeats() > 0) {
            enrolledStudents.add(student);
            student.addCredits(credits);
            return String.format("%s enrolled in %s.", student.getName(), courseName);
        } else {
            waitlist.add(student);
            return String.format("%s added to waitlist for %s.", student.getName(), courseName);
        }
    }

    public String drop(ElectiveStudent student) {
        if (!enrolledStudents.remove(student)) {
            if (waitlist.remove(student)) {
                return String.format("%s removed from waitlist for %s.", student.getName(), courseName);
            }
            return String.format("Drop failed: %s is not enrolled in %s.", student.getName(), courseName);
        }
        student.removeCredits(credits);

        // Atomically promote from waitlist
        if (!waitlist.isEmpty()) {
            ElectiveStudent next = waitlist.poll();
            enrolledStudents.add(next);
            next.addCredits(credits);
            return String.format("%s dropped from %s. %s promoted from waitlist.", student.getName(), courseName, next.getName());
        }
        return String.format("%s dropped from %s.", student.getName(), courseName);
    }
}
