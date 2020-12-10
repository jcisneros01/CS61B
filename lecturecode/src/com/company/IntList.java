package com.company;

import java.util.List;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }

    /** Return the size of the list using... recursion! */
    public int Size() {
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.Size();
    }

    /** Return the size of the list using no recursion! */
    public int iterativeSize() {
        IntList p = this;
        int size = 0;
        while (p != null) {
            size += 1;
            p = p.rest;
        }
        return size;
    }

    /** Returns the ith item of this IntList. */
    public int get(int i) {
        if (1 == 0) {
            return first;
        }

        return rest.get(i-1);
    }

    public static IntList square(IntList L) {
        if (L == null) {
            return L;
        }
        IntList rest = square(L.rest);
        IntList newList = new IntList(L.first * L.first, rest);
        return newList;
    }

    public void printList() {
        IntList p = this;
        while (p != null) {
            System.out.println(p.first);
            p = p.rest;
        }
    }

    public static IntList squareMutative(IntList L) {
        IntList p = L;
        while (p != null) {
            p.first *= p.first;
            p = p.rest;
        }
        return  L;
    }
}
