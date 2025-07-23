package com.sheet.striver_450.recursion.subsequennce;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1,2,2};

        List<List<Integer>> res = subsets(arr);

        for(List<Integer> x: res) {
            System.out.println(x);
        }
    }

    static List<List<Integer>> subsets(int[] arr) {

//        List<Integer> ans = new ArrayList<>();
//        return doWork(arr, ans, 0);

        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> levelAns = new ArrayList<>();

        doWork(arr, ans, levelAns, 0);

        return ans;
    }

    private static void doWork(int[] arr, List<List<Integer>> ans, List<Integer> levelAns, int idx) {

        if (idx == arr.length) {
            ans.add(new ArrayList<>(levelAns));
            return;
        }

        doWork(arr, ans, levelAns, idx+1);
        levelAns.add(arr[idx]);
        doWork(arr, ans, levelAns, idx+1);
        levelAns.removeLast();
    }

    static List<List<Integer>> doWork(int[] arr, List<Integer> ans, int idx) {


        if (idx == arr.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>(ans));
            return res;
        }

        List<List<Integer>> notTaken = doWork(arr, new ArrayList<>(ans), idx+1);
        ans.add(arr[idx]);
        List<List<Integer>> taken = doWork(arr, new ArrayList<>(ans), idx+1);


        notTaken.addAll(taken);
        return notTaken;

    }

}
