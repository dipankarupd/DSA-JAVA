package com.sheet.striver_450.array.easy;

import java.util.ArrayList;
import java.util.List;

public class AllMissingNumbers {
    public static void main(String[] args) {
        int[] arr = {4,0,0,2};
        System.out.println(allMissing(arr));
    }

    static List<Integer> allMissing(int[] arr) {

        // cyclic sort:
        cyclicSort(arr);

        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i< arr.length; i++) {
            if (arr[i] != i) {
                ans.add(i);
            }
        }
        return ans;
    }

    static void cyclicSort(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            int ci = arr[i];

            if(arr[i] < arr.length && arr[i] != arr[ci]) {
                int t = arr[i];
                arr[i] = arr[ci];
                arr[ci] = t;
            }
            else {
                i++;
            }
        }
    }
}
