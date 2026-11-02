package linked_list.assigment_problems;

import java.util.Stack;

/**
 * Problem 2: The Hackathon Banner Printer
 *
 * TASK:
 * Decode compressed pattern k[text].
 * Simulates nesting using stacks without recursion.
 */
public class HackathonBannerPrinter {

    public static String expandBanner(String code) {
        if (code == null || code.isEmpty()) return "";

        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> textStack = new Stack<>();
        StringBuilder currentText = new StringBuilder();
        int k = 0;

        for (int i = 0; i < code.length(); i++) {
            char ch = code.charAt(i);

            if (Character.isDigit(ch)) {
                k = k * 10 + (ch - '0');
            } else if (ch == '[') {
                countStack.push(k);
                textStack.push(currentText);
                k = 0;
                currentText = new StringBuilder();
            } else if (ch == ']') {
                StringBuilder decodedPart = currentText;
                currentText = textStack.pop();
                int repeatCount = countStack.pop();
                for (int r = 0; r < repeatCount; r++) {
                    currentText.append(decodedPart);
                }
            } else {
                currentText.append(ch);
            }
        }

        return currentText.toString();
    }
}
