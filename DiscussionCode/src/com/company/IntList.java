package com.company;
import java.util.*;

public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;

    }

    public static IntList list(Integer... args) {
        IntList result, p;

        if (args.length > 0) {
            result = new IntList(args[0], null);
        } else {
            return null;
        }

        int k;
        for (k = 1, p = result; k < args.length; k += 1, p = p.rest) {
            p.rest = new IntList(args[k], null);
        }
        return result;
    }

    public void printList() {
        IntList p = this;
        while (p != null) {
            System.out.println(p.first);
            p = p.rest;
        }
    }

    public void skippify() {
        IntList p = this;
        int n = 1;
        while (p != null) {

            IntList next = p.rest;

            // skip n nodes
            for (int i = 0; i < n; i++) {

                if (next != null) {
                    next = next.rest;
                }
            }

            // set connect current node to next node
            p.rest = next;

            // set p to next node
            p = next;

            // increment counter
            n++;
        }
    }

    public static void main(String[] args) {
        IntList A = IntList.list(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        A.skippify();
        A.printList();
        System.out.println("---");
        IntList B = IntList.list(9, 8, 7, 6, 5, 4, 3, 2, 1);
        B.skippify();
        B.printList();
    }
}