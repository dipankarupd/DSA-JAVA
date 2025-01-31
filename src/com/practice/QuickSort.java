package com.practice;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,3,2,1};

        quicksort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quicksort(int[] arr, int l, int h) {

        // base case:
        if(l >= h) return;

        int s=l;
        int e=h;
        int m = s+(e-s)/2;
        int piv = arr[m];

        while(s<=e) {
            while(arr[s] < piv) {
                s++;
            }
            while(arr[e] > piv) {
                e--;
            }

            if(s<=e) {
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++;
                e--;
            }
        }

        quicksort(arr, l, e);
        quicksort(arr, s, h);
    }
}
