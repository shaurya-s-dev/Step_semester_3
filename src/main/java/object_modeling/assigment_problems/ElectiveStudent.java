package object_modeling.assigment_problems;

public class ElectiveStudent {
    private String name;
    private StudentType type;
    private int enrolledCredits;

    public ElectiveStudent(String name, StudentType type) {
        this.name = name;
        this.type = type;
        this.enrolledCredits = 0;
    }

    public String getName() {
        return name;
    }

    public StudentType getType() {
        return type;
    }

    public int getEnrolledCredits() {
        return enrolledCredits;
    }

    public void addCredits(int credits) {
        this.enrolledCredits += credits;
    }

    public void removeCredits(int credits) {
        this.enrolledCredits -= credits;
    }

    public boolean canEnroll(int courseCredits) {
        return (enrolledCredits + courseCredits) <= type.getCreditLimit();
    }
}
