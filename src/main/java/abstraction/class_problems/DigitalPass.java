package abstraction.class_problems;

public class DigitalPass implements Renewable {
    private String resourceName;

    public DigitalPass(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getResourceName() {
        return resourceName;
    }

    @Override
    public String renew() {
        return resourceName + " renewed";
    }
}
