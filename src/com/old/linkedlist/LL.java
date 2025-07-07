package com.old.linkedlist;


class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }
}

class LL {
    Node head;

    void insert(int val) {


        if (head == null) {
            head = new Node(val);
            return;
        }
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }

        Node node = new Node(val);
        temp.next = node;
    }

    void insert(int val, int idx) {
        head = insertRec(val, idx, head);
    }

    void display() {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("END");
    }

    void removeDuplicate() {
        Node temp = head;

        while(temp.next != null) {
            if(temp.next != null && temp.next.val == temp.val) {
                temp.next = temp.next.next;
            } else {
                temp = temp.next;
            }
        }
    }

    // find cycle
    public boolean checkCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }

    // count the number of element in the cycle
    public int countCycle(Node head) {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                Node temp = slow;
                int length = 0;

                do {
                    temp = temp.next;
                    length++;
                }while(temp != slow);
                return length;
            }
        }
        return 0;
    }

    public Node findMiddleNode(Node head) {
         Node slow = head;
         Node fast = head;
         while(fast != null && fast.next != null) {
             slow = slow.next;
             fast = fast.next.next;
         }
         return slow;
    }
    private Node insertRec(int val, int idx, Node node) {

        if(idx == 0) {
            Node temp = new Node(val);
            temp.next = node;
            return temp;
        }
        node.next = insertRec(val, idx-1, node.next);
        return node;
    }
}
