package com.old.stacks;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{30,38,30,36,35,40,29})));
    }

    static int[] dailyTemperatures(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                res[i] = 0;
            }
            else if(arr[i] < arr[stack.peek()]){
                res[i] = stack.peek() - i;
            }
            else if(arr[i] >= arr[stack.peek()]){
                while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                    stack.pop();
                }
                if(stack.isEmpty()){
                    res[i] = 0;
                }
                else{
                    res[i] = stack.peek() - i;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
