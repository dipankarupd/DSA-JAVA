package com.sheet.striver_450.linkedlist.singly;

import java.util.List;
import java.util.Stack;

public class LinkedList {
    public ListNode head;
    public int length;
    LinkedList() {
        this.head = null;
        this.length = 0;
    }
//  insert the list
    public void insert(int val) {
        if(head == null) {
            head = new ListNode(val);
            length++;
            return;
        }
        ListNode temp = head;

        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = new ListNode(val);
        length++;
    }


//    print the list
    public void printList() {
        ListNode temp = head;

        while (temp != null) {
            System.out.print(temp.val+ " ");
            temp = temp.next;
        }
        System.out.println();
    }
//    remove from the end
    public int removeLast() throws Exception{
        if (head == null) {
            throw new RuntimeException("Empty list");
        }

        if(head.next == null) {
            int res =  head.val;
            head = null;
            length --;
            return res;
        }

        ListNode temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        int res = temp.next.val;
        temp.next = null;
        length--;
        return res;
    }

//    remove the head
    public int removeHead() {
        if (head == null) {
            throw new RuntimeException("Empty list");
        }
        if(head.next == null) {
            int res =  head.val;
            head = null;
            return res;
        }

        ListNode temp = head;
        head = head.next;
        temp.next = null;
        return temp.val;
    }


//    remove at a certain index:
    public int remove(int idx) throws Exception{

        if(idx >= length) {
            throw new Exception("Index out of bound");
        }

        if(idx == 0) {
            return removeHead();
        }
        if(idx == length - 1) {
            return removeLast();
        }

        int count = 0;
        ListNode temp = head;
        while(count < idx-1) {
            temp=temp.next;
            count+=1;
        }

        ListNode removed = temp.next;
        temp.next = temp.next.next;
        removed.next = null;
        return removed.val;
    }


//    return the middle of the list
//    https://leetcode.com/problems/middle-of-the-linked-list/description/
    public ListNode middleNode(ListNode head) {
         if(head == null) return null;
         if(head.next == null) return head;
         if(head.next.next == null) return head.next;

         ListNode fast = head;
         ListNode slow = head;

         while (fast.next != null && fast.next.next != null ) {
             fast = fast.next.next;
             slow = slow.next;

         }

         if(fast.next == null) {
             return slow;
         }
        else {
            return slow.next;
        }
    }


//    reverse a linked list
//    https://leetcode.com/problems/reverse-linked-list/description/
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode nxt = curr.next;

        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = nxt;

            if (nxt != null) {
                nxt = nxt.next;
            }
        }

        this.head = prev;
        return prev;
    }

//    cycle detection
//     https://leetcode.com/problems/linked-list-cycle/
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if(slow == fast) return true;
        }
        return false;
    }

//    detect where the cycle begins
//    https://leetcode.com/problems/linked-list-cycle-ii/description/

    public ListNode detectCycle(ListNode head) {
        int cycleLength = findCycleLength(head);
        if (cycleLength == 0) return null;

        ListNode a = head;
        for (int i = 0; i < cycleLength; i++) {
            a = a.next;
        }

        ListNode b = head;
        while (a != b) {
            a = a.next;
            b = b.next;
        }

        return a;

    }

    public int findCycleLength(ListNode head) {
        ListNode f = head;
        ListNode s = head;
        int count = 0;


        while (f != null && f.next != null) {
            f = f.next.next;
            s = s.next;

            if(s == f) {
                do {
                    s = s.next;
                    count += 1;
                }while (s != f);

                return count;
            }
        }


        return count;
    }

//    check for palindrome:
//    https://leetcode.com/problems/palindrome-linked-list/description/
    public boolean isPalindrome(ListNode head) {


//        option 1 -> use stack to store first while traversing and then check again
//        ListNode temp = head;
//
//        Stack<ListNode> store = new Stack<>();
//
//        while (temp != null) {
//            store.push(temp);
//            temp = temp.next;
//        }
//
//        temp = head;
//        while (temp != null) {
//            ListNode check = store.pop();
//            if (temp.val != check.val) {
//                return false;
//            }
//            temp = temp.next;
//        }
//
//        return true;


//        option 2, linear time and constant space
//        find the middle
//        reverse from middle to end
//        make 2 pointers - one from start other from middle - and check if the val will be same or not

        ListNode middle = middleNode(head);
        ListNode reversed = reverse(middle);

        ListNode temp = head;

        while (temp != middle) {
            if(temp.val != reversed.val) {
                return false;
            }
            temp = temp.next;
            reversed = reversed.next;
        }

        return true;


    }


//    reverse between two endpoints in linked list:
//    https://leetcode.com/problems/reverse-linked-list-ii/
    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode prev = null;
        ListNode curr = head;
        int i = 1;

        while (i < left) {
            prev = curr;
            curr = curr.next;
            i++;
        }

        ListNode x = prev;
        ListNode y = curr;

        ListNode next = curr.next;

        for (int j = 0; curr != null && j < right - left + 1; j++) {

            curr.next = prev;
            prev = curr;
            curr = next;
            if (next != null) {
                next = next.next;
            }
        }

        if(x == null) {
            head = prev;
        } else {
            x.next = prev;

        }

        y.next = curr;
        return head;
    }


//    odd even linked list
//    https://leetcode.com/problems/odd-even-linked-list/description/
    public ListNode oddEvenList(ListNode head) {


//        base case - head null or only one node
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode temp = even;

        while (even != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = temp;
        return head;
    }

//    Remove nth node from back of ll
//    https://leetcode.com/problems/remove-nth-node-from-end-of-list/description/
    public ListNode removeNthFromEnd(ListNode head, int n) {


        if(head == null) return null;

        int count = listSize(head);
        int m = count - n;

        ListNode s = head;
        ListNode f = head;

        int fastCount = 0;
        while (fastCount < n) {
            f = f.next;
            fastCount += 1;
        }

        if(f == null) {
            return head.next;
        }

        while (f.next != null ) {
            f = f.next;
            s = s.next;
        }
        s.next = s.next.next;
        return head;

//        remove the slow element

    }

    private int listSize(ListNode head) {
        int count = 0;
        ListNode temp = head;

        while (temp != null) {
            count += 1;
            temp = temp.next;
        }
        return count;
    }
}
