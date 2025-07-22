package com.sheet.striver_450.recursion.subsequennce;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/subsets/description/
public class Subsets {

    public static void main(String[] args) {
        int[] arr = {1,2,3};

        List<List<Integer>> res = subsets(arr);

        for(List<Integer> x: res) {
            System.out.println(x);
        }
    }

    static List<List<Integer>> subsets(int[] arr) {

        List<Integer> ans = new ArrayList<>();
        return doWork(arr, ans, 0);
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
