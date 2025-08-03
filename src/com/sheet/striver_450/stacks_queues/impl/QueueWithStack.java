package com.sheet.striver_450.stacks_queues.impl;

import java.util.Stack;

public class QueueWithStack {
}

class MyQueue {

    Stack<Integer> stk;
    Stack<Integer> temp;

    public MyQueue() {
        stk = new Stack<>();
        temp = new Stack<>();
    }

    public void push(int x) {
        while (!stk.isEmpty()){
            temp.push(stk.pop());
        }
        stk.push(x);
        while (!temp.isEmpty()){
            stk.push(temp.pop());
        }
    }

    public int pop() {
        return stk.pop();
    }

    public int peek() {
        return stk.peek();
    }

    public boolean empty() {
        return stk.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
