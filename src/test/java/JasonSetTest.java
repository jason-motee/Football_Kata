import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JasonSetTest {

    private JasonSet jasonSet;

    @Before
    public void setUp() {
        jasonSet = new JasonSet();
    }

    @Test
    public void shouldAddStringToJasonSet() {
        assertThat(jasonSet.add("One")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One]");
        assertThat(jasonSet.add("Two")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One, Two]");
        assertThat(jasonSet.add("Two")).isEqualTo(false);
        assertThat(jasonSet.toString()).isEqualTo("[One, Two]");
        assertThat(jasonSet.add("Three")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One, Two, Three]");
        assertThat(jasonSet.add("Three")).isEqualTo(false);
        assertThat(jasonSet.toString()).isEqualTo("[One, Two, Three]");
    }

    @Test
    public void shouldReturnFalseWhenItemIsAlreadyInJasonSet() {
        assertThat(jasonSet.add("One")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One]");
        assertThat(jasonSet.add("One")).isEqualTo(false);
        assertThat(jasonSet.toString()).isEqualTo("[One]");
    }

    @Test
    public void shouldRemoveStringToJasonSet() {
        assertThat(jasonSet.add("One")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One]");
        assertThat(jasonSet.add("Two")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One, Two]");
        assertThat(jasonSet.add("Three")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One, Two, Three]");
        assertThat(jasonSet.remove("Three")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One, Two]");
        assertThat(jasonSet.remove("One")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[Two]");
    }

    @Test
    public void shouldReturnFalseWhenItemIsNotAvailableToRemoveInJasonSet() {
        assertThat(jasonSet.add("One")).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[One]");
        assertThat(jasonSet.remove("Three")).isEqualTo(false);
        assertThat(jasonSet.toString()).isEqualTo("[One]");
    }

    @Test
    public void shouldAddNullToJasonSet() {
        assertThat(jasonSet.add(null)).isEqualTo(true);
        assertThat(jasonSet.toString()).isEqualTo("[null]");
    }

    @Test
    public void shouldRemoveNullToJasonSet() {
        assertThat(jasonSet.add(null)).isEqualTo(true);
        assertThat(jasonSet.add(null)).isEqualTo(false);
        assertThat(jasonSet.toString()).isEqualTo("[null]");
    }

    @Test
    public void shouldAddToNewStrings() {
        assertThat(jasonSet.add(new Integer(1))).isEqualTo(true);
        assertThat(jasonSet.add(new Integer(1))).isEqualTo(false);
        assertThat(jasonSet.toString()).isEqualTo("[1]");

    }

}
