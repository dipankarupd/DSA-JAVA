package com.sheet.striver_450.array.easy;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {0,4,3,1};
        System.out.println(missingNumber(arr));
    }

    static int missingNumber(int[] arr) {

        int i = 0;

        while (i < arr.length) {

            if(arr[i] == arr.length) i++;
            int corr = arr[i];

            if( arr[i] != arr[corr]) {
                swap(arr, i, corr);
            } else {
                i++;
            }
        }

        for( i = 0; i<arr.length; i++) {
            if(arr[i] == arr.length) {
                return i;
            }
        }
        return arr.length;
    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
