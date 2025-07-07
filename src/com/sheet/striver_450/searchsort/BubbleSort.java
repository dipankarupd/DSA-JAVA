package com.sheet.striver_450.searchsort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {5,1,2,3,4};

//        bubbleSort(arr);

        bubbleSortRecursive(arr, arr.length-1, 0);

        System.out.println(Arrays.toString(arr));

    }


    static void bubbleSort(int[] arr) {
        int n = arr.length;

        for(int i=0; i<n-1; i++) {
            boolean flag = false;
            for(int j = 0; j<n-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                    flag = true;
                }
            }
            if (!flag) {
                return;
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
         arr[a] = arr[b];
          arr[b] = t;
    }

    static void bubbleSortRecursive(int[] arr, int r, int c) {

        if(r == 0) {
            return;
        }

        if(c < r) {
            if(arr[c] > arr[c+1]) {
                swap(arr, c, c+1);
            }
            bubbleSortRecursive(arr, r, c+1);
        } else {
            bubbleSortRecursive(arr, r-1, 0);
        }
    }
}
