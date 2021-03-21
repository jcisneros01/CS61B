package synthesizer;

import java.util.Iterator;

public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T>  {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        rb = (T[]) new Object[capacity];
        first = 2;
        last = 2;
        fillCount = 0;
        this.capacity = capacity;
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }

        rb[last] = x;
        fillCount++;
        last++;

        // wrap around
        if (last == capacity) {
            last = 0;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }

        var item = rb[first];
        rb[first] = null;
        fillCount--;
        first++;

        // wrap around
        if (first == capacity) {
            first = 0;
        }

        return item;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
         return rb[first];
    }

    public void printBuffer() {
        for (var i:rb) {
            System.out.print(i + " ");
        }
        System.out.println("\nFirst: " + first);
        System.out.println("Last: " + last);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    public class ArrayRingBufferIterator implements Iterator<T> {
        private int count;
        private int index;

        public ArrayRingBufferIterator() {
            count = 0;
            index = first;
        }

        @Override
        public boolean hasNext() {
            return count < fillCount;
        }

        @Override
        public T next() {
            var next = rb[count];

            count++;
            index++;

            if (index == capacity) {
                first = 0;
            }

            return next;
        }
    }
}
