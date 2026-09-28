package object_modeling.assigment_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Hackathon {
    public enum State { OPEN, JUDGING, PUBLISHED }

    private String name;
    private State state;
    private List<HackathonTeam> teams;
    private Set<String> registeredStudents;
    private Map<String, HackathonTeam> teamsByName;

    public Hackathon(String name) {
        this.name = name;
        this.state = State.OPEN;
        this.teams = new ArrayList<>();
        this.registeredStudents = new HashSet<>();
        this.teamsByName = new HashMap<>();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public String registerTeam(String teamName, List<HackathonStudent> members, TrackScoringRule track) {
        if (members == null || members.size() < 2 || members.size() > 4) {
            return "Registration failed: A team must have 2 to 4 members.";
        }

        for (HackathonStudent s : members) {
            if (registeredStudents.contains(s.getName())) {
                return "Registration failed: Student " + s.getName() + " already belongs to a team.";
            }
        }

        for (HackathonStudent s : members) {
            registeredStudents.add(s.getName());
        }

        HackathonTeam team = new HackathonTeam(teamName, members, track);
        teams.add(team);
        teamsByName.put(teamName, team);

        return String.format("Team %s registered (%d members, %s).",
                teamName, members.size(), track.getTrackName());
    }

    public String submitProject(String teamName, String projectTitle) {
        HackathonTeam team = teamsByName.get(teamName);
        if (team == null) {
            return "Submission failed: Team not found.";
        }
        if (team.getProject() != null) {
            return "Submission failed: Team already submitted a project.";
        }
        HackathonProject project = new HackathonProject(projectTitle);
        team.setProject(project);
        return String.format("Project '%s' submitted by %s.", projectTitle, teamName);
    }

    public String scoreProject(String teamName, double idea, double execution, double presentation) {
        if (state == State.PUBLISHED) {
            return "Rescore rejected: Results have already been published.";
        }
        HackathonTeam team = teamsByName.get(teamName);
        if (team == null || team.getProject() == null) {
            return "Scoring failed: Project not found.";
        }
        double finalScore = team.getTrack().calculateFinalScore(idea, execution, presentation);
        HackathonScore score = new HackathonScore(idea, execution, presentation, finalScore);
        team.setScore(score);
        return String.format("Score recorded for '%s'. Final score: %.2f.",
                team.getProject().getTitle(), finalScore);
    }

    public String rescoreIdea(String teamName, double newIdea) {
        if (state == State.PUBLISHED) {
            return "Rescore rejected: Results have already been published.";
        }
        HackathonTeam team = teamsByName.get(teamName);
        if (team == null || team.getScore() == null) {
            return "Rescore failed: Score not found.";
        }
        team.getScore().setIdea(newIdea);
        return "Score updated.";
    }

    public String publishResults() {
        this.state = State.PUBLISHED;
        return "Results published.";
    }
}
