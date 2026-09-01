package week1.assignment_problems;

public class TrafficStreakAnalyzer {
    public static void findLongestStreak(String signalLog) {
        if (signalLog.isEmpty()) {
            System.out.println("No data");
            return;
        }
        char bestChar = signalLog.charAt(0);
        int bestCount = 1;
        char currentChar = signalLog.charAt(0);
        int currentCount = 1;

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentChar) {
                currentCount++;
            } else {
                currentChar = signalLog.charAt(i);
                currentCount = 1;
            }
            if (currentCount > bestCount) {
                bestCount = currentCount;
                bestChar = currentChar;
            }
        }
        System.out.println("Longest Streak: '" + bestChar + "' repeated " + bestCount + " times");
    }

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }
}