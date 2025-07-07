package com.old.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResultSum {

    static boolean isSum(List<Integer> nums, int val) {

        if(val == 0) {
            return true;
        }

        if(val < 0) {
            return false;
        }

        for (int n: nums) {
            int x = val - n;
            if (isSum(nums, x)) {
                return true;
            }
        }
        return false;
    }

    // dp:
    static boolean isSum2(List<Integer> nums, int val) {
        return helper(nums, val, new HashMap<Integer, Boolean>());
    }

    private static boolean helper(List<Integer> nums, int val, Map<Integer, Boolean> map) {
        if(val == 0) {
            return true;
        }

        if(val < 0) {
            return false;
        }
        if (map.containsKey(val)) {
            return map.get(val);
        }
        for(int n: nums) {
            int x = val - n;
            if(helper(nums, x, map)) {
                map.put(val, true);
                return true;
            }
        }
        map.put(val, false);
        return false;
    }
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        System.out.println(isSum2(nums, 5));
    }
}
