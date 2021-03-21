package synthesizer;

import java.util.HashSet;

public class GuitarString {
    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private BoundedQueue<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {
        buffer = new ArrayRingBuffer<Double>((int) Math.round(SR / frequency));
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.enqueue(0.0);
        }
        buffer.printBuffer();
    }

    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {
        while (!buffer.isEmpty()) {
            buffer.dequeue();
        }

        HashSet<Double> uniqueRandomNumbers = new HashSet<Double>();
        while (!buffer.isFull()) {
            var randomNum = Math.random() - 0.5;
            if (!uniqueRandomNumbers.contains(randomNum)) {
                uniqueRandomNumbers.add(randomNum);
                buffer.enqueue(randomNum);
            }
        }
        buffer.printBuffer();
    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm. 
     */
    public void tic() {
        double frontSample = buffer.dequeue();
        double newSample = (frontSample + buffer.peek()) / 2 * DECAY;
        buffer.enqueue(newSample);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {
        return buffer.peek();
    }

    public static void main(String[] args) {
        var gs = new GuitarString(4410);
        gs.pluck();
    }

}
