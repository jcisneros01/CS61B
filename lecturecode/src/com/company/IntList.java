package com.company;

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
}
