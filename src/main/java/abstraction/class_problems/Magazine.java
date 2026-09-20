package abstraction.class_problems;

public class Magazine extends LibraryItem implements Renewable {
    private String title;

    public Magazine(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public int getLoanPeriodDays() {
        return 7;
    }

    @Override
    public String renew() {
        return title + " renewed";
    }
}
