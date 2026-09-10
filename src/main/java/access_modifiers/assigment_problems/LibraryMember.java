package access_modifiers.assigment_problems;

public class LibraryMember {
    private String membershipId;
    private String branchCode;
    private double finesOwed;
    private String displayName;
    private boolean premiumMember;
    private String securityAnswer;

    public LibraryMember() {
        this(null, null);
    }

    public LibraryMember(String displayName) {
        this(null, displayName);
    }

    public LibraryMember(String membershipId, String displayName) {
        this.membershipId = membershipId;
        this.displayName = displayName;
    }

    public LibraryMember(String membershipId, String branchCode, double finesOwed, String displayName) {
        if (membershipId == null || membershipId.trim().length() < 4) {
            throw new IllegalArgumentException("construction rejected");
        }
        this.membershipId = membershipId.trim();
        this.branchCode = branchCode;
        this.finesOwed = finesOwed;
        this.displayName = displayName;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public void setMembershipId(String membershipId) {
        if (this.membershipId == null) {
            this.membershipId = membershipId;
        }
        // write-once logic: second call silently ignored
    }

    public String getBranchCode() {
        return branchCode;
    }

    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }

    public double getFinesOwed() {
        return finesOwed;
    }

    public void setFinesOwed(double finesOwed) {
        this.finesOwed = finesOwed;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isPremiumMember() {
        return premiumMember;
    }

    public void setPremiumMember(boolean premiumMember) {
        this.premiumMember = premiumMember;
    }

    public void setSecurityAnswer(String answer) {
        if (answer != null) {
            this.securityAnswer = Integer.toHexString(answer.hashCode());
        }
    }
    // No getter exists for securityAnswer (true write-only property)
}
