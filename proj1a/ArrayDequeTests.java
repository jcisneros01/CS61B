import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayDequeTests {
    @Test
    public void isSizeListIsEmptyReturnsTrue() {
        var list = new ArrayDeque<Integer>();

        assertTrue(list.isEmpty());
    }

    @Test
    public void isSizeListIsNotEmptyReturnsFalse() {
        var list = new ArrayDeque<Integer>();
        list.addFirst(1);
        assertFalse(list.isEmpty());
    }

    @Test
    public void sizeEmptyListReturnsZero() {
        var list = new ArrayDeque<Integer>();
        assertEquals(0, list.size());
    }

    @Test
    public void sizeHasOneValueReturnsOne() {
        var list = new ArrayDeque<Integer>();
        list.addFirst(1);
        assertEquals(1, list.size());
    }

    @Test
    public void getAllConditionsReturnsItem() {
        var list = new ArrayDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertEquals(8, (int) list.get(0));
        assertEquals(9, (int) list.get(1));
        assertEquals(10, (int) list.get(2));
    }

    @Test
    public void getBeyondIndexReturnsNull() {
        var list = new ArrayDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertNull(list.get(3));
    }

    @Test
    public void getEmptyListReturnsNull() {
        var list = new ArrayDeque<Integer>();
        assertEquals(null, list.get(0));
    }

    @Test
    public void addFirstEmptyListAddedItemToFront() {
        var list = new ArrayDeque<Integer>();
        list.addFirst(10);
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void addFirstAddMultipleItemsAddedItemToFront() {
        var list = new ArrayDeque<Integer>();
        list.addFirst(10);
        list.addFirst(9);
        list.addFirst(8);
        assertEquals(8, (int) list.get(0));
    }

    @Test
    public void removeFirstEmptyListReturnsNull() {
        var list = new ArrayDeque<Integer>();
        assertNull(list.removeFirst());
    }

    @Test
    public void removeFirstNonEmptyListRemovesItems() {
        var list = new ArrayDeque<Integer>();
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
        var list = new ArrayDeque<Integer>();
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
        var list = new ArrayDeque<Integer>();
        list.addLast(10);
        assertEquals(10, (int) list.get(0));
    }

    @Test
    public void addLastAddMultipleItemsAddedItemToFront() {
        var list = new ArrayDeque<Integer>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.printDeque();
        assertEquals(3, (int) list.get(2));
    }

    @Test
    public void testResizing() {
        var deq = new ArrayDeque<Character>();
        deq.addLast('a');
        deq.addLast('b');
        deq.addFirst('c');
        deq.addLast('d');
        deq.addLast('e');
        deq.addFirst('f');
        deq.addLast('g');
        deq.addLast('h');
        for (int i = 1; i <= 5 ; i++) {
            deq.removeLast();
        }
        deq.printArray();
    }
}
