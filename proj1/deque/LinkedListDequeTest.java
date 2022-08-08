package deque;

import org.junit.Test;
import static org.junit.Assert.*;


/** Performs some basic linked list tests. */
public class LinkedListDequeTest {

    @Test
    /** Adds a few things to the list, checking isEmpty() and size() are correct,
     * finally printing the results.
     *
     * && is the "and" operation. */
    public void addIsEmptySizeTest() {

        /*System.out.println("Make sure to uncomment the lines below (and delete this print statement).");*/
        LinkedListDeque<String> lld1 = new LinkedListDeque<String>();

		assertTrue("A newly initialized LLDeque should be empty", lld1.isEmpty());
		lld1.addFirst("front");

		// The && operator is the same as "and" in Python.
		// It's a binary operator that returns true if both arguments true, and false otherwise.
        assertEquals(1, lld1.size());
        assertFalse("lld1 should now contain 1 item", lld1.isEmpty());

		lld1.addLast("middle");
		assertEquals(2, lld1.size());

		lld1.addLast("back");
		assertEquals(3, lld1.size());

		System.out.println("Printing out deque: ");
		lld1.printDeque();
    }

    @Test
    /** Adds an item, then removes an item, and ensures that dll is empty afterwards. */
    public void addRemoveTest() {

        /*System.out.println("Make sure to uncomment the lines below (and delete this print statement).");*/
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
		// should be empty
		assertTrue("lld1 should be empty upon initialization", lld1.isEmpty());

		lld1.addFirst(10);
		// should not be empty
		assertFalse("lld1 should contain 1 item", lld1.isEmpty());

		lld1.removeFirst();
		// should be empty
		assertTrue("lld1 should be empty after removal", lld1.isEmpty());
    }

    @Test
    /* Tests removing from an empty deque */
    public void removeEmptyTest() {

        /*System.out.println("Make sure to uncomment the lines below (and delete this print statement).");*/
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<>();
        lld1.addFirst(3);

        lld1.removeLast();
        lld1.removeFirst();
        lld1.removeLast();
        lld1.removeFirst();

        int size = lld1.size();
        String errorMsg = "  Bad size returned when removing from empty deque.\n";
        errorMsg += "  student size() returned " + size + "\n";
        errorMsg += "  actual size() returned 0\n";

        assertEquals(errorMsg, 0, size);
    }

    @Test
    /* Check if you can create LinkedListDeques with different parameterized types*/
    public void multipleParamTest() {

        LinkedListDeque<String>  lld1 = new LinkedListDeque<String>();
        LinkedListDeque<Double>  lld2 = new LinkedListDeque<Double>();
        LinkedListDeque<Boolean> lld3 = new LinkedListDeque<Boolean>();

        lld1.addFirst("string");
        lld2.addFirst(3.14159);
        lld3.addFirst(true);

        String s = lld1.removeFirst();
        double d = lld2.removeFirst();
        boolean b = lld3.removeFirst();
    }

    @Test
    /* check if null is return when removing from an empty LinkedListDeque. */
    public void emptyNullReturnTest() {

        /*System.out.println("Make sure to uncomment the lines below (and delete this print statement).");*/
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();

        boolean passed1 = false;
        boolean passed2 = false;
        assertEquals("Should return null when removeFirst is called on an empty Deque,", null, lld1.removeFirst());
        assertEquals("Should return null when removeLast is called on an empty Deque,", null, lld1.removeLast());

    }

    @Test
    /* Add large number of elements to deque; check if order is correct. */
    public void bigLLDequeTest() {

        /*System.out.println("Make sure to uncomment the lines below (and delete this print statement).");*/
        LinkedListDeque<Integer> lld1 = new LinkedListDeque<Integer>();
        for (int i = 0; i < 1000000; i++) {
            lld1.addLast(i);
        }

        for (double i = 0; i < 500000; i++) {
            assertEquals("Should have the same value", i, (double) lld1.removeFirst(), 0.0);
        }

        for (double i = 999999; i > 500000; i--) {
            assertEquals("Should have the same value", i, (double) lld1.removeLast(), 0.0);
        }

    }
    @Test
    public void printsCorrectly(){
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addFirst(3);
        lst.addFirst(2);
        lst.addFirst(1);
        lst.addLast(4);
        // Should print 1 2 3 4
        lst.printDeque();
        assertEquals(lst.size(), 4);
    }
    @Test
    public void getCorrectItem() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addFirst(3);
        lst.addFirst(2);
        lst.addFirst(1);
        lst.addLast(4);
        int secondItem = lst.get(1);
        int thridItem = lst.get(2);
        assertEquals(2, secondItem);
        assertEquals(3, thridItem);
        assertNull(lst.get(4));
        assertNull(lst.get(-1));
    }
    @Test
    public void getCorrectItemRecursively() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addFirst(3);
        lst.addFirst(2);
        lst.addFirst(1);
        lst.addLast(4);
        int secondItem = lst.getRecursively(1);
        int thridItem = lst.getRecursively(2);
        assertEquals(2, secondItem);
        assertEquals(3, thridItem);
        assertNull(lst.getRecursively(4));
        assertNull(lst.getRecursively(-1));
    }
    @Test
    public void EmptyTest() {
        LinkedListDeque<Integer> empty = new LinkedListDeque<>();
        LinkedListDeque<Integer> notEmpty = new LinkedListDeque<>();
        notEmpty.addFirst(1);
        assertFalse(notEmpty.isEmpty());
        assertTrue(empty.isEmpty());
    }
    @Test
    public void RemoveFirst() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addFirst(3);
        lst.addFirst(2);
        lst.addFirst(1);
        lst.addLast(4);
        int removed = lst.removeFirst();
        assertEquals(1,removed);
        assertEquals(3, lst.size());
        lst.printDeque();
        lst.printDequeReverse();
    }
    @Test
    public void RemoveLast() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addFirst(3);
        lst.addFirst(2);
        lst.addFirst(1);
        lst.addLast(4);
        int removed = lst.removeLast();
        assertEquals(4,removed);
        assertEquals(3, lst.size());
        lst.printDeque();
        lst.printDequeReverse();
    }
    @Test
    public void LinkedListIteration() {
        LinkedListDeque<Integer> lst = new LinkedListDeque<>();
        lst.addLast(1);
        lst.addLast(2);
        lst.addLast(3);
        for(int i: lst) {
            System.out.println(i);
        }
    }
    @Test
    public void LinkedListEqualityTest() {
        LinkedListDeque<Integer> list1 = new LinkedListDeque<>();
        LinkedListDeque<Integer> list2 = new LinkedListDeque<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        assertTrue(list1.equals(list2));
    }
}
