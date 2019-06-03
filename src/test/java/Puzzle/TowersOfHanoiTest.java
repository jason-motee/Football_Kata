package Puzzle;

import org.junit.Before;
import org.junit.Test;

public class TowersOfHanoiTest {

    private TowersOfHanoi towersOfHanoi;

    @Before
    public void setUp() {
        Tower towerOne = new Tower();
        Tower towerTwo = new Tower();
        Tower towerThree = new Tower();

        towersOfHanoi = new TowersOfHanoi(towerOne, towerTwo, towerThree);
    }

    @Test
    public void shouldMoveFirstDiscToTheRightTower(){
        // given
        towersOfHanoi.moveDiscFromFirstToSecondTower();

        // when


        //then
    }

}