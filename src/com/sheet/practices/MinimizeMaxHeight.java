package com.sheet.practices;

import java.util.Arrays;

// https://www.geeksforgeeks.org/problems/minimize-the-heights3351/1
public class MinimizeMaxHeight {
    public static void main(String[] args) {
        int[] arr = {1,8,10,6,4,9,1};
        int k =7;
        System.out.println(getMinDiff(arr, k));
    }

    static int getMinDiff(int[] arr, int k) {

        Arrays.sort(arr);
        // code here
        int s = arr[0] + k;
        int l = arr[arr.length - 1] - k;

        int res = (arr[arr.length - 1] - arr[0]);

        for (int i = 0; i < arr.length - 1; i++) {
            s = Math.min(s, arr[i+1] - k);
            l = Math.max(l, arr[i] + k);

            if(s < 0) continue;
            res = Math.min(res, l-s);
        }

        return res;
    }
}
