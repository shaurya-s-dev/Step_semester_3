package inheritance.class_problems;

import java.util.ArrayList;
import java.util.List;

public class EventTicket {
    private static int ticketCounter = 1000;

    private final String ticketId;
    private String attendeeId;
    protected double basePrice;
    protected double amountPaid;
    private final List<Double> lateFeeHistory = new ArrayList<>();

    public EventTicket(String attendeeId, double basePrice) {
        if (attendeeId == null || attendeeId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.ticketId = "TCK-" + (++ticketCounter);
        this.attendeeId = attendeeId.trim();
        this.basePrice = basePrice;
        this.amountPaid = 0.0;
    }

    public EventTicket(double basePrice) {
        this.ticketId = "TCK-" + (++ticketCounter);
        this.attendeeId = null;
        this.basePrice = basePrice;
        this.amountPaid = 0.0;
    }

    public String getTicketId() {
        return ticketId;
    }

    public String getAttendeeId() {
        return attendeeId;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public double getBalanceDue() {
        double totalFees = 0.0;
        for (double fee : lateFeeHistory) {
            totalFees += fee;
        }
        return (basePrice + totalFees) - amountPaid;
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

    public String printTicket() {
        return "Standard Event Ticket | Balance Due: " + getBalanceDue();
    }

    public static boolean isValidPromoCode(String code) {
        if (code == null || code.length() != 5) {
            return false;
        }
        if (code.charAt(0) != 'F') {
            return false;
        }
        if (!Character.isDigit(code.charAt(1)) ||
            !Character.isDigit(code.charAt(2)) ||
            !Character.isDigit(code.charAt(3))) {
            return false;
        }
        return Character.isUpperCase(code.charAt(4));
    }

    public static int getTicketsIssued() {
        return ticketCounter - 1000;
    }

    public static String registerBatch(String[] attendeeIds, double basePrice) {
        int registered = 0;
        int rejected = 0;

        if (attendeeIds != null) {
            for (String id : attendeeIds) {
                try {
                    new EventTicket(id, basePrice);
                    registered++;
                } catch (IllegalArgumentException e) {
                    rejected++;
                }
            }
        }

        return "Registered: " + registered + " | Rejected: " + rejected;
    }

    public static String classifyGeneration(EventTicket ticket) {
        if (ticket instanceof PremiumWorkshopTicket) {
            return "Multilevel descendant (3 generations deep)";
        } else if (ticket instanceof HackathonTicket) {
            return "Hierarchical sibling (independent branch)";
        } else if (ticket instanceof WorkshopTicket) {
            return "Single inheritance child";
        }
        return "Base generation";
    }

    public static double getTotalBalanceDue(EventTicket[] tickets) {
        double total = 0.0;
        if (tickets != null) {
            for (EventTicket t : tickets) {
                if (t != null) {
                    total += t.getBalanceDue();
                }
            }
        }
        return total;
    }

    public static String batchPrint(EventTicket[] tickets) {
        StringBuilder sb = new StringBuilder();
        if (tickets != null) {
            for (EventTicket t : tickets) {
                if (t == null) continue;
                if (t instanceof WorkshopTicket) {
                    WorkshopTicket w = (WorkshopTicket) t;
                    sb.append("Workshop | Track: ")
                      .append(w.getTrack())
                      .append(" | Balance: ")
                      .append(w.getBalanceDue())
                      .append(" [Track via downcast: ")
                      .append(w.getTrack())
                      .append("] | ");
                } else {
                    sb.append("Standard | Balance: ")
                      .append(t.getBalanceDue())
                      .append(" | ");
                }
            }
        }
        return sb.toString();
    }

    public static String processNightlySettlement(EventTicket[] tickets) {
        int processed = 0;
        int nullSkipped = 0;
        int groupCount = 0;
        int individualCount = 0;

        if (tickets != null) {
            for (EventTicket t : tickets) {
                if (t == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (t instanceof GroupTicket) {
                        groupCount++;
                    } else {
                        individualCount++;
                    }
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " +
               groupCount + " group | " + individualCount + " individual";
    }
}
