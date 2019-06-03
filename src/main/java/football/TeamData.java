package football;

public class TeamData {

    private String teamName;
    private int goalsFor;
    private int goalsAgainst;

    public TeamData(String teamName, int goalsFor, int goalsAgainst) {
        this.teamName = teamName;
        this.goalsFor = goalsFor;
        this.goalsAgainst = goalsAgainst;
    }

    public String getTeamName() {
        return teamName;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public int getGoalDifference() {
        return Math.abs(goalsFor - goalsAgainst);
    }
}
