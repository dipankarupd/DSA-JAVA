package com.old.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class NearestGreatToRight {

    public static void main(String[] args) {

        System.out.println(findGreatest(new int[]{2,3,10,4,3,6,8}));
    }

    private static ArrayList<Integer> findGreatest(int[] arr) {

        // create a result arraylist and stack:
        Stack<Integer> stack = new Stack<>();
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=arr.length-1; i>= 0; i--) {

            while(!stack.isEmpty() && stack.peek() <= arr[i]) {
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
