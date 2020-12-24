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
        int[] array = {3,2,1};
        var newArray = replicate(array);
        printArray(newArray);
    }

    public static int[] replicate(int[] arr) {
        int count = 0;
        for (int i: arr) {
            count += i;
        }
        int[] newArr = new int[count];

        int j = 0;
        for (int value : arr) {
            for (int counter = 1; counter <= value; counter++) {
                newArr[j] = value;
                j++;
            }
        }
        return newArr;
    }

    public static void printArray(int[] arr) {
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
