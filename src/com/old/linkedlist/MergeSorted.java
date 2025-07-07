package com.old.linkedlist;

public class MergeSorted {

    LL merge(Node left, Node right) {

        LL res = new LL();
        while (left != null && right != null) {
            if(left.val <= right.val) {
                res.insert(left.val);
                left = left.next;
            } else {
                res.insert(right.val);
                right = right.next;
            }
        }
        while (left != null) {
            res.insert(left.val);
            left = left.next;
        }

        while (right != null) {
            res.insert(right.val);
            right = right.next;
        }
        return res;
    }
}
