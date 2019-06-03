package football;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FootballTableInterviewTest {

    private FootballTableInterview footballTableInterview;

    @Before
    public void setUp() {
        footballTableInterview = new FootballTableInterview();
    }

    @Test
    public void shouldConvertFileToListOfString() throws IOException {
        // given
        String file = "src/Data/football_table.dat";

        // when
        List<String> fileAsString = footballTableInterview.convertTableFileToString(file);

        // then
        List<String> expected = new ArrayList<>();
        expected.add("    1. Arsenal         38    26   9   3    79  -  36    87");
        assertThat(fileAsString).contains(expected.get(0));

    }

    @Test
    public void splitIntoWordsShouldReturnAListOfStringArraysWithNoEmptyIndexes() {
        // given
        List<String> tableRow = new ArrayList<>();
        tableRow.add("    1. Arsenal         38    26   9   3    79  -  36    87");

        // when
        List<String[]> actual = footballTableInterview.splitTable(tableRow);

        // then
        List<String[]> expected = new ArrayList<>();
        String[] tableRowArray = new String[]{"1.", "Arsenal", "38", "26", "9", "3", "79", "-", "36", "87"};
        expected.add(tableRowArray);

        assertThat(actual).containsExactlyElementsOf(expected);
    }

    @Test
    public void shouldGiveListOfTeamsWithDesiredData() {
        // given
        List<String[]> tableRow = new ArrayList<>();
        String[] tableRowArray = new String[]{"1.", "Arsenal", "38", "26", "9", "3", "79", "-", "36", "87"};
        tableRow.add(tableRowArray);

        // when
        List<TeamData> actual = footballTableInterview.createTeamData(tableRow);

        // then
        List<TeamData> expected = new ArrayList<>();
        expected.add(new TeamData ("Arsenal", 79, 36));

        assertThat(actual.get(0).getTeamName()).isEqualTo(expected.get(0).getTeamName());
        assertThat(actual.get(0).getGoalsFor()).isEqualTo(expected.get(0).getGoalsFor());
        assertThat(actual.get(0).getGoalsAgainst()).isEqualTo(expected.get(0).getGoalsAgainst());
    }

    @Test
    public void shouldReturnTeamWithTheSmallestGoalDifference() {
        // given
        TeamData arsenal = new TeamData("Arsenal", 79, 36);
        TeamData liverpool = new TeamData("Liverpool", 67, 30);
        TeamData teamAt = new TeamData("Team AT", 1, 1);

        List<TeamData> tableRow = new ArrayList<>();
        tableRow.add(arsenal);
        tableRow.add(liverpool);
        tableRow.add(teamAt);

        // when
        String actual = footballTableInterview.getTeamWithSmallestGoalDiff(tableRow);

        // then
        String expected = "Team AT";
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    public void shouldReturnSolutionToProblem() throws IOException {
        // given
        TeamData arsenal = new TeamData("Arsenal", 79, 36);
        TeamData liverpool = new TeamData("Liverpool", 67, 30);
        TeamData manchesterU = new TeamData("Manchester_U", 87, 45);
        TeamData astonVilla = new TeamData("Aston_Villa", 46, 47);

        List<TeamData> teamList = new ArrayList<>();
        teamList.add(arsenal);
        teamList.add(liverpool);
        teamList.add(manchesterU);
        teamList.add(astonVilla);

        // when
        String team = footballTableInterview.getTeamWithSmallestGoalDiff(teamList);

        // then
        assertThat(team).isEqualTo("Aston_Villa");
    }
}