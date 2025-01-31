package com.linkedlist;

public class happyNumber {

    public static boolean isHappy(int n) {

        int s = n, f = n;

        do {
            s = findSquare(s);
            f = findSquare(findSquare(f));
        } while(s != f);

        if(s == 1) return true;
        return false;
    }
    public static void main(String[] args) {

        System.out.println(isHappy(2));
        System.out.println(isHappy(19));
    }

    static int findSquare(int n) {
        int s = 0;

        while(n > 0) {
            int temp = n % 10;
            s += temp*temp;
            n = n / 10;
        }
        return s;
    }
}
