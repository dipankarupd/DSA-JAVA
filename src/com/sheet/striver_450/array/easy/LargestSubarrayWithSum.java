package com.sheet.striver_450.array.easy;

public class LargestSubarrayWithSum {
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,5};
        int k = 5;
        System.out.println(largest(arr, k));
    }

    static int largest(int[] arr, int k) {

        int max = Integer.MIN_VALUE;
        int i = 0; int j = 0;
        int currentSum = 0;

        while (j < arr.length) {
            currentSum = currentSum + arr[j];

            // less
            if(currentSum < k) {
                j++;

            } else if(currentSum == k) {
                max = Math.max(max, j-i+1);
                j++;
            }
            else {

                // increase i up until curr sum < k
                while (currentSum > k) {
                    currentSum = currentSum - arr[i];
                    i++;
                }
                if (currentSum == k) {
                    max = Math.max(max, j-i+1);
                }
                j++;
            }


        }
        return max;
    }
}
