package abstraction.assigment_problems;

public class UserProfile implements Exportable {
    private String username;

    public UserProfile(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    @Override
    public String exportData() {
        Exportable.CounterHolder.increment();
        return "Exported profile: " + username;
    }
}
