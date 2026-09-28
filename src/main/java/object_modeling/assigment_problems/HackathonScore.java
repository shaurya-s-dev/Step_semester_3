package object_modeling.assigment_problems;

public class HackathonScore {
    private double idea;
    private double execution;
    private double presentation;
    private double finalScore;

    public HackathonScore(double idea, double execution, double presentation, double finalScore) {
        this.idea = idea;
        this.execution = execution;
        this.presentation = presentation;
        this.finalScore = finalScore;
    }

    public double getIdea() {
        return idea;
    }

    public void setIdea(double idea) {
        this.idea = idea;
    }

    public double getExecution() {
        return execution;
    }

    public double getPresentation() {
        return presentation;
    }

    public double getFinalScore() {
        return finalScore;
    }
}
