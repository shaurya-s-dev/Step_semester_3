package oop.assigment_problems;

public class BookIssue {
    private String title;
    private String borrowerName;
    private int daysOverdue;

    public BookIssue(String title, String borrowerName, int daysOverdue) {
        this.title = title;
        this.borrowerName = borrowerName;
        this.daysOverdue = daysOverdue;
    }

    public double fineAmount() {
        return daysOverdue > 0 ? daysOverdue * 5 : 0;
    }

    public boolean isSeverelyOverdue() {
        return daysOverdue > 14;
    }

    // static because it operates on the whole array of BookIssue objects,
    // not on any single object's state
    public static double totalFineCollected(BookIssue[] issues) {
        double total = 0;
        for (BookIssue issue : issues) {
            total += issue.fineAmount();
        }
        return total;
    }

    public static void main(String[] args) {
        BookIssue[] issues = {
            new BookIssue("Clean Code", "Aditi", 18),
            new BookIssue("Effective Java", "Rohan", 5),
            new BookIssue("Refactoring", "Meera", 0),
            new BookIssue("DSA Handbook", "Karan", 21),
            new BookIssue("Design Patterns", "Divya", 9)
        };

        for (BookIssue b : issues) {
            String status = b.isSeverelyOverdue() ? "Severely overdue" : "OK";
            System.out.println(b.title + " - " + b.daysOverdue + " days - " + status);
        }

        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(issues));
    }
}