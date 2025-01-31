package com.heaps;

public class Main {
    public static void main(String[] args) throws Exception {
        Heaps heap = new Heaps();

        heap.insert(6);
        heap.insert(7);
        heap.insert(3);
        heap.insert(5);
        heap.insert(2);

        heap.print();
        System.out.println(heap.remove());
        heap.print();

        System.out.println(heap.heapSort());
    }
}
