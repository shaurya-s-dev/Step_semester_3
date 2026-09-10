package access_modifiers.class_problems;

import java.util.Arrays;

public class DischargeSummary {
    private static final String MED_CODE_PATTERN = "^MED-[A-Z]$";

    // Static block for one-time shared state initialization
    static {
        // Shared ledger infrastructure initialized
    }

    private final String patientId;
    private final String[] medicationCodes;

    public DischargeSummary(String patientId, String[] medicationCodes) {
        if (patientId == null || medicationCodes == null) {
            throw new IllegalArgumentException("construction rejected");
        }
        for (String code : medicationCodes) {
            if (code == null || !code.matches(MED_CODE_PATTERN)) {
                throw new IllegalArgumentException("construction rejected");
            }
        }
        this.patientId = patientId;
        this.medicationCodes = Arrays.copyOf(medicationCodes, medicationCodes.length);
    }

    public String getPatientId() {
        return patientId;
    }

    public String[] getMedicationCodes() {
        return Arrays.copyOf(medicationCodes, medicationCodes.length);
    }

    public DischargeSummary withCorrectedMedication(int index, String newCode) {
        if (index < 0 || index >= medicationCodes.length || newCode == null || !newCode.matches(MED_CODE_PATTERN)) {
            throw new IllegalArgumentException("Invalid index or medication code");
        }
        String[] newCodes = Arrays.copyOf(medicationCodes, medicationCodes.length);
        newCodes[index] = newCode;
        return new DischargeSummary(this.patientId, newCodes);
    }

    public static String processNightlyBatch(DischargeSummary[] summaries) {
        int processed = 0;
        int nullSkipped = 0;
        int criticalCare = 0;
        int routine = 0;

        if (summaries != null) {
            for (DischargeSummary d : summaries) {
                if (d == null) {
                    nullSkipped++;
                } else {
                    processed++;
                    if (d instanceof CriticalCareDischargeSummary) {
                        criticalCare++;
                    } else {
                        routine++;
                    }
                }
            }
        }

        return processed + " processed | " + nullSkipped + " null skipped | " +
               criticalCare + " critical-care | " + routine + " routine";
    }
}
