import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListDequeTests {
    @Test
    public void IsSize_ListIsEmpty_ReturnsTrue() {
        var list = new LinkedListDeque<Integer>();

        assertTrue(list.isEmpty());
    }

    @Test
    public void IsSize_ListIsNotEmpty_ReturnsFalse() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void Size_EmptyList_ReturnsZero() {
        var list = new LinkedListDeque<Integer>();
        assertEquals(0, list.size());
    }

    @Test
    public void Size_HasOneValue_ReturnsOne() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(1);
        assertEquals(1, list.size());
    }


    @Test
    public void Get_AllConditions_ReturnsItem() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertEquals(8, (int) list.get(0));
        assertEquals(9, (int) list.get(1));
        assertEquals(10, (int) list.get(2));
    }

    @Test
    public void Get_BeyondIndex_ReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertNull(list.get(3));
    }

    @Test
    public void Get_EmptyList_ReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        assertEquals(null, list.get(0));
    }

    @Test
    public void AddFirst_EmptyList_AddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void AddFirst_AddMultipleItems_AddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertEquals(8, (int) list.get(0));
    }

    @Test
    public void RemoveFirst_EmptyList_ReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        assertNull(list.removeFirst());
    }

    @Test
    public void RemoveFirst_NonEmptyList_RemovesItems() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        int first = list.removeFirst();
        int second = list.removeFirst();
        int third = list.removeFirst();
        var fourth = list.removeFirst();
        assertEquals(8, first);
        assertEquals(9, second);
        assertEquals(10, third);
        assertNull(fourth);
        assertEquals(0, list.size());
    }

    @Test
    public void RemoveLast_NonEmptyList_RemovesItems() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        int first = list.removeLast();
        int second = list.removeLast();
        int third = list.removeLast();
        var fourth = list.removeLast();
        assertEquals(10, first);
        assertEquals(9, second);
        assertEquals(8, third);
        assertNull(fourth);
        assertEquals(0, list.size());
    }

    @Test
    public void AddLast_EmptyList_AddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addLast(10);
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void AddLast_AddMultipleItems_AddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.printDeque();
       assertEquals(3, (int) list.get(2));
    }
}
