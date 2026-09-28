package object_modeling.assigment_problems;

import java.util.List;

public class HackathonTeam {
    private String teamName;
    private List<HackathonStudent> members;
    private TrackScoringRule track;
    private HackathonProject project;
    private HackathonScore score;

    public HackathonTeam(String teamName, List<HackathonStudent> members, TrackScoringRule track) {
        this.teamName = teamName;
        this.members = members;
        this.track = track;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<HackathonStudent> getMembers() {
        return members;
    }

    public TrackScoringRule getTrack() {
        return track;
    }

    public HackathonProject getProject() {
        return project;
    }

    public void setProject(HackathonProject project) {
        this.project = project;
    }

    public HackathonScore getScore() {
        return score;
    }

    public void setScore(HackathonScore score) {
        this.score = score;
    }
}
