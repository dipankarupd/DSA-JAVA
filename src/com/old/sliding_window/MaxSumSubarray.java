package com.old.sliding_window;

public class MaxSumSubarray {
    public static void main(String[] args) {
        System.out.println(maxSumSubarray(new int[]{2,5,1,8,2,9,1}, 3));
    }

    static int maxSumSubarray(int[] arr, int k) {
        int i=0;
        int j=0;
        int sum = 0;
        int maxSum = 0;

        while(j < arr.length) {

            // increament the sum:
            sum += arr[j];

            // until the window size is less than k, increament the value of j
            if(j-i+1 < k) {
                j++;
            }

            // if the window size is same:
            else if(j-i+1 == k) {
                // we need this window size and this sum:
                // check if the maximum sum is this or the previous sum
                maxSum = Math.max(maxSum, sum);

                // j idx value will be added always at the start
                // in this window, what we need to do is only remove the value from the
                // start of the window and increament the window -> move forward the window
                sum = sum - arr[i];
                i++;
                j++;


            }

        }
        return maxSum;
    }
}
