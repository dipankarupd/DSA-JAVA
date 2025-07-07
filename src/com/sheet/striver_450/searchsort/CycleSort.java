package com.sheet.striver_450.searchsort;

import java.util.Arrays;

public class CycleSort {
    public static void main(String[] args) {
        int[] arr = {3,4,2,1,5};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr) {

        int i = 0;
        while (i < arr.length){

            int correctIdx = arr[i] - 1;

            if(arr[i] != arr[correctIdx]) {
                int t = arr[i];
                arr[i] = arr[correctIdx];
                arr[correctIdx] = t;
            }


            else {
                i++;
            }
        }
    }

}
