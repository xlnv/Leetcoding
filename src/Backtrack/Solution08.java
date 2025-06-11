package Backtrack;
/*
40.组合总和II
力扣题目链接(opens new window)

给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明： 所有数字（包括目标数）都是正整数。解集不能包含重复的组合。

示例 1:
输入: candidates = [10,1,2,7,6,1,5], target = 8,
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution08 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));// [[1, 1, 6], [1, 2, 5], [1, 7], [2, 6]]


    }
    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();


    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        boolean[] used = new boolean[candidates.length];  // 标记数组
        Arrays.sort(candidates);// 排序，让相同数字相邻
        backtrack(candidates,target,0);
        backtracking(candidates,target,0,used); // 容易理解的去重方法，使用标记数组
        return result;

    }

    private static void backtrack(int[] candidates, int target, int start) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        } else if (target < 0) {
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            //i > start 保证只在同一层跳过，而不是在递归的下一层跳过
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue; // 跳过重复的数字，避免重复的组合
            }

            if (candidates[i] > target) {// 剪枝：因为数组已排序，后面的数字只会更大，可以直接终止循环
                break;
            }
            temp.add(candidates[i]);
            // 递归到下一层，注意索引是i+1，因为不能重复使用同一个数字
            backtrack(candidates, target-candidates[i], i+1);
            temp.removeLast();

        }
    }

    public static void backtracking(int[] candidates, int target, int start, boolean[] used) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        }

        for (int i = start; i < candidates.length; i++) {
            // // 去重逻辑：前一个相同数字未被使用，则跳过
            if (i > 0 && candidates[i] == candidates[i - 1] && used[i - 1] == false) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            used[i] = true;
            temp.add(candidates[i]);
            backtracking(candidates, target - candidates[i], i + 1, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }
}
