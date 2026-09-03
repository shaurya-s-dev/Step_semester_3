package week1.assignment_problems;

public class WordLengthProfiler {
public static void classifyWordLengths(String review) {
        review = review.trim();
        if (review.isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }
        String[] words = review.split("\\s+");
        int shortCount = 0, mediumCount = 0, longCount = 0;
        for (String w : words) {
            int len = w.length();
            if (len <= 4) shortCount++;
            else if (len <= 8) mediumCount++;
            else longCount++;
        }
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }
}