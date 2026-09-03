package week1.class_problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> freq = new LinkedHashMap<>();
        for (char c : text.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() == 1) return entry.getKey();
        }
        return '\0';  // no non-repeating character
    }

    public static void main(String[] args) {
        String[] inputs = {"swiss", "aabbcc"};
        for (String s : inputs) {
            char result = findFirstNonRepeatingChar(s);
            if (result != '\0')
                System.out.println("First Non-Repeating Character in \"" + s + "\": \"" + result + "\"");
            else
                System.out.println("No Non-Repeating Character Found in \"" + s + "\"");
        }
    }
}