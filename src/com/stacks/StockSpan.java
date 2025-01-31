package com.stacks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/*
The stock span problem is a financial problem where we have a series of daily
price quotes for a stock denoted by an array arr[] and the task is to calculate
the span of the stock’s price for all days. The span arr[i] of the stock’s price
on a given day i is defined as the maximum number of consecutive days just before
the given day, for which the price of the stock on the given day is less than or
equal to its price on the current day.

 */
public class StockSpan {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(findSpan(new int[]{100, 80, 60, 70, 60, 75, 85})));
    }

    private static int[] findSpan(int[] arr) {
        Stack<Integer> stack = new Stack<Integer>();
        int[] ans = new int[arr.length];

        // to get the span, we can find the nearest greater to the right
        // and then subtract the index between them

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = i+1;
            }
            else if(arr[stack.peek()] > arr[i]) {
                ans[i] = i-stack.peek();
            }
            stack.push(i);
        }
        return ans;
    }
}
