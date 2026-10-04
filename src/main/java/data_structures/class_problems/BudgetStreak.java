package data_structures.class_problems;

public class BudgetStreak {
    public static int[] longestStreak(int[] costs, int budget) {
        int maxLen = 0;
        int bestStart = -1;
        int currentSum = 0;
        int left = 0;
        
        for (int right = 0; right < costs.length; right++) {
            currentSum += costs[right];
            
            while (currentSum > budget && left <= right) {
                currentSum -= costs[left];
                left++;
            }
            
            int currentLen = right - left + 1;
            if (currentLen > maxLen) {
                maxLen = currentLen;
                bestStart = left;
            }
        }
        
        if (maxLen == 0) {
            return new int[]{0, -1};
        }
        
        return new int[]{maxLen, bestStart};
    }
}
