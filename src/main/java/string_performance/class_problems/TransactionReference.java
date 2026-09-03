package week2.class_problems;

public class TransactionReference {
    public static String normalizeReference(String raw) {
        String trimmed = raw.trim();
        String first3 = trimmed.substring(0, 3).toUpperCase();
        return first3 + trimmed.substring(3);
    }

    public static String validateAndFormat(String ref) {
        String norm = normalizeReference(ref);
        if (norm.length() != 14) return "Invalid: wrong length";
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(norm.charAt(i)))
                return "Invalid: bank code must be 3 letters";
        }
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(norm.charAt(i)))
                return "Invalid: non-digit body";
        }
        String bank = norm.substring(0, 3);
        String date = norm.substring(3, 9);
        String seq = norm.substring(9);
        return String.format("[%s] DATE: %s/%s/%s | SEQ: %s",
                bank, date.substring(0,2), date.substring(2,4), date.substring(4,6), seq);
    }

    public static void main(String[] args) {
        System.out.println(validateAndFormat(" hdf03022600042 "));
        System.out.println(validateAndFormat("12F03022600042"));
    }
}