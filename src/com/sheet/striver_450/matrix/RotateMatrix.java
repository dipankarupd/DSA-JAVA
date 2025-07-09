package com.sheet.striver_450.matrix;


import java.util.Arrays;

// https://leetcode.com/problems/rotate-image/
public class RotateMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3},
                {4,5,6},
                {7,8,9}

        };

        rotate(arr);
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static void rotate(int[][] arr) {

//        transpose the matrix:
        transpose(arr);


//        reverse each row of the matrix:
        for(int[] x: arr) {
            reverse(x);
        }
    }

    static void transpose(int[][] arr) {

        for (int r = 0; r < arr.length; r++) {
            for (int c = r+1; c < arr[r].length; c++) {
                int t = arr[r][c];
                arr[r][c] = arr[c][r];
                arr[c][r] = t;
            }
        }
    }

    static void reverse(int[] arr) {
        int s = 0;
        int e = arr.length - 1;

        while (s < e) {
            int t = arr[s];
            arr[s] = arr[e];
            arr[e] = t;
            s++;
            e--;
        }
    }
}
