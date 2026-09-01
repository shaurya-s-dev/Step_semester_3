package oop.assigment_problems;

public class LibraryMember {
    // instance fields - unique per member
    private String name;
    private String memberId;
    private int booksIssued;

    // static fields - shared across all members
    private static String libraryName = "City Central Library";
    private static int memberCount = 0;

    public LibraryMember(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
        memberCount++;
        this.memberId = "LM-100" + memberCount;
    }

    public void printMemberCard() {
        System.out.println(name + " | " + memberId);
    }

    public static void printTotalMembers() {
        System.out.println("Total members: " + memberCount);
    }

    // Broken version demo, kept in its own nested static class so it doesn't
    // collide with the fixed fields above
    static class BrokenLibraryMember {
        static String name;
        static String memberId;
        static int booksIssued;

        BrokenLibraryMember(String name, int booksIssued) {
            BrokenLibraryMember.name = name;
            BrokenLibraryMember.booksIssued = booksIssued;
        }
        // name is static: every object shares ONE name field, so the second
        // member's name overwrites the first's - there's no per-object identity
        // memberId is static: same problem, can't distinguish members
        // booksIssued is static: one member's book count leaks into every other member's
    }

    public static void main(String[] args) {
        System.out.println("Broken version:");
        BrokenLibraryMember b1 = new BrokenLibraryMember("Aditi", 2);
        BrokenLibraryMember b2 = new BrokenLibraryMember("Rohan", 1);
        System.out.println(BrokenLibraryMember.name);
        System.out.println(BrokenLibraryMember.name);
        System.out.println("(Aditi's data was overwritten - both members now show \"Rohan\")");

        System.out.println("\nFixed version:");
        LibraryMember m1 = new LibraryMember("Aditi", 2);
        LibraryMember m2 = new LibraryMember("Rohan", 1);
        m1.printMemberCard();
        m2.printMemberCard();
        printTotalMembers();
    }
}