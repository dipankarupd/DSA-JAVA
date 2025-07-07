package com.old.dp;

import java.util.HashMap;

public class Fibonacci {

    // normal fibonacci
    static int fibonacci(int n) {
        if (n == 0 || n == 1) return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    // with dp(memorization)
    static int fibonacci2(int n) {
        return helper(n, new HashMap<>());
    }

    private static int helper(int n, HashMap<Integer, Integer> map) {
        if(n == 0 || n == 1) return n;

        if(map.containsKey(n)) return map.get(n);

        int ans = helper(n - 1, map) + helper(n - 2, map);
        map.put(n, ans);
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(fibonacci2(20));
    }
}
