package week2.assignment_problems;

public class ISBNNormalizer {
    public static String normalizeCode(String raw) {
        String trimmed = raw.trim();
        String first3 = trimmed.substring(0, 3).toUpperCase();
        return first3 + trimmed.substring(3);
    }

    public static String validateAndFormat(String code) {
        String norm = normalizeCode(code);
        if (norm.length() != 13) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(norm.charAt(i)))
                return "Invalid: publisher code must be 3 letters";
        }
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(norm.charAt(i)))
                return "Invalid: non-digit body";
        }
        String pub = norm.substring(0, 3);
        String year = norm.substring(3, 7);
        String cat = norm.substring(7);
        return String.format("[%s] YEAR: 20%s | CATALOG: %s", pub, year, cat);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat("pen2026004251"));
        System.out.println(validateAndFormat("12N20260004251"));
    }
}