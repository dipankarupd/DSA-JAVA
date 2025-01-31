package com.practice;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 4, 3, 2, 1};

        int[] res = mergesort(arr);
        mergesort(arr,0,arr.length);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(res));
    }

    static int[] mergesort(int[] arr) {
        if(arr.length == 1) {
            return arr;
        }
        int m = arr.length / 2;
        int[] left = mergesort(Arrays.copyOfRange(arr, 0, m));
        int[] right = mergesort(Arrays.copyOfRange(arr, m, arr.length));

        return merge(left, right);
    }

    static void mergesort(int[] arr, int s, int e) {
        if (e-s == 1) {
            return;
        }

        int m = s+(e-s)/2;
        mergesort(arr,s,m);
        mergesort(arr,m,e);

        merge(arr,s,e,m);
    }

    private static int[] merge(int[] left, int[] right) {
        int[] res = new int[left.length + right.length];

        int i=0,j=0,k=0;
        while(i<left.length && j<right.length) {
            if(left[i]<right[j]) {
                res[k] = left[i];
                i++;
            } else {
                res[k] = right[j];
                j++;
            }
            k++;
        }

        while(i<left.length) {
            res[k] = left[i];
            i++;
            k++;
        }

        while(j<right.length) {
            res[k] = right[j];
            j++;
            k++;
        }

        return res;
    }

    private static void merge(int[] arr, int s, int e, int m) {
        int[] res = new int[e-s];
        int k = 0;
        int i=s,j=m;

        while(i<m && j<e) {
            if(arr[i]<arr[j]) {
                res[k] = arr[i];
                i++;
            } else {
                res[k] = arr[j];
                j++;
            }
            k++;
        }

        while(i<m) {
            res[k] = arr[i];
            i++;
            k++;
        }
        while(j<e) {
            res[k] = arr[j];
            k++;
            j++;
        }

        for (int l = 0; l < res.length; l++) {
            arr[s+l] = res[l];
        }

    }
}
