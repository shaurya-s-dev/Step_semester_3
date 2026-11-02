package linked_list.assigment_problems;

import java.util.Stack;

/**
 * Problem 3: The Quiz Scoring Formula
 *
 * TASK:
 * Evaluates an infix expression with +, -, *, /, (), spaces and multi-digit integers.
 * Evaluates in a single left-to-right pass using an operand stack and operator stack.
 */
public class QuizScoringFormula {

    public static int evaluate(String expr) {
        if (expr == null || expr.isEmpty()) return 0;

        Stack<Integer> values = new Stack<>();
        Stack<Character> ops = new Stack<>();

        int i = 0;
        int n = expr.length();

        while (i < n) {
            char ch = expr.charAt(i);

            if (ch == ' ') {
                i++;
                continue;
            }

            if (Character.isDigit(ch)) {
                int val = 0;
                while (i < n && Character.isDigit(expr.charAt(i))) {
                    val = val * 10 + (expr.charAt(i) - '0');
                    i++;
                }
                values.push(val);
                continue; // i already points to next character
            } else if (ch == '(') {
                ops.push(ch);
            } else if (ch == ')') {
                while (!ops.isEmpty() && ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                if (!ops.isEmpty() && ops.peek() == '(') {
                    ops.pop(); // discard '('
                }
            } else if (isOperator(ch)) {
                while (!ops.isEmpty() && ops.peek() != '(' && precedence(ops.peek()) >= precedence(ch)) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.push(ch);
            }
            i++;
        }

        while (!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        return values.isEmpty() ? 0 : values.pop();
    }

    private static boolean isOperator(char ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') return 1;
        if (op == '*' || op == '/') return 2;
        return 0;
    }

    private static int applyOp(char op, int b, int a) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
            case '/': return a / b;
            default: return 0;
        }
    }
}
