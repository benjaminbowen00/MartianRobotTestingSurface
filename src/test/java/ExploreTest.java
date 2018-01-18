import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ExploreTest {

    Surface surface1;
    Robot robot1;
    Robot robot2;
    Robot robot3;
    Explore explore1;
    Explore explore2;
    Explore explore3;

    @Before
    public void before(){
        surface1 = new Surface(5, 3);
        robot1 = new Robot(1, 1, "E", "RFRFRFRF");
        robot2 = new Robot(3, 2, "N", "FRRFLLFFRRFLL");
        robot3 = new Robot( 0, 3, "W", "LLFFFLFLFL");
        explore1 = new Explore(surface1, robot1);
        explore2 = new Explore(surface1, robot2);
        explore3 = new Explore(surface1, robot3);
    }

    @Test
    public void explore1Statement(){
        assertEquals("1 1 E", explore1.outputStatement());
    }

    @Test
    public void explore2Statement(){
//        assertEquals("1 1 E", explore1.outputStatement());
        assertEquals("3 3 N LOST", explore2.outputStatement());
    }

    @Test
    public void explore3Statement(){
        assertEquals("1 1 E", explore1.outputStatement());
        assertEquals("3 3 N LOST", explore2.outputStatement());
        assertEquals("2 3 S", explore3.outputStatement());
    }
}
