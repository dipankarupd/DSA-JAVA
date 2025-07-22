package com.sheet.striver_450.recursion.basic;

import java.util.Stack;

// https://www.geeksforgeeks.org/problems/reverse-a-stack/1
public class ReverseStack {

    public static void main(String[] args) {
        Stack<Integer> stk = new Stack<>();
        stk.push(1);
        stk.push(2);
        stk.push(3);
        stk.push(4);
        stk.push(5);

        reverse(stk);

        System.out.println(stk);
        System.out.println(stk.peek());
    }


    private static void reverse(Stack<Integer> stk)
    {

            if(stk.size() == 1) return;

            int last = stk.pop();
            reverse(stk);
            insertAtLast(last, stk);
    }

    private static void insertAtLast(int last, Stack<Integer> stk) {

        if(stk.isEmpty()) {
            stk.push(last);
            return;
        }

        int removed = stk.pop();
        insertAtLast(last, stk);
        stk.push(removed);
    }


}
