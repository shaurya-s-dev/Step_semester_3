package week3.class_problems;

// --- BROKEN VERSION ---
class BrokenStudent {
    static String name;
    static String regNo;
    static int attendance;

    public BrokenStudent(String name, String regNo, int attendance) {
        BrokenStudent.name = name;
        BrokenStudent.regNo = regNo;
        BrokenStudent.attendance = attendance;
    }
}

// --- FIXED VERSION ---
class FixedStudent {
    private String name;
    private String regNo;
    private int attendance;

    private static String university = "SRMIST";
    private static int admissionCount = 0;

    public FixedStudent(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        this.regNo = "RA2311003010" + (++admissionCount);
    }

    public void printIdCard() {
        System.out.println(name + " / " + regNo);
    }

    public static void printTotalAdmissions() {
        System.out.println("Students admitted so far: " + admissionCount);
    }
}

public class SrmStudentStaticBug {
    public static void main(String[] args) {
        // Demonstrate broken version
        System.out.println("--- Broken version ---");
        BrokenStudent b1 = new BrokenStudent("Ravi", "RA101", 80);
        BrokenStudent b2 = new BrokenStudent("Meera", "RA102", 90);
        System.out.println(BrokenStudent.name); // Last assigned = Meera
        System.out.println(BrokenStudent.name); // Both show Meera

        // Demonstrate fixed version
        System.out.println("\n--- Fixed version ---");
        FixedStudent f1 = new FixedStudent("Ravi", 80);
        FixedStudent f2 = new FixedStudent("Meera", 90);
        f1.printIdCard();
        f2.printIdCard();
        FixedStudent.printTotalAdmissions();
    }
}
/*
 * Static fields are shared across all instances.
 * name, regNo, attendance must be instance-specific to hold unique data per student.
 * university and admissionCount are class-wide, so static is correct.
 */