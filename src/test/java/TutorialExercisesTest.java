import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.*;

public class TutorialExercisesTest {

    private Exercises exercises;

    @Before
    public void setUp() {
        exercises = new Exercises();
    }

    @Test
    public void shouldTakeInStringOfNames_ThenReturnCollection() {
        List<String> nameList = exercises.getListOfNames(exercises.oneGetFirstNames());
        assertThat(nameList).hasSize(283);
    }

    @Test
    public void shouldTakeInStringOfNames_ThenReturnCollectionWithNoDuplicates() {
        Set<String> nameList = exercises.getCollectionOfNamesWithNoDuplicates(exercises.getListOfNames(exercises.oneGetFirstNames()));
        assertThat(nameList).containsOnlyOnce("Mark");
    }

    @Test
    public void shouldTakeInStringOfNames_ThenReturnMapWithNumberForEachName() {
        Map<String, Integer> nameList = exercises.getNumberOfEachName(exercises.getListOfNames(exercises.threeGetFirstNames()));

        assertThat(nameList.get("Mark")).isEqualTo(6);
    }

    @Test
    public void shouldTakeInFullNames_ThenReturnCollectionOfFirstNames() {
        Set<String> nameList = exercises.getUniqueFirstNamesFromFullNames(exercises.fourGetFirstNames());
        assertThat(nameList).containsOnlyOnce("Jenniffer", "Randee", "Mai");
        assertThat(nameList).doesNotContain("Dail");
    }

    @Test
    public void checkIfInAlphabeticalOrder() {
        List<String> unorderedNameList = exercises.getListOfNames(exercises.fiveGetFullNames());

        List<String> orderedNameList = Arrays.asList("Abby", "Ade", "Bob", "Bob", "Cindy", "Dale", "Eli");
        List<String> unorderedNameList2 = Arrays.asList("Ade", "Abby", "Bob", "Cindy", "Dale", "Eli");

        assertThat(exercises.checkIfOrdered(unorderedNameList)).isEqualTo(false);
        assertThat(exercises.checkIfOrdered(orderedNameList)).isEqualTo(true);
        assertThat(exercises.checkIfOrdered(unorderedNameList2)).isEqualTo(false);
    }

    @Test
    public void shouldSwapKeysAroundForMap() {
        Map<String, String> staffToDepartmentMap = exercises.sixGetNameAndJob();

        assertThat(exercises.swapKeyAndValue(staffToDepartmentMap)).containsKeys("Reception", "Finance", "IT");
        assertThat(exercises.swapKeyAndValue(staffToDepartmentMap)).contains(entry("Finance", "James Franklin, Sarah Jones"));
        assertThat(exercises.swapKeyAndValue(staffToDepartmentMap)).contains(entry("Reception", "Bob Smith"));
        assertThat(exercises.swapKeyAndValue(staffToDepartmentMap)).contains(entry("IT", "Rita Wright, Janice Warburton"));
        assertThat(exercises.swapKeyAndValue(staffToDepartmentMap)).contains(entry("Recruitment", "Mark Smith, Sue Griffiths"));
    }

    @Test
    public void shouldCreateMapContainingFirstInitialsAndTheirCount() {
        String fullNames = exercises.fiveGetFullNames();

        assertThat(exercises.getFirstInitialCountMap(fullNames)).contains(entry("A", 2));
        assertThat(exercises.getFirstInitialCountMap(fullNames)).contains(entry("B", 4));
        assertThat(exercises.getFirstInitialCountMap(fullNames)).contains(entry("C", 7));
    }

    @Test
    public void shouldCreateMapContainingBothInitialsAndTheirCount() {
        String fullNames = exercises.fiveGetFullNames();
        assertThat(exercises.getBothInitialsCountMap(fullNames)).contains(entry("AS", 1));
        assertThat(exercises.getBothInitialsCountMap(fullNames)).contains(entry("AW", 1));
        assertThat(exercises.getBothInitialsCountMap(fullNames)).contains(entry("BG", 1));
        assertThat(exercises.getBothInitialsCountMap(fullNames)).contains(entry("BL", 2));
    }

//    @Test
//    public void shouldCould

}
