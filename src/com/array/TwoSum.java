package com.array;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    static int[] search(int[] arr, int t) {
        int s = 0;
        int e = arr.length - 1;
        int[] ans = {-1,-1};

        while (s <= e) {
            int answer = arr[s] + arr[e];
            if (answer == t) {
                ans[0] = s;
                ans[1] = e;
                break;
            }
            else if(answer > t) {
                e--;
            } else {
                s++;
            }
        }
        return ans;
    }

    public static int[] twoSum(int[] nums, int target) {
        int arr[] = Arrays.copyOf(nums, nums.length);
        Arrays.sort(arr);

        int ans[] = search(arr, target);

        if (ans[0] == -1 && ans[1] == -1) {
            return ans;
        }
        else {
            int[] res = new int[2];
            for(int i = 0; i < nums.length; i++) {
                if (nums[i] == arr[ans[0]]) {
                    res[0] = i;
                }
                if (nums[i] == arr[ans[1]]) {
                    res[1] = i;
                }
            }
            return res;
        }
    }



    public static void main(String[] args) {
        int arr[] = {2,5,8,3,1,7};
        int target = 8;
        int[] ans = twoSumMap(arr, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    private static int[] twoSumMap(int[] arr, int target) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int comp = target - arr[i];

            if (map.containsKey(comp)) {
                return new int[]{map.get(comp), i};
            }
            map.put(arr[i], i);
        }
        return new int[]{-1,-1};
    }
}
