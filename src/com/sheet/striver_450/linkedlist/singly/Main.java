package com.sheet.striver_450.linkedlist.singly;

public class Main {
    public static void main(String[] args) throws Exception{

        LinkedList list  = new LinkedList();
        list.insert(1);
        list.insert(2);
//
        list.insert(3);
        list.insert(5);
        list.insert(7);

        list.printList();


        System.out.println(list.reverse(list.head).val);
        list.printList();
        System.out.println(list.head.val);

    }
}
