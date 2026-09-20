package abstraction.class_problems;

public interface Playable {
    String play();
    String play(int fromSecond);
    String pause();

    static void launchAll(Playable[] items) {
        if (items != null) {
            for (Playable item : items) {
                if (item != null) {
                    System.out.println(item.play());
                }
            }
        }
    }
}
