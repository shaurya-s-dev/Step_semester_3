package object_modeling.assigment_problems;

public class OpenTrack implements TrackScoringRule {

    @Override
    public String getTrackName() {
        return "Open track";
    }

    @Override
    public double calculateFinalScore(double idea, double execution, double presentation) {
        return (idea + execution + presentation) / 3.0;
    }
}
