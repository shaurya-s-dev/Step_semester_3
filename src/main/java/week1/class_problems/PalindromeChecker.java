package week1.class_problems;

public class PalindromeChecker {
    public static boolean isPalindromeIterative(String text) {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) return false;
            left++; right--;
        }
        return true;
    }

public static boolean isPalindromeRecursive(String text) {
        return isPalindromeRecursive(text, 0, text.length() - 1);
    }

    private static boolean isPalindromeRecursive(String text, int left, int right) {
        if (left >= right) return true;
        if (text.charAt(left) != text.charAt(right)) return false;
        return isPalindromeRecursive(text, left + 1, right - 1);
    }

    public static boolean isPalindromeArrayReversal(String text) {
        char[] arr = text.toCharArray();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[n - 1 - i];
            arr[n - 1 - i] = temp;
        }
        return new String(arr).equals(text);
    }

    public static void main(String[] args) {
        String[] testCases = {"madam", "hello"};
        for (String s : testCases) {
            boolean it = isPalindromeIterative(s);
            boolean rec = isPalindromeRecursive(s);
            boolean arr = isPalindromeArrayReversal(s);
            System.out.println("\"" + s + "\" -> Iterative: " + (it ? "Palindrome" : "Not Palindrome") +
                               " / Recursive: " + (rec ? "Palindrome" : "Not Palindrome") +
                               " / Array Reversal: " + (arr ? "Palindrome" : "Not Palindrome"));
        }
    }
}