package week1.assignment_problems;

public class DuplicateSeatChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        for (int i = 0; i < seatNumbers.length; i++) {
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break;
                }
            }
        }
        if (!foundDuplicate) {
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