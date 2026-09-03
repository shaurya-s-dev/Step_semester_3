package week2.assignment_problems;

public class InventoryCSVParser {
    public static void parseInventoryRecord(String csvLine) {
        String[] parts = csvLine.split(",");
        if (parts.length != 3) {
            System.out.println("Invalid Record");
            return;
        }
        System.out.printf("Product: %s | SKU: %s | Qty: %s%n", parts[0], parts[1], parts[2]);
    }

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }
}