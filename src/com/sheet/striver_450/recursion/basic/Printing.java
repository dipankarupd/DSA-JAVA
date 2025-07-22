package com.sheet.striver_450.recursion.basic;

public class Printing {
    public static void main(String[] args) {
        print(8);
    }

    static void print(int n) {
        if (n == 1) {
            System.out.println(n + " ");
            return;
        }

        print(n-1);
        System.out.println(n + " ");
    }
}
