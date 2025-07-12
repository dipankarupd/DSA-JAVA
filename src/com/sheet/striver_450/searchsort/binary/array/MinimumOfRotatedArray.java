package com.sheet.striver_450.searchsort.binary.array;

public class MinimumOfRotatedArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println(findMin(arr));
    }

    static int findMin(int[] arr) {


        int s = 0;
        int e = arr.length - 1;

//        find the minimum index:

        while(s < e) {
            int m = s + (e-s)/2;

            if(arr[m] < arr[e]) {
                e = m;
            } else {
                s = m+1;
            }
        }
        return s;

    }
}
