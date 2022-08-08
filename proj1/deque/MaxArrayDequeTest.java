package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class MaxArrayDequeTest {
    @Test
    public void IntMaxTest() {
        IntComparator c = new IntComparator();
        MaxArrayDeque<Integer> testArray = new MaxArrayDeque<>(c);
        testArray.addLast(1);
        testArray.addLast(3);
        testArray.addLast(2);
        int expected = 3;
        int actual = testArray.max();
        assertEquals(expected, actual);
    }
    @Test
    public void StringMaxTest() {
        StringComparator c = new StringComparator();
        MaxArrayDeque<String> testArray = new MaxArrayDeque<>(c);
        testArray.addLast("Charlie");
        testArray.addFirst("Jack");
        testArray.addFirst("Timmy");
        String expected = "Timmy";
        String actual = testArray.max();
        assertEquals(expected,actual);
    }
}
