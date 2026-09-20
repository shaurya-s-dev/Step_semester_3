package abstraction.assigment_problems;

public class MobileApp implements RemoteControllable {
    private String appName;

    public MobileApp(String appName) {
        this.appName = appName;
    }

    public String getAppName() {
        return appName;
    }

    @Override
    public String connect(String appId) {
        return appName + " connected to " + appId;
    }
}
