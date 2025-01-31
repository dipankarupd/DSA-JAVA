package com.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

class Pair {
    int val;
    int idx;

    public Pair(int val, int idx) {
        this.val = val;
        this.idx = idx;
    }
}
// https://neetcode.io/problems/largest-rectangle-in-histogram
public class LargestAreaHistogram {
    public static void main(String[] args) {
        System.out.println(largestRectangleArea(new int[]{2,1,5,6,2,3}));
    }

    static int largestRectangleArea(int[] heights) {


        Stack<Pair> stk = new Stack<>();
        ArrayList<Integer> nsl = findNSL(stk, heights);
        System.out.println(nsl);
        stk.clear();

        ArrayList<Integer> nsr = findNSR(stk, heights);
        System.out.println(nsr);
        int max = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++) {
            int w = nsr.get(i) - nsl.get(i) - 1;
            int h = heights[i];
            int area = h*w;
            max = Math.max(area, max);
        }

        return max;
    }

    private static ArrayList<Integer> findNSL(Stack<Pair> stk, int[] heights) {
        ArrayList<Integer> nsl = new ArrayList<>();

        for(int i = 0; i < heights.length; i++) {
            if(stk.isEmpty()) {
                nsl.add(-1);
            }
            else if(stk.peek().val >= heights[i]) {
                while(!stk.isEmpty() && stk.peek().val >= heights[i]) {
                    stk.pop();
                }
                if(stk.isEmpty()) {
                    nsl.add(-1);
                }
                else {
                    nsl.add(stk.peek().idx);
                }
            } else if(stk.peek().val < heights[i]) {
                nsl.add(stk.peek().idx);
            }
            stk.push(new Pair(heights[i], i));
        }

        return nsl;
    }

    private static ArrayList<Integer> findNSR(Stack<Pair> stk, int[] heights) {
        ArrayList<Integer> nsr = new ArrayList<>();

        for(int i=heights.length-1; i>= 0; i--) {
            if(stk.isEmpty()) {
                nsr.add(heights.length);
            }
            else if(stk.peek().val >= heights[i]) {
                while(!stk.isEmpty() && stk.peek().val >= heights[i]) {
                    stk.pop();
                }
                if(stk.isEmpty()) {
                    nsr.add(heights.length);
                }
                else {
                    nsr.add(stk.peek().idx);
                }
            }
            else if(stk.peek().val < heights[i]) {
                nsr.add(stk.peek().idx);
            }
            stk.push(new Pair(heights[i], i));
        }
        Collections.reverse(nsr);
        return nsr;
    }

}


