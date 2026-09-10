package access_modifiers.assigment_problems;

import java.util.Arrays;

public class LoanReceipt {
    private static final String BOOK_ID_PATTERN = "^BK-\\d{3}$";

    // Static block for one-time shared state initialization
    static {
        // Shared circulation ledger state initialized
    }

    private final String memberId;
    private final String[] bookIds;

    public LoanReceipt(String memberId, String[] bookIds) {
        if (memberId == null || bookIds == null) {
            throw new IllegalArgumentException("construction rejected");
        }
        for (String id : bookIds) {
            if (id == null || !id.matches(BOOK_ID_PATTERN)) {
                throw new IllegalArgumentException("construction rejected");
            }
        }
        this.memberId = memberId;
        this.bookIds = Arrays.copyOf(bookIds, bookIds.length);
    }

    public String getMemberId() {
        return memberId;
    }

    public String[] getBookIds() {
        return Arrays.copyOf(bookIds, bookIds.length);
    }

    public LoanReceipt withCorrectedBookId(int index, String newId) {
        if (index < 0 || index >= bookIds.length || newId == null || !newId.matches(BOOK_ID_PATTERN)) {
            throw new IllegalArgumentException("Invalid index or book ID");
        }
        String[] newBookIds = Arrays.copyOf(bookIds, bookIds.length);
        newBookIds[index] = newId;
        return new LoanReceipt(this.memberId, newBookIds);
    }

    public static String processNightlyCirculation(LoanReceipt[] receipts) {
        int processed = 0;
        int nullSkipped = 0;
        int referenceOnly = 0;
        int regular = 0;

        if (receipts != null) {
            for (LoanReceipt r : receipts) {
                if (r == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (r instanceof ReferenceOnlyLoanReceipt) {
                        referenceOnly++;
                    } else {
                        regular++;
                    }
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " +
               referenceOnly + " reference-only | " + regular + " regular";
    }
}
