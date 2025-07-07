package com.old.linkedlist;

public class Main {
    public static void main(String[] args) {

//        LL ll = new LL();
//        ll.insert(1);
//        ll.insert(2);
//        ll.insert(3);
//        ll.insert(4);
//
//        ll.display();
//
//        ll.insert(2, 2);
//
//        ll.display();
//
//        ll.removeDuplicate();
//        ll.display();

        LL l1 = new LL();
        l1.insert(1);
        l1.insert(3);
        l1.insert(5);
        l1.insert(7);
        l1.insert(9);


        Node res = l1.findMiddleNode(l1.head);
        System.out.println(res.val);

//        LL l2 = new LL();
//        l2.insert(1);
//        l2.insert(2);
//        l2.insert(4);
//        l2.insert(6);
//
//        MergeSorted ms = new MergeSorted();
//        LL res = ms.merge(l1.head, l2.head);
//        res.display();


    }
}
