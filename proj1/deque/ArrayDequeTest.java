package deque;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class ArrayDequeTest {
    @Test
    public void AddFirstCorrectly() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        aLst.addFirst(3);
        aLst.addFirst(2);
        aLst.addFirst(1);
        /*aLst.printDeque();*/
        assertEquals(3,aLst.size());
    }
    @Test
    public void AddLastCorrectly() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        aLst.addLast(1);
        aLst.addLast(2);
        aLst.addLast(3);
        /*aLst.printDeque();*/
        assertEquals(3,aLst.size());
    }
    @Test
    public void AddTest1() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        aLst.addLast(1);
        aLst.addLast(2);
        aLst.addLast(3);
        aLst.addFirst(4);
        aLst.addFirst(5);
        aLst.addFirst(6);
        aLst.addFirst(7);
        aLst.addFirst(8);
        assertEquals(8,aLst.size());
    }
    @Test
    public void AddTest2() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        aLst.addLast(1);
        aLst.addLast(2);
        aLst.addLast(3);
        aLst.addLast(4);
        aLst.addLast(5);
        aLst.addLast(6);
        aLst.addLast(7);
        aLst.addLast(8);
        assertEquals(8,aLst.size());
    }
    @Test
    public void ResizesCorrectly(){
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        for(int i = 0; i< 250; i++) {
            aLst.addLast(i);
        }
        for (int j = 1; j <= 250;j++) {
            aLst.addFirst(-j);
        }
        assertEquals(500,aLst.size());
        /*aLst.printDeque();*/
    }
    @Test
    public void RemoveLastTest() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        for(int i = 0; i< 250; i++) {
            aLst.addLast(i);
        }
        for (int j = 1; j <= 250;j++) {
            aLst.addFirst(-j);
        }
        for (int k = 1; k <= 250;k++) {
            aLst.removeLast();
        }
        System.out.println();
    }
    @Test
    public void RemoveFirstTest() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        for(int i = 0; i< 250; i++) {
            aLst.addLast(i);
        }
        for (int j = 1; j <= 250;j++) {
            aLst.addFirst(-j);
        }
        for (int k = 1; k <= 250;k++) {
            aLst.removeFirst();
        }
    }
    @Test
    public void GetTest() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        for(int i = 0; i< 250; i++) {
            aLst.addLast(i);
        }
        for (int j = 1; j <= 250;j++) {
            aLst.addFirst(-j);
        }
        int i = aLst.get(0);
        int j = aLst.get(250);
        int k = aLst.get(499);
        assertEquals(-250, i);
        assertEquals(0,j);
        assertEquals(249,k);
        assertEquals(500, aLst.size());
    }
    @Test
    public void EmptyTest() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        assertTrue(aLst.isEmpty());
        ArrayDeque<Integer> aLst2 = new ArrayDeque<>();
        aLst2.addFirst(3);
        assertFalse(aLst2.isEmpty());
    }
    @Test
    public void PrintTest() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        for(int i = 0; i< 250; i++) {
            aLst.addLast(i);
        }
        for (int j = 1; j <= 250;j++) {
            aLst.addFirst(-j);
        }
        aLst.printDeque();
    }
    @Test
    public void RandomTest() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        int operationNumber;
        int negativeNumber = -1;
        int positiveNumber = 0;
        for (int i = 0; i < 5000; i++) {
          operationNumber = (int) ( Math.random() * 2 + 1);
          if (operationNumber == 1) {
            aLst.addFirst(negativeNumber);
            negativeNumber--;
          } else if (operationNumber == 2) {
            aLst.addLast(positiveNumber);
            positiveNumber++;
          }
        }
        assertEquals(5000,aLst.size());
        aLst.printDeque();
    }
    @Test
    public void IterationTest() {
        ArrayDeque<Integer> aLst = new ArrayDeque<>();
        aLst.addLast(1);
        aLst.addLast(2);
        aLst.addLast(3);
        for (int i: aLst) {
            System.out.println(i);
        }
    }
    @Test
    public void EqualityTest1() {
        ArrayDeque<Integer> list1 = new ArrayDeque<>();
        ArrayDeque<Integer> list2 = new ArrayDeque<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list2.addLast(1);
        list2.addLast(2);
        list2.addLast(3);
        assertTrue(list1.equals(list2));
    }
    @Test
    public void EqualityTest2() {
        ArrayDeque<Integer> list1 = new ArrayDeque<>();
        ArrayDeque<String> list2 = new ArrayDeque<>();
        list1.addLast(1);
        list1.addLast(2);
        list1.addLast(3);
        list2.addLast("Bob");
        list2.addLast("Alice");
        list2.addLast("Charlie");
        assertFalse(list1.equals(list2));
    }
}

