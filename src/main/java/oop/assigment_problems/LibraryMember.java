package week3.assignment_problems;

// Broken version
class BrokenLibraryMember {
    static String name;
    static String memberId;
    static int booksIssued;

    public BrokenLibraryMember(String name, String memberId) {
        BrokenLibraryMember.name = name;
        BrokenLibraryMember.memberId = memberId;
        BrokenLibraryMember.booksIssued = 0;
    }
}

// Fixed version
class FixedLibraryMember {
    private String name;
    private String memberId;
    private int booksIssued;
    private static String libraryName = "Central Library";
    private static int memberCount = 0;

    public FixedLibraryMember(String name) {
        this.name = name;
        this.memberId = "LM-" + (++memberCount);
        this.booksIssued = 0;
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }
}

public class LibraryMember {
    public static void main(String[] args) {
        System.out.println("--- Broken version ---");
        BrokenLibraryMember b1 = new BrokenLibraryMember("Aditi", "LM-1001");
        BrokenLibraryMember b2 = new BrokenLibraryMember("Rohan", "LM-1002");
        System.out.println(BrokenLibraryMember.name); // last assigned = Rohan
        System.out.println(BrokenLibraryMember.name); // both show Rohan

        System.out.println("\n--- Fixed version ---");
        FixedLibraryMember f1 = new FixedLibraryMember("Aditi");
        FixedLibraryMember f2 = new FixedLibraryMember("Rohan");
        f1.printMemberCard();
        f2.printMemberCard();
        FixedLibraryMember.printTotalMembers();
    }
}
/*
 * Static fields are shared across all instances. Here name, memberId, booksIssued
 * must be instance-specific; static is wrong.
 * libraryName and memberCount are shared across all members, so static is correct.
 */