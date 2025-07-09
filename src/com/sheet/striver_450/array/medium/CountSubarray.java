package com.sheet.striver_450.array.medium;

import java.util.HashMap;
import java.util.*;

// https://leetcode.com/problems/subarray-sum-equals-k/description/
public class CountSubarray {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(subarraySum(arr, 3));
    }

    static int subarraySum(int[] arr, int k) {

        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        map.put(0, 1);

        for(int x: arr) {
            sum += x;
            int remainingSum = sum - k;

            if (map.containsKey(remainingSum)) {
                count += map.get(remainingSum);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
