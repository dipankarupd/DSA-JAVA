package com.old.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Pairs {
    int val;
    int idx;

    Pairs(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}

public class MaxAreaInBinaryArray {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 1, 1, 0},
                {1, 1, 1, 1},
                {1, 1, 1, 1},
                {1, 1, 0, 0}
        };
        System.out.println(maxArea(arr));
    }

    static int maxArea(int[][] arr) {
        int maxArea = 0;

        // Create histogram from the first row
        ArrayList<Integer> vec = new ArrayList<>();
        for (int c = 0; c < arr[0].length; c++) {
            vec.add(arr[0][c]);
        }
        maxArea = maximumAreaHistogram(vec);

        // Process the rest of the rows
        for (int r = 1; r < arr.length; r++) {
            for (int c = 0; c < arr[r].length; c++) {
                if (arr[r][c] == 0) {
                    vec.set(c, 0);
                } else {
                    vec.set(c, vec.get(c) + arr[r][c]);
                }
            }
            maxArea = Math.max(maxArea, maximumAreaHistogram(vec));
        }
        return maxArea;
    }

    static int maximumAreaHistogram(ArrayList<Integer> vec) {
        Stack<Pairs> stk = new Stack<>();

        // Find nearest smallest to left
        ArrayList<Integer> nsl = findNsl(vec, stk);

        stk.clear();
        // Find nearest smallest to right
        ArrayList<Integer> nsr = findNsr(vec, stk);

        int maxArea = 0;

        for (int i = 0; i < vec.size(); i++) {
            int width = nsr.get(i) - nsl.get(i) - 1;
            int height = vec.get(i);
            int area = height * width;
            maxArea = Math.max(area, maxArea);
        }

        return maxArea;
    }

    static ArrayList<Integer> findNsl(ArrayList<Integer> vec, Stack<Pairs> stk) {
        ArrayList<Integer> nsl = new ArrayList<>();
        int piv = -1;

        for (int i = 0; i < vec.size(); i++) {
            while (!stk.isEmpty() && stk.peek().val >= vec.get(i)) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                nsl.add(piv);
            } else {
                nsl.add(stk.peek().idx);
            }

            stk.push(new Pairs(vec.get(i), i));
        }

        return nsl;
    }

    static ArrayList<Integer> findNsr(ArrayList<Integer> vec, Stack<Pairs> stk) {
        ArrayList<Integer> nsr = new ArrayList<>();
        int piv = vec.size();

        for (int i = vec.size() - 1; i >= 0; i--) {
            while (!stk.isEmpty() && stk.peek().val >= vec.get(i)) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                nsr.add(piv);
            } else {
                nsr.add(stk.peek().idx);
            }

            stk.push(new Pairs(vec.get(i), i));
        }
        Collections.reverse(nsr);
        return nsr;
    }
}
