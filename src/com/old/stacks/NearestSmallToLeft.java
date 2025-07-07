package com.old.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NearestSmallToLeft {
    public static void main(String[] args) {
        System.out.println(findSmallest(new int[]{1,4,6,3,5,2,4,7,4}));
    }

    private static ArrayList<Integer> findSmallest(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=0; i<arr.length; i++) {

            if(stack.isEmpty()) {
                res.add(-1);
            }
            else if(stack.peek() < arr[i]) {
                res.add(stack.peek());
            }
            else if(stack.peek() >= arr[i]) {
                while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    res.add(-1);
                }
                else {
                    res.add(stack.peek());
                }
            }

            stack.push(arr[i]);
        }

        return res;
    }
}
