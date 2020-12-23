package com.company;

public class SLList {
    public static class IntNode {
        public int item;

        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void print() {
        IntNode p = first;
        while (p != null) {
            System.out.println(p.item);
            p = p.next;
        }
    }

    public void insert(int item, int position) {
        if (position == 0 || first == null) {
            addFirst(item);
            return;
        }

        IntNode p = first;
        while (position > 1 && p.next != null) {
            p = p.next;
            position--;
        }
        IntNode newNode = new IntNode(item, p.next);
        p.next = newNode;
    }

    public static void main(String[] args) {
        SLList list = new SLList();
        list.addFirst(2);
        list.addFirst(6);
        list.addFirst(5);
        list.insert(10, 5);
        list.print();
    }
}