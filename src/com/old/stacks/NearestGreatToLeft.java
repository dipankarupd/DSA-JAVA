package com.old.stacks;

import java.util.ArrayList;
import java.util.Stack;

public class NearestGreatToLeft {

    public static void main(String[] args) {
        System.out.println(findGreatest(new int[]{1,3,2,4}));
    }

    private static ArrayList<Integer> findGreatest(int[] arr) {

        // create a result arraylist and stack:
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();

        for(int i=0; i<arr.length; i++) {

            if(stack.isEmpty()) {
                res.add(-1);
            }
            else if(stack.peek() > arr[i]) {
                res.add(stack.peek());
            }
            else if(stack.peek() <= arr[i]) {
                while(!stack.isEmpty() && stack.peek() <= arr[i]) {
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
        return res  ;
    }
}
