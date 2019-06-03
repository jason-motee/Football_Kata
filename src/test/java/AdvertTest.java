import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdvertTest {

    private Advert advertOne;
    private Advert advertTwo;
    private Advert advertOneCopied;

    @Before
    public void setUp() {
        advertOne = new Advert("Ford", "Focus", "QWERTY", "100");
        advertTwo = new Advert("Ford", "Focus", "QSERTY", "200");
        advertOneCopied = new Advert("Ford", "Focus", "QWERTY", "100");
    }

    @Test
    public void shouldCheckEqualityOfTwoAdverts() {
        assertThat(advertOne.equals(advertTwo)).isFalse();
        assertThat(advertOne.equals(advertOne)).isTrue();
        assertThat(advertOne.equals(advertOneCopied)).isTrue();
    }

    @Test
    public void shouldCheckEqualityUsingHashCodeOfTwoAdverts() {
        assertThat(advertOne.equals(advertTwo)).isFalse();
        assertThat(advertOne.equals(advertOne)).isTrue();
        assertThat(advertOne.equals(advertOneCopied)).isTrue();
    }
}
