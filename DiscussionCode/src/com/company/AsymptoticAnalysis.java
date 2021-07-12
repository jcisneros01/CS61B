package com.company;

import java.util.*;

public class AsymptoticAnalysis {
    public static void main(String[] args) {
       var intersection = intersection(new int[]{1, 2, 3, 4}, new int[]{3, 4, 5, 6});
        System.out.println(Arrays.toString(intersection));
    }

    private static int[] intersection(int[] A, int[] B) {
        HashSet<Integer> numbers = new HashSet<Integer>();
        List<Integer> intersection = new ArrayList<Integer>();

        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
        }

        for (int j = 0; j < B.length; j++) {
            if (numbers.contains(B[j])) {
                intersection.add(B[j]);
            }
        }

        var intersectionArray = new int[intersection.size()];
        int k = 0;
        for (int intersectionNum: intersection) {
            intersectionArray[k] = intersectionNum;
            k++;
        }

        return intersectionArray;
    }

    public static boolean findSum(int[] A, int x) {
        HashMap<Integer, Integer> numbers = new HashMap<Integer, Integer>();

        for (int i = 0; i < A.length; i++) {
            var targetNumber = 5 - A[i];

            numbers.put(A[i], targetNumber);

            if (numbers.containsKey(targetNumber)) {
                System.out.println(numbers);
                return true;
            }
        }

        return false;
    }

    public static int[] union(int[] A, int[] B) {
        HashSet<Integer> numbers = new HashSet<Integer>();

        for (int i = 0; i < A.length; i++) {
            numbers.add(A[i]);
        }

        for (int j = 0; j < B.length; j++) {
            numbers.add(B[j]);
        }

        var union = new int[numbers.size()];
        int k = 0;
        for (int num: numbers) {
            union[k] = num;
            k++;
        }

       return union;
    }
}
