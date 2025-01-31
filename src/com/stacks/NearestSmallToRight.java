package com.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestSmallToRight {
    public static void main(String[] args) {

        System.out.println(findSmallest(new int[]{1,3,2,4}));
    }

    private static ArrayList<Integer> findSmallest(int[] arr) {

        // create a result arraylist and stack:
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=arr.length-1; i>= 0; i--) {

            while(!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) {
                list.add(-1);
            } else {
                list.add(stack.peek());
            }
            stack.push(arr[i]);
        }
        Collections.reverse(list);
        return list;
    }
}
