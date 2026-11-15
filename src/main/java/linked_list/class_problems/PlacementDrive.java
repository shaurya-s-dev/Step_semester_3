package linked_list.class_problems;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 5: Placement Drive Shortlist
 *
 * TASK:
 * Rank candidates by total score (merge sort, stable, highest first).
 * Show each candidate's best run of consecutive improvement (test x to y, 1-based, earliest on ties).
 * CUTOFF x prints how many candidates have a total >= x using binary search.
 * PAIR t finds two different candidates whose totals add up to exactly t using two pointers, or prints "no pair".
 */
public class PlacementDrive {

    public static class Candidate {
        public String name;
        public int[] scores;
        public int total;
        public int bestGain;
        public int bestStart;
        public int bestEnd;
        public int regOrder;

        public Candidate(String name, int[] scores, int regOrder) {
            this.name = name;
            this.scores = scores;
            this.regOrder = regOrder;
            this.total = 0;
            for (int s : scores) {
                this.total += s;
            }
            calculateBestClimb();
        }

        private void calculateBestClimb() {
            // Find max subarray sum of weekly changes: changes[i] = scores[i+1] - scores[i]
            // scores length is 6, changes length is 5 (transitions 1->2, 2->3, 3->4, 4->5, 5->6)
            int nChanges = scores.length - 1;
            int maxGain = Integer.MIN_VALUE;
            int startTest = 1;
            int endTest = 1;

            // Enumerate consecutive intervals of changes [i .. j]
            for (int i = 0; i < nChanges; i++) {
                int currentGain = 0;
                for (int j = i; j < nChanges; j++) {
                    currentGain += (scores[j + 1] - scores[j]);
                    if (currentGain > maxGain) {
                        maxGain = currentGain;
                        startTest = i + 1; // 1-based test index
                        endTest = j + 2;   // 1-based test index
                    }
                }
            }

            this.bestGain = maxGain;
            this.bestStart = startTest;
            this.bestEnd = endTest;
        }
    }

    public static List<Candidate> mergeSort(List<Candidate> list) {
        if (list.size() <= 1) return list;

        int mid = list.size() / 2;
        List<Candidate> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<Candidate> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    private static List<Candidate> merge(List<Candidate> left, List<Candidate> right) {
        List<Candidate> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < left.size() && j < right.size()) {
            // Descending order of total. Stable: if equal, left comes first
            if (left.get(i).total >= right.get(j).total) {
                result.add(left.get(i++));
            } else {
                result.add(right.get(j++));
            }
        }

        while (i < left.size()) result.add(left.get(i++));
        while (j < right.size()) result.add(right.get(j++));

        return result;
    }

    public static int cutoffCount(List<Candidate> sortedCandidates, int cutoff) {
        // sortedCandidates is descending: 420, 418, 405, 405, 380
        // Find number of candidates with total >= cutoff
        // Binary search for first index where total < cutoff
        int low = 0;
        int high = sortedCandidates.size() - 1;
        int ans = sortedCandidates.size();

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (sortedCandidates.get(mid).total < cutoff) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public static String findPair(List<Candidate> sortedCandidates, int target) {
        // sortedCandidates is sorted descending by total
        int left = 0;
        int right = sortedCandidates.size() - 1;

        while (left < right) {
            int sum = sortedCandidates.get(left).total + sortedCandidates.get(right).total;
            if (sum == target) {
                return sortedCandidates.get(left).name + " + " + sortedCandidates.get(right).name;
            } else if (sum > target) {
                left++; // decrease sum (since left is higher)
            } else {
                right--; // increase sum (since moving left from right increases value)
            }
        }
        return "no pair";
    }

    public static void printShortlist(List<Candidate> candidates) {
        List<Candidate> sorted = mergeSort(candidates);
        System.out.println("Shortlist:");
        for (int i = 0; i < sorted.size(); i++) {
            Candidate c = sorted.get(i);
            System.out.println((i + 1) + ". " + c.name + " " + c.total + " | best climb +"
                    + c.bestGain + " (test " + c.bestStart + " to " + c.bestEnd + ")");
        }
    }
}
