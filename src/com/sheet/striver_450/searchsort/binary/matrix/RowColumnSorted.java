package com.sheet.striver_450.searchsort.binary.matrix;

// https://leetcode.com/problems/search-a-2d-matrix/
// https://leetcode.com/problems/search-a-2d-matrix-ii/description/
public class RowColumnSorted {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int t = 1;

        System.out.println(searchMatrix(matrix, t));
    }

    static boolean searchMatrix(int[][] arr, int t) {

        int r = 0;
        int c = arr[0].length - 1;

        while((r >= 0 && r < arr.length) && (c >= 0 && c < arr[0].length)) {

            if (arr[r][c] == t) {
                return true;
            } else if(arr[r][c] > t) {
                c--;
            } else {
                r++;
            }
        }
        return false;
    }
}
