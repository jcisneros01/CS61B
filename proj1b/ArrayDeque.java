public class ArrayDeque<T> implements Deque<T> {
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
        if (items.length >= 16 && usageRatio() < .25) {
            resize(items.length / 2);
        }
    }

    private double usageRatio() {
        return (double) size / items.length;
    }

    @Override
    public void addFirst(T item) {
        upSizeIfNeeded();
        items[nextFirst] = item;
        size++;
        nextFirst = minusOne(nextFirst);
    }

    @Override
    public void addLast(T item) {
        upSizeIfNeeded();
        items[nextLast] = item;
        size++;
        nextLast = plusOne(nextLast);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
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

    @Override
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

    @Override
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

    @Override
    public T get(int index) {
        return items[computeIndex(index + plusOne(nextFirst))];
    }
}
