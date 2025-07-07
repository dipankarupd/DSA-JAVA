package com.sheet.practices;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/cyclically-rotate-an-array-by-one2614/1
public class RotateByOne {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        rotate(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void rotate(int[] arr) {
        int l = arr.length - 1;

        for(int i = 0; i< arr.length - 1; i++) {
            swap(arr, i, l);
        }
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
