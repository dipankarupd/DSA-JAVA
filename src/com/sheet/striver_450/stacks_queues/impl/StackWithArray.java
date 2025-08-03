package com.sheet.striver_450.stacks_queues.impl;

import java.util.ArrayList;
import java.util.List;

public class StackWithArray {
    public static void main(String[] args) throws Exception {

        UserStack stk = new UserStack();


        stk.print();

        System.out.println(stk.pop());
        System.out.println(stk.top());
    }
}

class UserStack {

//    1 2 3
    List<Integer> temp = new ArrayList<>();
    int topIdx = -1;

    int top() throws Exception {
        if (topIdx == -1) {
            throw new RuntimeException("Empty stack");
        }
        return temp.get(topIdx);
    }
    void push(int val) {
        topIdx += 1;
        temp.add(topIdx, val);
    }

    int pop() throws Exception {
        if (topIdx < 0) {
            throw new RuntimeException("No element to pop");
        }
        int res = temp.remove(topIdx);
        topIdx --;
        return res;
    }

    void print() {
        System.out.println(temp.reversed());
    }
}
