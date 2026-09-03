package week4.assignment_problems;

public class AccountProcessor {
    public static void processAccount(DeliveryAccount account, double amount, int delayMinutes) {
        // Not used; we'll use processBatch directly
    }

    public static void processBatch(DeliveryAccount[] accounts, double[] amounts, int[] delayMinutesArray) {
        int processed = 0, nullSkipped = 0, premium = 0, regular = 0;
        double grandTotal = 0;
        int len = Math.min(accounts.length, Math.min(amounts.length, delayMinutesArray.length));

        for (int i = 0; i < len; i++) {
            if (accounts[i] == null) {
                nullSkipped++;
                continue;
            }
            double penalty = accounts[i].calculateSurgeFee(delayMinutesArray[i]);
            grandTotal += penalty;
            processed++;
            if (accounts[i] instanceof PremiumAccount) premium++;
            else regular++;
        }
        System.out.println(processed + " processed | " + nullSkipped + " null skipped | " +
                premium + " premium | " + regular + " regular | grand total surge fees = " + grandTotal);
    }

    public static void main(String[] args) {
        DeliveryAccount[] accounts = {
            new PremiumAccount("STU001", 500),
            null,
            new DeliveryAccount("STU002", 300)
        };
        double[] amounts = {500, 400, 300};
        int[] delay = {10, 5, 0};
        processBatch(accounts, amounts, delay);
    }
}