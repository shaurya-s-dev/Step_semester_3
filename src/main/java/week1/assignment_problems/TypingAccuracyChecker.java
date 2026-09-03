package week1.assignment_problems;

public class TypingAccuracyChecker {
    public static void checkTypingAccuracy(String original, String typed) {
        int matches = 0;
        int firstMismatch = -1;
        for (int i = 0; i < original.length(); i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matches++;
            } else if (firstMismatch == -1) {
                firstMismatch = i + 1;  // 1‑based position
            }
        }
        double accuracy = (matches * 100.0) / original.length();
        System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | ",
                           matches, original.length(), accuracy);
        if (firstMismatch == -1)
            System.out.println("No Mismatches");
        else
            System.out.println("First Mismatch at position " + firstMismatch +
                               " (‘" + original.charAt(firstMismatch-1) + "’ vs ‘" +
                               typed.charAt(firstMismatch-1) + "’)");
    }

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello wurld");  // (original and typed differ intentionally)
        checkTypingAccuracy("coding", "coding");
    }
}