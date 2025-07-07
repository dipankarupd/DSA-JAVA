package com.sheet.practices;

import java.util.Arrays;

public class MoveNegative {
    public static void main(String[] args) {
        int[] arr = {3,-2,-1};
        System.out.println(Arrays.toString(moveLeft(arr)));
    }

    static int[] moveLeft(int[] arr) {
        int i = 0, j = 0;
        while(i< arr.length) {
            if(arr[i] < 0)
            {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        return arr;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
