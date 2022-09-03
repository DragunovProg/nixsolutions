package ua.dragunov.linkedlist;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class ForwardLinkedListTest {
    ForwardLinkedList<Integer> forwardLinkedList;

    @Before
    public void setUp() throws Exception {
        forwardLinkedList = new ForwardLinkedList<>();
    }

    @After
    public void tearDown() throws Exception {
        forwardLinkedList = null;
    }

    @Test
    public void IsNotNullIterator() {
        assertNotEquals(null, forwardLinkedList.iterator());
    }

    @Test
    public void AfterAddSizeIsFive() {
        forwardLinkedList.add(12);
        forwardLinkedList.add(0);
        forwardLinkedList.add(9);
        forwardLinkedList.addLast(121);
        forwardLinkedList.addFirst(1000);

        assertEquals(5, forwardLinkedList.size());
    }

    @Test
    public void AfterRemoveSizeIsThree() {
        forwardLinkedList.add(12);
        forwardLinkedList.add(0);
        forwardLinkedList.add(9);
        forwardLinkedList.addLast(121);
        forwardLinkedList.addFirst(1000);

        forwardLinkedList.remove(3);
        forwardLinkedList.remove(Integer.valueOf(121));

        assertEquals(3, forwardLinkedList.size());
    }

    @Test
    public void afterRemoveFirstElementIsZeroAndLastElementIsNine() {
        forwardLinkedList.add(12);
        forwardLinkedList.add(0);
        forwardLinkedList.add(9);
        forwardLinkedList.addLast(121);
        forwardLinkedList.addFirst(1000);

        forwardLinkedList.removeFirst();
        forwardLinkedList.removeFirst();
        forwardLinkedList.remove(Integer.valueOf(121));

        assertEquals(0, forwardLinkedList.getFirst().intValue());
        assertEquals(9, forwardLinkedList.getLast().intValue());
    }
}