package com.sheet.practices;

public class DuplicateNumber {
    public static void main(String[] args) {
        int[] arr = {1,3,5,2,2};
        System.out.println(duplicate(arr));
    }

    static int duplicate(int[] arr) {

        // cyclic sort
        sort(arr);

        // loop
        // 1 2 3 4 4
        for(int i = 0; i<arr.length; i++) {
            if(arr[i] != i+1) {
                return arr[i];
            }
        }
        return -1;
    }

    static void sort(int arr[]) {

        int i = 0;
        while (i < arr.length) {
            int ci = arr[i] - 1;
            if(arr[i] != arr[ci]) {
                int t = arr[i];
                arr[i] = arr[ci];
                arr[ci] = t;
            } else i++;
        }
    }
}
