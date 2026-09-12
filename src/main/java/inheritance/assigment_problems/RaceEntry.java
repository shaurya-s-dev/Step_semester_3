package inheritance.assigment_problems;

import java.util.ArrayList;
import java.util.List;

public class RaceEntry {
    private static int bibCounter = 0;

    private final String entryCode;
    private String bibNumber;
    protected double entryFee;
    protected double amountPaid;
    private final List<Double> lateFeeHistory = new ArrayList<>();

    public RaceEntry(String bibNumber, double entryFee) {
        if (bibNumber == null || bibNumber.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.bibCounter++;
        this.entryCode = "BIB-" + bibCounter;
        this.bibNumber = bibNumber.trim();
        this.entryFee = entryFee;
        this.amountPaid = 0.0;
    }

    public String getEntryCode() {
        return entryCode;
    }

    public String getBibNumber() {
        return bibNumber;
    }

    public double getEntryFee() {
        return entryFee;
    }

    public double getBalanceDue() {
        double totalFees = 0.0;
        for (double fee : lateFeeHistory) {
            totalFees += fee;
        }
        return (entryFee + totalFees) - amountPaid;
    }

    public void pay(double amount) {
        this.amountPaid += amount;
    }

    public void pay(double amount, String mode) {
        // System.out.println("Paying via " + mode);
        pay(amount);
    }

    protected void applyLateFee(double amount) {
        lateFeeHistory.add(amount);
    }

    public double[] getLateFeeHistory() {
        double[] copy = new double[lateFeeHistory.size()];
        for (int i = 0; i < lateFeeHistory.size(); i++) {
            copy[i] = lateFeeHistory.get(i);
        }
        return copy;
    }

    public String announce() {
        return "Race Entry | Bib: " + bibNumber + " | Balance: " + getBalanceDue();
    }

    public static boolean isValidDiscountCode(String code) {
        if (code == null || code.length() != 5) {
            return false;
        }
        if (code.charAt(0) != 'M') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) ||
            !Character.isDigit(code.charAt(2)) ||
            !Character.isDigit(code.charAt(3))) {
            return false;
        }
        return Character.isUpperCase(code.charAt(4));
    }

    public static int getBibCounter() {
        return bibCounter;
    }

    public static String registerBatch(String[] bibNumbers, double entryFee) {
        int registered = 0;
        int rejected = 0;

        if (bibNumbers != null) {
            for (String bib : bibNumbers) {
                try {
                    new RaceEntry(bib, entryFee);
                    registered++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(RaceEntry entry) {
        if (entry instanceof EliteRunnerEntry) {
            return "Multilevel descendant (3 generations deep)";
        } else if (entry instanceof RelayTeamEntry) {
            return "Hierarchical sibling (independent branch)";
        } else if (entry instanceof RunnerEntry) {
            return "Single inheritance child";
        }
        return "Base generation";
    }

    public static double getTotalBalanceDue(RaceEntry[] entries) {
        double total = 0.0;
        if (entries != null) {
            for (RaceEntry e : entries) {
                if (e != null) {
                    total += e.getBalanceDue();
                }
            }
        }
        return total;
    }

    public static String announceAll(RaceEntry[] entries) {
        StringBuilder sb = new StringBuilder();
        if (entries != null) {
            for (RaceEntry e : entries) {
                if (e == null) continue;
                sb.append(e.announce());
                if (e instanceof RelayTeamEntry) {
                    RelayTeamEntry r = (RelayTeamEntry) e;
                    sb.append(" [Team size via downcast: ")
                      .append(r.getTeamSize())
                      .append("]");
                }
                sb.append(" | ");
            }
        }
        return sb.toString();
    }

    public static String settleNight(RaceEntry[] entries) {
        int processed = 0;
        int nullSkipped = 0;
        int relayCount = 0;
        int individualCount = 0;

        if (entries != null) {
            for (RaceEntry e : entries) {
                if (e == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (e instanceof RelayTeamEntry) {
                        relayCount++;
                    } else {
                        individualCount++;
                    }
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " +
               relayCount + " relay | " + individualCount + " individual";
    }
}
