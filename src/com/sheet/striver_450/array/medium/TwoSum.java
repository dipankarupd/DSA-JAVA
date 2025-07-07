package com.sheet.striver_450.array.medium;

import java.util.Arrays;
import java.util.HashMap;

// https://leetcode.com/problems/two-sum/
public class TwoSum {

    public static void main(String[] args) {
        int[] arr = {3,2,4};
        int target = 5;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }


    static int[] twoSum(int[] arr, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<arr.length; i++) {
            if(map.containsKey(arr[i])) {
                return new int[] {map.get(arr[i]), i};
            }
            map.put(target-arr[i], i);
        }
        return new int[] {-1,-1};
    }
}
