public class LinkedListDeque<T> {
    private class Node {
        public T item;
        public Node prev;
        public Node next;

        public Node(T item) {
            this.item = item;
        }

        public Node(Node prev, Node Next, T item) {
            this.prev = prev;
            next = Next;
            this.item = item;
        }
    }

    private final Node sentinel;

    private int size;

    public LinkedListDeque() {
        sentinel = new Node(null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        Node node;
        if (size == 0) {
            node = new Node(sentinel, sentinel, item);
            sentinel.next = node;
            sentinel.prev = node;
        } else {    
            node = new Node(sentinel, sentinel.next, item);
            sentinel.next.prev = node;
            sentinel.next = node;
        }
        
        size++;
    }

    public void printDeque() {
        Node p = sentinel.next;
        int count = size;
        while (count > 0) {
            System.out.printf("%s ", p.item);
            p = p.next;
            count--;
        }
    }

   public void addLast(T item) {
        if (isEmpty()) {
            addFirst(item);
            return;
        }
        Node last = sentinel.prev;
        Node newLast = new Node(last, sentinel, item);
        last.next = newLast;
        sentinel.prev = newLast;
        size++;
   }

    public int size() {

        return size;
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }

        Node node = sentinel.next;
        sentinel.next = node.next;
        size--;
        return node.item;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T get(int index){
        if (index > size - 1) {
            return null;
        }

        Node p = sentinel.next;
        int count = index;
        while (count > 0) {
            p = p.next;
            count--;
        }

        return p.item;
    }

    public T getRecursive(int index) {
        if (index > size - 1) {
            return null;
        }

        Node p = sentinel.next;
        return getNode(index, p);
    }

    public T getNode(int index, Node p) {
        if (index == 0) {
            return p.item;
        }

        return getNode(index -1, p.next);
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }

        Node last = sentinel.prev;
        Node newLast = last.prev;
        newLast.next = sentinel;
        sentinel.prev = newLast;
        size--;

        return last.item;
    }

    public static void main(String[] args) {
        LinkedListDeque<Integer> L = new LinkedListDeque<>();
        L.addFirst(10);
        L.addFirst(9);
        L.addFirst(8);
        L.printDeque();
    }
}
