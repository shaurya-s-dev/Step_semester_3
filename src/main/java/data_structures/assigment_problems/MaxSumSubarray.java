package data_structures.assigment_problems;

public class MaxSumSubarray {
    public static int maxSumSubarray(int[] sales, int k) {
        if (sales == null || sales.length < k || k <= 0) {
            return 0;
        }
        
        int maxSum = 0;
        int currentSum = 0;
        
        for (int i = 0; i < k; i++) {
            currentSum += sales[i];
        }
        
        maxSum = currentSum;
        
        for (int i = k; i < sales.length; i++) {
            currentSum = currentSum - sales[i - k] + sales[i];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return maxSum;
    }
}
