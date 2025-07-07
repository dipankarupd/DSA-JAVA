package com.sheet.striver_450.array.medium;
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
public class BuySellStocks {

    public static void main(String[] args) {
//        int[] arr = {7,6,3,5,4,1};
//        System.out.println(maxProfit(arr));

        int[] arr = {5, -2, -3, 1, 2, -1, 4, -5};
        int k = 3;

        System.out.println(maxSum(arr,k));
    }

    static int maxProfit(int[] arr) {
//        step 1: find the smallest elem and its idx
       int buyingPrice = arr[0];
       int profit = 0;

        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < buyingPrice) {
                buyingPrice = arr[i];
            } else {
                int profitIfISellToday = arr[i] - buyingPrice;
                profit = Math.max(profit, profitIfISellToday);
            }
        }
       return profit;
    }

    static int maxSum(int[] arr, int k) {
        // first I declare the variables:
        int maxSum = Integer.MIN_VALUE;
        int maxIdx = 0;
        int sum = 0;
        int i = 0, j = 0;

        while(j < arr.length) {
            sum = sum + arr[j];

            // keep incrementing till the window size reach
            if(j-i+1 < k) {
                j++;
            } else if(j-i+1 == k) {
                if(maxSum < sum) {
                    maxIdx = i;
                    maxSum = sum;
                }

                // remove the ith element
                sum = sum - arr[i];

                i++;
                j++;
            }
        }
        // the starting index will be this
        return maxIdx;
    }
}
