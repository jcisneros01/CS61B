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

    public static void reverse(int[] array) {

        for (int i = 0; i < array.length / 2; i++) {
            int j = array.length - 1 - i;
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] array = {1,2,3};
        reverse(array);
        printArray(array);
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
