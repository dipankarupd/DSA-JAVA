package com.old.dp;

import java.util.HashMap;

public class MinCostClimbingStairs {
    public static int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;
        dp[n -1 ] = cost[n-1];

        for(int i = cost.length - 2; i >= 0; i--) {
            dp[i] = Math.min(dp[i + 1], dp[i + 2]) + cost[i];
        }
        return Math.min(dp[0], dp[1]);
    }


    public static int minCostClimbingStairs2(int[] cost) {

        HashMap<Integer, Integer> map = new HashMap<>();
        return Math.min(helper(cost, map, 0) , helper(cost, map, 1));
    }

    private static int helper(int[] cost, HashMap<Integer, Integer> map, int n) {
        if(n >= cost.length) {
            return 0;
        }
        if(map.containsKey(n)) {
            return map.get(n);
        }

        int ans = cost[n] + Math.min(helper(cost, map, n + 1), helper(cost, map, n +2));
        map.put(n, ans);
        return ans;
    }


    public static void main(String[] args) {
        System.out.println(minCostClimbingStairs2(new int[]{10,15,20}));
    }
}
