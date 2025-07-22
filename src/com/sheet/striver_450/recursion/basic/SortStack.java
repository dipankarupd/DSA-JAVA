package com.sheet.striver_450.recursion.basic;

import java.util.Stack;

// sorting a stack using recursion ... same for array
public class SortStack {

    public static void main(String[] args) {
        Stack<Integer> stk= new Stack<>();
        stk.push(5);
        stk.push(2);
        stk.push(8);
        stk.push(9);
        stk.push(3);

        sort(stk);

        System.out.println(stk);
    }


    private static void sort(Stack<Integer> stk) {

        if(stk.size() == 1) {
            return;
        }

//        step 1: sort n-1 part:
        int temp = stk.pop();

        sort(stk);

        insert(stk, temp);
    }


    private static void insert(Stack<Integer> stk, int val) {

        if (stk.isEmpty() || stk.peek() <= val) {
            stk.push(val);
            return;
        }

        int temp = stk.pop();
        insert(stk,val);
        stk.push(temp);

        return;
    }
}
