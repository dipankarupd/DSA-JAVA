package com.sheet.striver_450.array.easy;

import java.util.Arrays;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        int k = 3;

        rotate(arr, k);

        System.out.println(Arrays.toString(arr));
    }

    public static void rotate(int[] arr, int k) {

        k = k % arr.length;
        int n = arr.length - 1;

//        left rotation
        reverse(arr, 0, k-1);
        reverse(arr, k, n);
        reverse(arr, 0, n);

        // for right:
//        a. rev entire b. rev to k c. rev remaining

    }

    static void reverse(int[] arr, int s, int e) {
        while(s<e) {
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }
    }
}
