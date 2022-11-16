package com.xuyong.study.aogrithum.combine;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 组合
 * @Author: xuyong
 * @Date: 2022/9/14
 **/
public class CombineInt {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> combine = new ArrayList<>();

    public static void main(String[] args) {
        CombineInt combineInt = new CombineInt();
        System.out.println(combineInt.combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        dfs(1, k, n);
        return result;
    }

    public void dfs(int n, int k, int max) {
        if (k == 0) {
            result.add(new ArrayList<>(combine));
        } else {
            for (int i = n; i <= max; i++) {
                if (combine.contains(i)) {
                    continue;
                }
                combine.add(i);
                dfs(i, k - 1, max);
                combine.remove(combine.size() - 1);
            }
        }
    }

}
