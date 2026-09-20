package abstraction.assigment_problems;

public class Trap implements Defendable {
    private String trapType;

    public Trap(String trapType) {
        this.trapType = trapType;
    }

    public String getTrapType() {
        return trapType;
    }

    @Override
    public String defend() {
        return trapType + " triggers automatically";
    }
}
