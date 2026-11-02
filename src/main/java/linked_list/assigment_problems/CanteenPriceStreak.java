package linked_list.assigment_problems;

import java.util.Stack;

/**
 * Problem 1: The Canteen Price Streak
 *
 * TASK:
 * Calculate the number of consecutive days ending today on which the price was <= today's price.
 * Runs in O(n) using a monotonic decreasing stack of indices.
 */
public class CanteenPriceStreak {

    public static int[] priceStreak(int[] price) {
        if (price == null || price.length == 0) return new int[0];

        int n = price.length;
        int[] streak = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && price[stack.peek()] <= price[i]) {
                stack.pop();
            }

            streak[i] = stack.isEmpty() ? (i + 1) : (i - stack.peek());
            stack.push(i);
        }

        return streak;
    }
}
