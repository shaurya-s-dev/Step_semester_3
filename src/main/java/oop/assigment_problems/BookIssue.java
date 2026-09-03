package week3.assignment_problems;

class BookIssue {
    String title;
    String borrowerName;
    int daysOverdue;

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

    public static double totalFineCollected(BookIssue[] issues) {
        double total = 0;
        for (BookIssue bi : issues) total += bi.fineAmount();
        return total;
    }

    public static void main(String[] args) {
        BookIssue[] books = {
            new BookIssue("Clean Code", "A", 18),
            new BookIssue("Effective Java", "B", 5),
            new BookIssue("Refactoring", "C", 0),
            new BookIssue("DSA Handbook", "D", 21),
            new BookIssue("Design Patterns", "E", 9)
        };
        for (BookIssue b : books) {
            System.out.print(b.title + " - " + b.daysOverdue + " days - ");
            System.out.println(b.isSeverelyOverdue() ? "Severely overdue" : "OK");
        }
        System.out.println("Total fine collected: Rs " + BookIssue.totalFineCollected(books));
    }
}
/*
 * totalFineCollected is static because it operates on an array of BookIssue objects
 * as a whole, not on a single instance's data. It does not depend on any particular
 * book's state, so it belongs to the class.
 * fineAmount is instance because it uses the specific book's daysOverdue.
 */