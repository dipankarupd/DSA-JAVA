package com.sheet.striver_450.stacks_queues.impl;

import java.util.ArrayList;
import java.util.List;

public class QueueWithArray  {
    public static void main(String[] args) throws Exception {
        UserQueue queue = new UserQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.print();
        System.out.println(queue.top());
        System.out.println(queue.pop());
queue.print();    }
}

class UserQueue {

    //    1 2 3
    List<Integer> temp = new ArrayList<>();
    int topIdx = 0;
    int size = 0;

    int top() throws Exception {
        if (size == 0) {
            throw new RuntimeException("Empty queue");
        }
        return temp.get(topIdx);
    }
    void push(int val){
        temp.add(val);
        size++;
    }

    int pop() throws Exception {
        if (topIdx < 0) {
            throw new RuntimeException("No element to pop");
        }
        int res = temp.remove(topIdx);
        size--;
        return res;
    }

    void print() {
        System.out.println(temp);
    }
}