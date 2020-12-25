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
        IntList A = IntList.list(1, 2, 2, 2, 3);
        IntList.removeDuplicates(A);
        A.printList();
    }

    private static void removeDuplicates(IntList p) {
        if (p == null) {
            return;
        }

        IntList current = p.rest;
        IntList previous = p;

        while(current != null){
            if (current.first == previous.first) {
                // bypass dup
                previous.rest = current.rest;
            } else {
                // adv prev ptr
                previous = current;
            }
            // adv current ptr
            current = current.rest;
        }
    }
}