package com.sheet.striver_450.matrix;

import java.util.Arrays;

// https://leetcode.com/problems/set-matrix-zeroes/description/

public class SetZero {
    public static void main(String[] args) {
        int[][] arr = {
                {0,1,2,0},
                {3,4,1,2},
                {1,4,2,1}
        };

        setZeroes(arr);
        for(int i=0; i<arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }

    static void setZeroes(int[][] arr) {

//        have 2 variables for checking if the first row and first col has 0;
        boolean isFirstRowZero = false;
        boolean isFirstColumnZero = false;

//        check if first row and first col has 0:
        for (int row = 0; row < arr.length; row++) {
            if(arr[row][0] == 0) {
                isFirstRowZero = true;
            }
        }

        for(int col = 0; col < arr[0].length; col++) {
            if(arr[0][col] == 0) {
                isFirstColumnZero = true;
            }
        }

//        now for remaining elements, if arr[r][c] = 0, make arr[r][c] and arr[0][c] 0
        for (int row = 1; row < arr.length; row++) {
            for (int col = 1; col < arr[row].length; col++) {
                if(arr[row][col] == 0) {
                    arr[row][0] = 0;
                    arr[0][col] = 0;
                }
            }

        }

//        now check in the whole doc, if that row and that col has the zero element:

        for(int row = 1; row < arr.length; row++) {
            if(arr[row][0] == 0) {
                for(int col = 1; col < arr[row].length; col++) {
                    arr[row][col] = 0;
                }
            }
        }

        for(int col = 1; col < arr[0].length; col++) {
            if(arr[0][col] == 0) {
                for(int row = 1; row < arr.length; row++) {
                    arr[row][col] = 0;
                }
            }
        }

        if(isFirstRowZero) {
            for(int row = 0; row < arr.length; row++) {
                arr[row][0] = 0;
            }
        }

        if(isFirstColumnZero) {
            for(int col = 0; col < arr[0].length; col++) {
                arr[0][col] = 0;
            }
        }
    }
}
