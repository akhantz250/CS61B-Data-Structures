package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
    @Test
    public void testThreeAddThree() {
        AListNoResizing<Integer> fixed = new AListNoResizing<>();
        BuggyAList<Integer> buggy = new BuggyAList<>();
        fixed.addLast(4);
        buggy.addLast(4);
        fixed.addLast(5);
        buggy.addLast(5);
        fixed.addLast(6);
        buggy.addLast(6);
        assertEquals(fixed.removeLast(),buggy.removeLast());
        assertEquals(fixed.removeLast(),buggy.removeLast());
        assertEquals(fixed.removeLast(),buggy.removeLast());
        return;
    }
    @Test
    public void randomizedTest() {
        AListNoResizing<Integer> L = new AListNoResizing<>();
        BuggyAList<Integer> bugged = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                L.addLast(randVal);
                bugged.addLast(randVal);
                /*System.out.println("addLast(" + randVal + ")");*/
            } else if (operationNumber == 1) {
                // size
                int size = L.size();
                int bugged_size = bugged.size();
                /*System.out.println("correct size: " + size + " bugged size: " + bugged_size);*/
            } else if (operationNumber ==2) {
                if (L.size() == 0) {
                    continue;
                } else {
                    int last = L.getLast();
                    int bugged_last = bugged.getLast();
                    /*System.out.println("correct last: " + last + " bugged last: " + bugged_last);*/
                }
            } else if (operationNumber ==3 ) {
                if (L.size() == 0) {
                    continue;
                } else {
                    int removed = L.removeLast();
                    int bugged_removed = bugged.removeLast();
                   /* System.out.println("correct removed: " + removed + " bugged removed: " + bugged_removed);*/
                }
            }
        }
    }
}
