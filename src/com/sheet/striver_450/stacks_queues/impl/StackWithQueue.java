package com.sheet.striver_450.stacks_queues.impl;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithQueue {
}

class MyStack {
    Queue<Integer> queue;
//    Queue<Integer> queue2;

    public MyStack() {
        queue = new LinkedList<>();
    }
//
    public void push(int x) {
//        add the element
//        move the n-1 element to back of queue so nth element would always be on top

        queue.add(x);
        for (int i = 0; i < queue.size()-1; i++) {
            queue.add(queue.poll());
        }
    }

    public int pop() throws Exception {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.size() == 0;
    }
}
