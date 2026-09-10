package access_modifiers.class_problems;

public class PatientProfile {
    private String patientId;
    private String name;
    private boolean discharged;
    private String lockerPin;

    public PatientProfile() {
        this(null, null);
    }

    public PatientProfile(String name) {
        this(null, name);
    }

    public PatientProfile(String patientId, String name) {
        this.patientId = patientId;
        this.name = name;
        this.discharged = false;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        if (this.patientId == null) {
            this.patientId = patientId;
        }
        // write-once: second call silently ignored
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }

    public void setLockerPin(String pin) {
        if (pin != null) {
            // Store deterministic one-way hash or internal string
            this.lockerPin = Integer.toHexString(pin.hashCode());
        }
    }
    // No matching getter exists anywhere for lockerPin (true write-only property)
}
