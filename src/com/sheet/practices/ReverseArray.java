package com.sheet.practices;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {

        int[] arr = {1,2,3,4,5};

       reverse(arr);
        System.out.println(Arrays.toString(arr));

    }

    static void reverse(int[] arr) {

        int s = 0;
        int e = arr.length - 1;

        while(s < e) {
            swap(arr, s,e);
            s ++;
            e--;
        }
    }

    static void swap(int[] arr, int s, int e) {
        arr[s] = arr[s] ^ arr[e];
        arr[e] = arr[s] ^ arr[e];
        arr[s] = arr[s] ^ arr[e];
    }
}
