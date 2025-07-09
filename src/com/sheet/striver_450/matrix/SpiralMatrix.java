package com.sheet.striver_450.matrix;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2,3,4,5,6,7},
                {8,9,10,11,12,13,14},
                {15,16,17,18,19,20,21},
                {22,23,24,25,26,27,28},
                {29,30,31,32,33,34,35},
        };

        System.out.println(spiralOrder(arr));
    }

    static List<Integer> spiralOrder(int[][] arr) {

        int minRow = 0;
        int minCol = 0;
        int maxRow = arr.length-1;
        int maxCol  = arr[0].length-1;
        int total = arr.length * arr[0].length;
        int count = 0;

        List<Integer> res = new ArrayList<>();

        while(count < total) {

//            top:
            for (int r = minRow, c = minCol; c <= maxCol && count < total; c++) {
                res.add(arr[r][c]);
                count++;
            }
            minRow ++;

            for (int r = minRow, c = maxCol; r <= maxRow && count < total; r++) {
                res.add(arr[r][c]);
                count++;
            }
            maxCol --;
            for (int c = maxCol, r = maxRow ; c >= minCol && count < total; c--) {
                res.add(arr[r][c]);
                count++;
            }
            maxRow --;
            for (int r  = maxRow, c = minCol; r  >= minRow  && count < total; r --) {
                res.add(arr[r][c]);
                count++;
            }
            minCol++;
        }
        return res;
    }
}
