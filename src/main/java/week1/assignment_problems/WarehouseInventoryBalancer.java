package week1.assignment_problems;

public class WarehouseInventoryBalancer {
public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            throw new IllegalArgumentException("sectionA and sectionB must have the same length");
        }
        if (sectionA.length == 0) {
            System.out.println("No inventory data");
            return;
        }

        int totalA = 0, totalB = 0;
        int maxVal = Integer.MIN_VALUE;
        String maxLocation = "";

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
            if (sectionA[i] > maxVal) {
                maxVal = sectionA[i];
                maxLocation = "Section A, Item " + (i+1);
            }
            if (sectionB[i] > maxVal) {
                maxVal = sectionB[i];
                maxLocation = "Section B, Item " + (i+1);
            }
        }
        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | ",
                          totalA, totalB, (totalA == totalB) ? "Balanced" : "Not Balanced");
        System.out.println("Highest Quantity: " + maxVal + " (" + maxLocation + ")");
    }

    public static void main(String[] args) {
        int[] A = {20, 15, 30};
        int[] B = {25, 10, 30};
        analyzeInventory(A, B);
    }
}