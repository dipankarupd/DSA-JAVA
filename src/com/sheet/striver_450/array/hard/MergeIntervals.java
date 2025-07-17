package com.sheet.striver_450.array.hard;


import java.util.ArrayList;
import java.util.Arrays;

// https://leetcode.com/problems/merge-intervals/
public class MergeIntervals {
    public static void main(String[] args) {
        int[][] arr = {
                {1,3}, {2,6}, {8,10}, {15,18}
        };

        int[][] ans = merge(arr);

        for(int[] x: ans) {
            System.out.println(Arrays.toString(x));
        }
    }


    static int[][] merge(int[][] arr) {

//        sort the array based on their first index:
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        res.add(arr[0]);


        for(int i=1; i<arr.length; i++) {

            int[] lastResult = res.getLast();

            int[] current = arr[i];

            if(current[0] <= lastResult[1]) {
                lastResult[1] = Math.max(current[1], lastResult[1]);
            } else {
                res.add(current);
            }
        }

        return res.toArray(new int[res.size()][]);

    }


}
