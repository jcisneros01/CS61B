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
        return computeIndex(index);
    }

    private int computeIndex(int index) {
        return (index + items.length) % items.length;
    }

    private int plusOne(int index) {
        index++;
        return computeIndex(index);
    }

    private void resize(int capacity) {
        if (capacity == 0) {
            throw new IllegalArgumentException("Zero is not a valid resize arg");
        }

        T[] newArray = (T[]) new Object[capacity];
        int newArrayIndex = 0;
        for (int i = 0; i < size; i++) {
            newArray[newArrayIndex] = get(i);
            newArrayIndex++;
        }
        items = newArray;
        nextFirst = newArray.length - 1;
        nextLast = size;
    }

    private void upSizeIfNeeded() {
        if (usageRatio() > .75) {
            resize(items.length * 2);
        }
    }

    private void downSizeIfNeeded() {
        if (usageRatio() < .25) {
            resize(items.length / 2);
        }
    }

    private double usageRatio() {
        return (double) size / items.length;
    }

    public void addFirst(T item) {
        upSizeIfNeeded();
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    public void addLast(T item) {
        upSizeIfNeeded();
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
        for (int i = 0; i < size; i++) {
            System.out.printf("%s ", get(i));
        }
    }

    private void printArray() {
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%s ", items[i]);
        }
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }

        var item = items[plusOne(nextFirst)];
        items[plusOne(nextFirst)] = null;
        nextFirst = plusOne(nextFirst);
        size--;

        downSizeIfNeeded();

        return item;
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }

        var item = items[minusOne(nextLast)];
        items[minusOne(nextLast)] = null;
        nextLast = minusOne(nextLast);
        size--;

        downSizeIfNeeded();

        return item;
    }

    public T get(int index) {
        return items[computeIndex(index + plusOne(nextFirst))];
    }
}
