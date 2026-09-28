package object_modeling.assigment_problems;

public interface TrackScoringRule {
    String getTrackName();
    double calculateFinalScore(double idea, double execution, double presentation);
}
