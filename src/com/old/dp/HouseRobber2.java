package com.old.dp;

import java.util.Arrays;
import java.util.HashMap;

import static com.old.dp.HouseRobber.help;

public class HouseRobber2 {

    public static int robs(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] left = Arrays.copyOfRange(nums, 0, nums.length-1);
        int[] right = Arrays.copyOfRange(nums, 1, nums.length);

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));

        int ansL = help(left, 0, new HashMap<>());
        int ans = help(right, 0, map);
        return Math.max(ansL, ans);
    }

    public static void main(String[] args) {
        System.out.println(robs(new int[]{1,2,3}));
    }
}
