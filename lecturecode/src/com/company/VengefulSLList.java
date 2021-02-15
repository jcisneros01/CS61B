package com.company;

public class VengefulSLList<T> extends LinkedListDeque<T> {
    private LinkedListDeque<T> deletedItems;

    public VengefulSLList() {
        deletedItems = new LinkedListDeque<T>();
    }

    @Override
    public T removeLast() {
        T x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public void printLostItems() {
        deletedItems.printDeque();
    }

    public static void main(String[] args) {
        VengefulSLList<Integer> vs1 = new VengefulSLList<>();
        LinkedListDeque<Integer> sl = vs1;
        sl.addFirst(1);
        sl.removeLast();

        vs1.addLast(1);
        vs1.addLast(5);
        vs1.addLast(10);
        vs1.addLast(13);

        vs1.removeLast();
        vs1.removeLast();
        System.out.print("The fallen are: ");
        vs1.printLostItems();
    }
}
