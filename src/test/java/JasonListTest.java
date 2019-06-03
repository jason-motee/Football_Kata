import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class JasonListTest {

    private JasonList jasonList;

    @Before
    public void setUp(){
        jasonList = new JasonList();
    }

    @Test
    public void shouldAddStringToJasonList() {
        assertThat(jasonList.add("One")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One]");
        assertThat(jasonList.add("Two")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, Two]");
        assertThat(jasonList.add("Two")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, Two, Two]");
        assertThat(jasonList.add("Three")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, Two, Two, Three]");
    }

    @Test
    public void nonContiguousList() {
        assertThat(jasonList.add("One")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One]");
        assertThat(jasonList.add(null)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, null]");
        assertThat(jasonList.add("Two")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, null, Two]");
    }

    @Test
    public void addAndRemove() {
        assertThat(jasonList.add("One")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One]");
        assertThat(jasonList.add("Two")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, Two]");
        assertThat(jasonList.add("Three")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, Two, Three]");
        assertThat(jasonList.remove("Two")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, Three]");
        assertThat(jasonList.add("Four")).isEqualTo(true);
    }

    @Test
    public void nonContiguousArrayList() {
        assertThat(new ArrayList<>(Arrays.asList("One", null)).toString()).isEqualTo("[One, null]");
    }

    @Test
    public void shouldAddIntToJasonList() {
        assertThat(jasonList.add(1)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[1]");
        assertThat(jasonList.add(2)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[1, 2]");
    }

    @Test
    public void shouldAddBooleanToJasonList() {
        assertThat(jasonList.add(true)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[true]");
        assertThat(jasonList.add(false)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[true, false]");
    }

    @Test
    public void shouldRemoveFirstOccurrenceStringToJasonList() {
        assertThat(jasonList.add("One")).isEqualTo(true);
        assertThat(jasonList.add("One")).isEqualTo(true);
        assertThat(jasonList.add("Two")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, One, Two]");
        assertThat(jasonList.remove("One")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[One, Two]");
    }

    @Test
    public void shouldAddThenRemoveNullFromJasonList() {
        assertThat(jasonList.add(null)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[null]");
        assertThat(jasonList.remove(null)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[]");
    }

    @Test
    public void shouldBubbleSwapNumbersOneToFive() {
        assertThat(jasonList.add(5)).isEqualTo(true);
        assertThat(jasonList.add(3)).isEqualTo(true);
        assertThat(jasonList.add(1)).isEqualTo(true);
        assertThat(jasonList.add(2)).isEqualTo(true);
        assertThat(jasonList.add(4)).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[5, 3, 1, 2, 4]");
        jasonList.bubbleSort();
        assertThat(jasonList.toString()).isEqualTo("[1, 2, 3, 4, 5]");
    }

    @Test
    public void shouldBubbleSwapLettersAToF() {
        assertThat(jasonList.add("f")).isEqualTo(true);
        assertThat(jasonList.add("b")).isEqualTo(true);
        assertThat(jasonList.add("d")).isEqualTo(true);
        assertThat(jasonList.add("a")).isEqualTo(true);
        assertThat(jasonList.add("e")).isEqualTo(true);
        assertThat(jasonList.add("c")).isEqualTo(true);
        assertThat(jasonList.toString()).isEqualTo("[f, b, d, a, e, c]");
        jasonList.bubbleSort();
        assertThat(jasonList.toString()).isEqualTo("[a, b, c, d, e, f]");
    }

}