package com.company;

public class ArrayProblems {
    public static int[] insert(int[] arr, int item, int position) {
        // create new array
        int[] newArr = new int[arr.length + 1];
        // validate position
        if (position > arr.length - 1) {
            position = newArr.length - 1;
        }
        // insert new item
        newArr[position] = item;

        // copy old array values
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // skip insertion position
            if (i == position) {
                index++;
            }

            newArr[index] = arr[i];
            index++;
        }

        return newArr;
    }

    public static void main(String[] args) {
        int[] array = {5, 9, 14, 15};
        //printArray(array);
        var newArr = insert(array, 6, 9);
        printArray(newArr);
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
