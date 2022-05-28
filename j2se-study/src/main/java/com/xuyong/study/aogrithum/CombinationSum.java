package com.xuyong.study.aogrithum;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xuyong on 2021/11/4
 */
public class CombinationSum {

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        CombinationSum sum = new CombinationSum();
        System.out.println(sum.combinationSum(candidates, 7));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combine = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        dfs(result, combine, target, candidates, 0);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> combine, int target, int[] candidates, int idx) {
        if (target < 0 || idx >= candidates.length) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(combine));
            return;
        }
        if (target > 0) {
            for (int i = idx; i < candidates.length; i++) {
                combine.add(candidates[i]);
                dfs(result, combine, target - candidates[i], candidates, i);
                combine.remove(combine.size() - 1);
            }
        }
    }
}
