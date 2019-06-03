import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
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

    public List<String[]> getDesiredData(List<String[]> table) {
        return table.stream()
                .map(row -> new String[] {row[1], row[6], row[8]})
                .collect(Collectors.toList());
    }


    public String getTeamWithSmallestGoalDiff(List<String[]> tableRow) {
        return null;
    }
}

// 1, 6, 8
