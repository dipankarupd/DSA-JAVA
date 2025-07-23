package com.sheet.striver_450.recursion.subsequennce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/subsets-ii/description/
public class Subset2 {
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
        HashSet<List<Integer>> set = new HashSet<>();

//        Arrays.sort(arr);
        doWork(arr, ans, levelAns, 0, set);

        return ans;
    }
    private static void doWork(int[] arr, List<List<Integer>> ans, List<Integer> levelAns, int idx, HashSet<List<Integer>> set) {

        if (idx == arr.length) {
            ArrayList<Integer> res = new ArrayList<>(levelAns);
            if(!set.contains(res)) {

                ans.add(res);
                set.add(res);
                return;
            }
            return;
        }

        doWork(arr, ans, levelAns, idx+1, set);
        levelAns.add(arr[idx]);
        doWork(arr, ans, levelAns, idx+1, set);
        levelAns.removeLast();
    }

//    instead of using a set, we can iterate and skip the duplicate elements using a simple while loop
//    before line 49 -> while(idx +1 < arr.length && arr[idx] == arr[idx+1]) i++;
//    uses constant space
}
