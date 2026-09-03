package week3.class_problems;

// Reusing FeeAccount and HostelFeeAccount from F2 (copy or assume they exist)
// I'll redefine them briefly here to make this file standalone.

// --- Reuse F2 classes (simplified inline for standalone) ---
class FeeAcc {
    private double totalFee, amountPaid;
    public FeeAcc(double totalFee, double amountPaid) { this.totalFee = totalFee; this.amountPaid = amountPaid; }
    public void pay(double amt) { if (amt > 0) amountPaid += amt; else System.out.println("Rejected"); }
    public double getDue() { return totalFee - amountPaid; }
}
class HostelFeeAcc extends FeeAcc {
    public HostelFeeAcc(double totalFee, double amountPaid) { super(totalFee, amountPaid); }
}

// Reuse HostelRoom from F3 (simplified)
class HostelRm {
    String roomNo; int beds, occupied;
    public HostelRm(String roomNo, int beds) { this.roomNo = roomNo; this.beds = beds; occupied = 0; }
    public boolean allot(String name) { if (occupied < beds) { occupied++; System.out.println(name + " allotted to " + roomNo); return true; } return false; }
}

// --- Capstone Class ---
class SrmStudent {
    String name;
    String regNo;
    HostelFeeAcc feeAccount;
    HostelRm room;
    static int totalStudents = 0;

    private static int counter = 0;

    public SrmStudent(String name, HostelFeeAcc feeAccount, HostelRm room) {
        this.name = name;
        this.feeAccount = feeAccount;
        this.room = room;
        this.regNo = "RA2311003010" + (++counter);
        totalStudents++;
    }

    public String fullStatus() {
        String roomInfo = (room == null || room.occupied == 0) ? "unallotted" : room.roomNo;
        return name + " / Due: Rs " + feeAccount.getDue() + " / Room: " + roomInfo;
    }
}

public class SrmStudentCapstone {
    public static void main(String[] args) {
        // Create rooms
        HostelRm room1 = new HostelRm("C-214", 3);
        HostelRm room2 = new HostelRm("C-507", 2);
        HostelRm room3 = new HostelRm("C-301", 2);

        // Create fee accounts
        HostelFeeAcc acc1 = new HostelFeeAcc(140000, 0);
        HostelFeeAcc acc2 = new HostelFeeAcc(180000, 0);
        HostelFeeAcc acc3 = new HostelFeeAcc(200000, 0);

        // Create students
        SrmStudent s1 = new SrmStudent("Ravi", acc1, room1);
        SrmStudent s2 = new SrmStudent("Anitha", acc2, room2);
        SrmStudent s3 = new SrmStudent("Karthik", acc3, null); // no room

        // Allot rooms explicitly (simulate allotment)
        room1.allot("Ravi");
        room2.allot("Anitha");

        // Process payments (one rejected)
        acc1.pay(0); // rejected
        acc1.pay(140000); // pays full

        acc2.pay(100000);
        // acc3 pays nothing

        // Print statuses
        System.out.println(s1.fullStatus());
        System.out.println(s2.fullStatus());
        System.out.println(s3.fullStatus());
        System.out.println("Total students: " + SrmStudent.totalStudents);
    }
}