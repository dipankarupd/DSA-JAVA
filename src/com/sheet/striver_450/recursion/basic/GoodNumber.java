package com.sheet.striver_450.recursion.basic;

// https://leetcode.com/problems/count-good-numbers/description/
public class GoodNumber {
    public static void main(String[] args) {
        long n = 7;
        System.out.println(countGoodNumbers(n));
    }

    static int countGoodNumbers(long n) {
        long mod= 1000000007;

        long evenCount = (n+1)/2;
        long oddCount = n/2;

        long res1= pow(5,evenCount, mod);
        long res2 = pow(4, oddCount, mod);

        return (int) ((res1 * res2) % mod);
    }

    static long pow(long x, long n, long mod) {
        long res = 1;

        x = x % mod;

        while(n > 0) {

            if(n % 2 == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            n = n/2;
        }

        return res;
    }
}
