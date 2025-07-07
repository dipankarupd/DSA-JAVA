package com.sheet.striver_450.array.medium;

import java.util.Arrays;

// https://leetcode.com/problems/rearrange-array-elements-by-sign/description/
public class RearrangeBySign {
    public static void main(String[] args) {
        int[] arr = {3,1,-2,-5,2,-4};
        System.out.println(Arrays.toString(rearrangeArray(arr)));
    }

    static int[] rearrangeArray(int[] arr) {
        int i = 0;
        int j = 1;
        int k = 0;

        int n = arr.length;
        int[] res = new int[n];
        while(k<n) {

            if(arr[k] >= 0) {
                res[i] = arr[k];
                i += 2;
            } else {
                res[j] = arr[k];
                j += 2;
            }
            k++;
        }
        return res;
    }
}
