package com.sheet.striver_450.array.easy;

import java.util.Arrays;

public class MoveZero {
    public static void main(String[] args) {
        int[] arr = {1,4,0,2,0,0,3};
        moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveZeroes(int[] arr) {
        int i = 0;

        for(int j = 1; j< arr.length; j++) {
            if(arr[i] != 0) {
                i++;
            } else {
                if(arr[j] == 0) {
                    continue;
                }
                else {
                    swap(arr, i, j);
                    i++;
                }
            }
        }
    }

    static void swap(int[] arr, int a, int b) {
        int t = arr[a];
        arr[a] = arr[b];
        arr[b] = t;
    }
}
