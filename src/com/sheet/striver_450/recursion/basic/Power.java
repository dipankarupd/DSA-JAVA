package com.sheet.striver_450.recursion.basic;

public class Power {
    public static void main(String[] args) {
        System.out.println(myPow(2.00000
                , -2147483648
        ));
    }

    static double myPow(double x, int n) {


//        base case:
        if(n == 0) return 1;
        if(n == 1) return x;
        if(x == 1) return 1;

        int absPow = Math.abs(n);

        double halfPower = myPow(x, absPow/2);
        double ans = 0;
        if(absPow % 2 == 0) {
            ans = halfPower * halfPower;
        }
        else ans =  halfPower * halfPower * x;


        return n < 0 ? 1/ans : ans;
    }


    static double myPowIterative(double x, int n) {
        long N = n;

        if (n < 0) {
            x = 1/x;
            N = -N;
        }
        double ans = 1;
        while (N > 0) {

            if(N % 2 == 1) {
                ans = ans * x;
                N = N - 1;
            }
            x = x * x;
            N = N / 2;
        }
        return ans;
    }

}
