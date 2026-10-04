package data_structures.class_problems;

import java.util.HashMap;
import java.util.Map;

public class NetBalance {
    public static int countPeriods(int[] transactions, int k) {
        Map<Long, Integer> prefixCounts = new HashMap<>();
        prefixCounts.put(0L, 1);
        
        long currentSum = 0;
        int count = 0;
        
        for (int transaction : transactions) {
            currentSum += transaction;
            
            long required = currentSum - k;
            count += prefixCounts.getOrDefault(required, 0);
            
            prefixCounts.put(currentSum, prefixCounts.getOrDefault(currentSum, 0) + 1);
        }
        
        return count;
    }
}
