package week1.assignment_problems;

public class DuplicateSeatChecker {
public static void checkDuplicateSeats(int[] seatNumbers) {
        java.util.Set<Integer> seen = new java.util.HashSet<>();
        java.util.Set<Integer> duplicates = new java.util.HashSet<>();

        for (int seat : seatNumbers) {
            if (!seen.add(seat) && duplicates.add(seat)) {
                System.out.println("Duplicate Seat Number Found: " + seat);
            }
        }

        if (duplicates.isEmpty()) {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void main(String[] args) {
        int[] seats1 = {101, 102, 103, 102, 105};
        int[] seats2 = {101, 102, 103, 104, 105};
        System.out.println("Test 1:");
        checkDuplicateSeats(seats1);
        System.out.println("\nTest 2:");
        checkDuplicateSeats(seats2);
    }
}