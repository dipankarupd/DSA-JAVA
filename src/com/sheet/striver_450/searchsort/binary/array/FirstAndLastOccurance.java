package com.sheet.striver_450.searchsort.binary.array;

import java.util.Arrays;

public class FirstAndLastOccurance {
    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,4,5,5};
        System.out.println(Arrays.toString(searchRange(arr, 4)));
    }

    static int[] searchRange(int[] arr, int t) {
        int[] res = {-1,-1};
        res[0] = search(arr, t, true);
        res[1] = search(arr, t, false);
        return res;
    }

    static int search(int[] arr, int t, boolean isFirst) {
        int s = 0;
        int e = arr.length - 1;
        int ans = -1;
        while(s<=e) {
            int m = s+(e-s)/2;

            if(arr[m] < t) {
                s = m+1;
            } else if(arr[m] > t) {
                e = m-1;
            } else {
                if(isFirst) {
                    ans = m;
                    e=m-1;
                } else {
                    ans = m;
                    s = m+1;
                }
            }

        }
        return ans;
    }
}
