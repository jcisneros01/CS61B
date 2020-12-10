package com.company;

public class Main {

    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);

        L.printList();
        IntList squared = IntList.squareMutative(L);
        squared.printList();
        L.printList();
    }
}
