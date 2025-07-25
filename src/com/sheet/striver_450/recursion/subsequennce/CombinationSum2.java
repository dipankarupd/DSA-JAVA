package com.sheet.striver_450.recursion.subsequennce;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://leetcode.com/problems/combination-sum-ii/description/
public class CombinationSum2 {

    public static void main(String[] args) {
        int[] arr = {10,1,2,7,6,1,5};
        int t = 8;

        List<List<Integer>> ans = combinationSum2(arr, t);

        for(List<Integer> x : ans) {
            System.out.println(ans);
        }
    }


    static List<List<Integer>> combinationSum2(int[] arr, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(arr);
        backtrack(arr, t, 0, ans, new ArrayList<Integer>());
        return ans;
    }

    private static void backtrack(int[] arr, int t, int idx, List<List<Integer>> ans,List<Integer> curr) {

        if (t == 0) {
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(t < 0) return;


        for(int i = idx; i<arr.length; i++) {

            if(i > idx && arr[i] == arr[i-1]) {
                continue;
            }
            if(arr[i] > t) break;
            curr.add(arr[i]);
            backtrack(arr, t-arr[i], i+1, ans, curr);
            curr.removeLast();

        }
    }
}
