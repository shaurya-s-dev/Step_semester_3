package linked_list.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 4: Product Price Finder
 *
 * TASK:
 * You have a list of product prices, which are guaranteed to be sorted in ascending order.
 * Implement a function that efficiently counts how many products fall within a specified price range
 * (inclusive of both lower and upper bounds). You need to return the count of such products.
 *
 * EXAMPLE:
 * Prices [100, 150, 150, 200, 300, 450]
 * Range 150 to 300
 * Expected Output:
 * Lower bound index 1
 * Upper bound index 5
 * Count 4 (products with prices 150, 150, 200, 300)
 */
public class ProductPriceFinder {

    public static class PriceRangeResult {
        public int lowerBoundIndex;
        public int upperBoundIndex;
        public int count;
        public List<Integer> productsInRange;

        public PriceRangeResult(int lower, int upper, int count, List<Integer> products) {
            this.lowerBoundIndex = lower;
            this.upperBoundIndex = upper;
            this.count = count;
            this.productsInRange = products;
        }

        public String getSummary() {
            StringBuilder sb = new StringBuilder();
            sb.append("Lower bound index ").append(lowerBoundIndex).append("\n");
            sb.append("Upper bound index ").append(upperBoundIndex).append("\n");
            sb.append("Count ").append(count).append(" (products with prices ");
            for (int i = 0; i < productsInRange.size(); i++) {
                sb.append(productsInRange.get(i));
                if (i < productsInRange.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(")");
            return sb.toString();
        }
    }

    /**
     * Finds the first index where price >= low (Lower Bound).
     */
    public static int findLowerBound(int[] prices, int low) {
        int left = 0;
        int right = prices.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prices[mid] >= low) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Finds the first index where price > high (Upper Bound).
     */
    public static int findUpperBound(int[] prices, int high) {
        int left = 0;
        int right = prices.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (prices[mid] > high) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    /**
     * Finds products within the range [low, high] inclusive.
     */
    public static PriceRangeResult findProductsInRange(int[] prices, int low, int high) {
        int lower = findLowerBound(prices, low);
        int upper = findUpperBound(prices, high);
        int count = Math.max(0, upper - lower);

        List<Integer> list = new ArrayList<>();
        for (int i = lower; i < upper; i++) {
            list.add(prices[i]);
        }

        return new PriceRangeResult(lower, upper, count, list);
    }
}
