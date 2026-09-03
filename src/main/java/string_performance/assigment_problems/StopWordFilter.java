package week2.assignment_problems;

import java.util.*;

public class StopWordFilter {
    public static void printFilteredWordFrequency(String feedback) {
        String cleaned = feedback.toLowerCase().replaceAll("[.,]", "");
        String[] words = cleaned.split("\\s+");
        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));
        Map<String, Integer> freq = new HashMap<>();
        for (String w : words) {
            if (!stopWords.contains(w)) {
                freq.put(w, freq.getOrDefault(w, 0) + 1);
            }
        }
        // Sort by count descending
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freq.entrySet());
        list.sort((e1, e2) -> e2.getValue().compareTo(e1.getValue()));
        for (Map.Entry<String, Integer> e : list) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}