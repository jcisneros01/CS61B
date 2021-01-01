public class ArrayDeque<T> {
    private T[] items;

    private int nextFirst;

    private int nextLast;

    private int size;

    public ArrayDeque() {
        items =  (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
    }

    private int minusOne(int index) {
        index--;
        return (index + items.length) % items.length;
    }

    private int plusOne(int index) {
        index++;
        return (index + items.length) % items.length;
    }

    public void addFirst(T item) {
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        items[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < size ; i++) {
            System.out.printf("%s ", get(i));
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        var item = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst); // move up pointer
        size--;

        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        var item = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast); // move pointer down
        size--;

        return item;
    }

    public T get(int index) {
        var firstIndex = plusOne(nextFirst);
        index = index + firstIndex;
        index = (index + items.length) % items.length;
        return items[index];
    }

    public static void main(String[] args)
    {
        var deq = new ArrayDeque<Character>();
        deq.addLast('a');
        deq.addLast('b');
        deq.addFirst('c');
        deq.addLast('d');
        deq.addLast('e');
        deq.addFirst('f');
        deq.printDeque();
    }
}
