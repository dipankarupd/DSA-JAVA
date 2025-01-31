package com.dp;

import java.util.HashMap;

public class HouseRobber {


    public  static int rob(int[] nums) {
        return help(nums, 0, new HashMap<>());
    }

    // tabulation:
    public static int rob2(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

     static int help(int[] arr, int index, HashMap<Integer, Integer> map) {
        // base condition:
        if(index >= arr.length) {
            return 0;
        }
        if(map.containsKey(index)) {
            return map.get(index);
        }
        // rob the first house, skip second house and find the maximum you can rob from other houses
        int robFirst = arr[index] + help(arr, index+2, map);

        // skip first house, and find the maximum you can rob from remaining house
        int robSecond = help(arr, index+1,map);

        map.put(index, Math.max(robFirst, robSecond));
        return Math.max(robFirst, robSecond);
    }

    public static void main(String[] args) {
        System.out.println(rob2(new int[]{1,2,3,1}));
    }
}
