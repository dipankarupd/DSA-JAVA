package com.sheet.striver_450.searchsort.binary.array;

public class InsertPosition {
    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        System.out.println(insertPosition(arr, 5));
    }

    static int insertPosition(int[] arr, int t) {
        int s = 0;
        int e = arr.length - 1;

        while (s <= e) {
            int m = s+(e-s)/2;

            if(arr[m] < t) {
                s = m+1;
            } else {
                e = m-1;
            }
        }

        return s;
    }
}
