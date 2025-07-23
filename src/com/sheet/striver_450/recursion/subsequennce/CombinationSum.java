package com.sheet.striver_450.recursion.subsequennce;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/combination-sum/description/
public class CombinationSum {

    public static void main(String[] args) {
        List<List<Integer>> ans = combinationSum(new int[] {2,3,6,7}, 7);

        for (List<Integer> x: ans) {
            System.out.println(x);
        }
    }

    private static List<List<Integer>> combinationSum(int[] arr, int t) {

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        doWork(arr, 0, t, res, ans);

        return ans;
    }

    private static void doWork(int[] arr, int idx, int t, List<Integer> res, List<List<Integer>> ans ) {

        if (idx == arr.length) {

            if (t == 0) {
                ans.add(new ArrayList<>(res));
            }
            return;
        }


        if (arr[idx] <= t) {
            res.add(arr[idx]);
            doWork(arr, idx, t-arr[idx], res, ans);
            res.removeLast();
        }

        doWork(arr, idx+1, t, res, ans);
    }
}
