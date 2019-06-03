package Football;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FootballTableInterview {

    public List<String> convertTableFileToString(String path) throws IOException {
        return Files.lines(Paths.get(path)).skip(1).collect(Collectors.toList());
    }

    public List<String[]> splitTable(List<String> fileString) {
        return fileString.stream()
                .map(row -> row.split(" "))
                .map(rowArray -> Arrays.stream(rowArray)
                        .filter(index -> !index.equals("")).toArray(String[]::new))
                .collect(Collectors.toList());
    }

    public List<TeamData> createTeamData(List<String[]> table) {
        return table.stream()
                .map(row -> new TeamData(row[1], Integer.parseInt(row[6]), Integer.parseInt(row[8])))
                .collect(Collectors.toList());
    }


    public String getTeamWithSmallestGoalDiff(List<TeamData> tableRow) {
        tableRow.sort(new SortByGoalDifference());
        return tableRow.get(0).getTeamName();
    }

    class SortByGoalDifference implements Comparator<TeamData> {
        @Override
        public int compare(TeamData teamOne, TeamData teamTwo) {
            return teamOne.getGoalDifference() - teamTwo.getGoalDifference();
        }
    }
}