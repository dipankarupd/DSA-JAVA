package com.heaps;

import java.util.ArrayList;
import java.util.List;

public class Heaps {
    private List<Integer> list;

    private int parent(int i) {
        return (i-1)/2;
    }

    private int left(int i) {
        return 2*i+1;
    }

    private int right(int i) {
        return 2*i+2;
    }

    private void swap(int i, int j) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public Heaps() {
        list = new ArrayList<>();
    }

    public void insert(int value) {
        list.add(value);
        upheap(list.size() - 1);
    }
    private void upheap(int i) {
        if (i == 0) return;

        int p = parent(i);
        if(list.get(p) < list.get(i)) {
            swap(i, p);
            upheap(p);
        }
    }

    public int remove() throws Exception {

        if(list.isEmpty()) {
            throw new Exception("Heap is empty");
        }
        int val = list.get(0);

        int last = list.remove(list.size()-1);

        if(!list.isEmpty()) {
            list.set(0, last);
            downheap(0);
        }

        return val;
    }

    private void downheap(int i) {

        int min = i;
        int l = left(i);
        int r = right(i);

        if(l < list.size() && list.get(l) > list.get(min)) {
            min = l;
        }
        if(r < list.size() && list.get(r) > list.get(min)) {
            min = r;
        }
        if(min != i) {
            swap(i, min);
            downheap(min);
        }
    }

    public void print() {
        System.out.println(list);
    }

    public ArrayList<Integer> heapSort() {
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i: list) {
            ans.add(i);
        }

        return ans;
    }
}
