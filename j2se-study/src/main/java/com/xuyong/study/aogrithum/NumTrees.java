package com.xuyong.study.aogrithum;

/**
 * Created by xuyong on 2021/11/12
 */
public class NumTrees {

    public static void main(String[] args) {
        NumTrees numTrees = new NumTrees();
        System.out.println(numTrees.numTrees(17));
    }

    public int numTrees(int n) {
        int start = 1, end = n;
        return generateTree(start, end);
    }

    private int generateTree(int start, int end) {
        int result = 0;
        if (start > end) {
            result++;
            return result;
        }
        for (int i = start; i <= end; i++) {
            int leftTree = generateTree(start, i - 1);
            int rightTree = generateTree(i + 1, end);
            result += leftTree * rightTree;
        }
        return result;
    }

}
