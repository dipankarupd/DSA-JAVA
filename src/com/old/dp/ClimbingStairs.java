package com.old.dp;

import java.util.HashMap;

public class ClimbingStairs {
    public static int climbStairs(int n) {
        return helper(n, new HashMap<Integer, Integer>());
    }

    static int helper(int n, HashMap<Integer, Integer> map) {

        if(n == 0) {
            return 1;
        }
        if(n < 0){
            return 0;
        }

        if(map.containsKey(n)) {
            return map.get(n);
        }

        int ans1 = helper(n-1, map);
        int ans2 = helper(n-2, map);
        int ans = ans1 + ans2;

        map.put(n, ans);
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
