import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListDequeTests {
    @Test
    public void isSizeListIsEmptyReturnsTrue() {
        var list = new LinkedListDeque<Integer>();

        assertTrue(list.isEmpty());
    }

    @Test
    public void isSizeListIsNotEmptyReturnsFalse() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void sizeEmptyListReturnsZero() {
        var list = new LinkedListDeque<Integer>();
        assertEquals(0, list.size());
    }

    @Test
    public void sizeHasOneValueReturnsOne() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(1);
        assertEquals(1, list.size());
    }

    @Test
    public void getAllConditionsReturnsItem() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertEquals(8, (int) list.get(0));
        assertEquals(9, (int) list.get(1));
        assertEquals(10, (int) list.get(2));
    }

    @Test
    public void getBeyondIndexReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertNull(list.get(3));
    }

    @Test
    public void getEmptyListReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        assertEquals(null, list.get(0));
    }

    @Test
    public void addFirstEmptyListAddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void addFirstAddMultipleItemsAddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertEquals(8, (int) list.get(0));
    }

    @Test
    public void removeFirstEmptyListReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        assertNull(list.removeFirst());
    }

    @Test
    public void removeFirstNonEmptyListRemovesItems() {
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
    public void removeLastNonEmptyListRemovesItems() {
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
    public void addLastEmptyListAddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addLast(10);
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void addLastAddMultipleItemsAddedItemToFront() {
        var list = new LinkedListDeque<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.printDeque();
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void getRecursiveAllConditionsReturnsItem() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertEquals(8, (int) list.getRecursive(0));
        assertEquals(9, (int) list.getRecursive(1));
        assertEquals(10, (int) list.getRecursive(2));
    }

    @Test
    public void getRecursiveBeyondIndexReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertNull(list.getRecursive(3));
    }

    @Test
    public void getRecursiveEmptyListReturnsNull() {
        var list = new LinkedListDeque<Integer>();
        assertEquals(null, list.getRecursive(0));
    }
}
