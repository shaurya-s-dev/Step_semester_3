package week4.assignment_problems;

public class Canteen implements Comparable<Canteen> {
    private String canteenCode;
    private String canteenName;
    private int trustScore;

    public Canteen(String canteenCode, String canteenName, int trustScore) {
        this.canteenCode = canteenCode;
        this.canteenName = canteenName;
        this.trustScore = trustScore;
    }

    public Canteen(String canteenCode, String canteenName) {
        this(canteenCode, canteenName, 3);
    }

    @Override
    public int compareTo(Canteen other) {
        // Sort by trustScore descending, then canteenCode case-insensitive, then name length
        if (this.trustScore != other.trustScore)
            return Integer.compare(other.trustScore, this.trustScore);
        int codeCompare = this.canteenCode.compareToIgnoreCase(other.canteenCode);
        if (codeCompare != 0) return codeCompare;
        return Integer.compare(this.canteenName.length(), other.canteenName.length());
    }

    public static Canteen[] rankCanteens(Canteen[] canteens) {
        for (int i = 0; i < canteens.length - 1; i++) {
            for (int j = 0; j < canteens.length - 1 - i; j++) {
                if (canteens[j].compareTo(canteens[j+1]) > 0) {
                    Canteen temp = canteens[j];
                    canteens[j] = canteens[j+1];
                    canteens[j+1] = temp;
                }
            }
        }
        return canteens;
    }

    public static void main(String[] args) {
        Canteen[] list = {
            new Canteen("HB3-C", "Spice Junction", 3),
            new Canteen("hb1-c", "Grand Mess", 5),
            new Canteen("HB2-C", "Southern Treats") // defaults to 3
        };
        Canteen[] ranked = rankCanteens(list);
        for (Canteen c : ranked) System.out.print(c.canteenCode + " ");
        System.out.println();
    }
}