package flik;

import org.junit.Test;
import static org.junit.Assert.*;

public class FlikTest {
    @Test
    public void checkEquals() {
        assertTrue(Flik.isSameNumber(1, 1));
        assertTrue(Flik.isSameNumber(2, 2));
    }
    @Test
    public void checkEquals2() {
        int i = 1;
        int j = 1;
        assertTrue(Flik.isSameNumber(i, j));
    }
}
