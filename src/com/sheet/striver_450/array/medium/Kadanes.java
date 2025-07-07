package com.sheet.striver_450.array.medium;

import java.util.ArrayList;
import java.util.List;

public class Kadanes {
    public static void main(String[] args) {
        int[] arr = {1,-2,3,-1,4};

        System.out.println(maxSum(arr));

        System.out.println(getSubarray(arr));
    }

//    kadane algo to find the maximum sum:
    static int maxSum(int []arr) {
        int max=arr[0];
        int curr = arr[0];

        for(int i=1; i<arr.length; i++) {
            curr = Math.max(curr+arr[i], arr[i]);
            max = Math.max(curr, max);
        }
        return max;
    }

    static List<Integer> getSubarray(int[] arr) {
        List<Integer> res = new ArrayList<>();
        int max = arr[0];
        int curr = arr[0];
        int temp = 0;
        int startIdx = 0, endIdx = 0;

        for(int i=1; i<arr.length; i++) {

            if(curr + arr[i] > arr[i]) {
                curr = curr + arr[i];

            } else {
                curr = arr[i];
                temp = i;
            }

            if(curr > max) {
                max = curr;
                startIdx = temp;
                endIdx = i;
            }
        }

        for(int i=startIdx; i<= endIdx; i+=1) {
            res.add(arr[i]);
        }

        return res;
    }
}
