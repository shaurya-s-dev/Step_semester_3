package abstraction.class_problems;

public class AudioFile extends MediaFile implements Playable {
    private String title;

    public AudioFile(String title) {
        super();
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String play() {
        return "Playing audio: " + title;
    }

    @Override
    public String play(int fromSecond) {
        int m = fromSecond / 60;
        int s = fromSecond % 60;
        return "Playing audio: " + title + " from " + String.format("%d:%02d", m, s);
    }

    @Override
    public String pause() {
        return "Paused audio: " + title;
    }

    @Override
    public String getFormatInfo() {
        return "Audio file, ID: " + getFileId();
    }
}
