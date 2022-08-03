package flik;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class FlikTest {
    @Test
    public void CheckEquals() {
        assertTrue(Flik.isSameNumber(1,1));
        assertTrue(Flik.isSameNumber(2,2));
    }
    @Test
    public void CheckEquals2() {
        int i = 1;
        int j = 1;
        assertTrue(Flik.isSameNumber(i,j));
    }
}
