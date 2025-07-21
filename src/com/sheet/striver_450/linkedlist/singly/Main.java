package com.sheet.striver_450.linkedlist.singly;

public class Main {
    public static void main(String[] args) throws Exception{

        LinkedList list  = new LinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);


        System.out.println(list.rotateRight(list.head, 2).val);
    }
}
