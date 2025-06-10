package Backtrack;
/*
39. 组合总和
力扣题目链接(opens new window)

给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的数字可以无限制重复被选取。

说明：

所有数字（包括 target）都是正整数。
解集不能包含重复的组合。
示例 1：

输入：candidates = [2,3,6,7], target = 7,
所求解集为： [ [7], [2,2,3] ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution07 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target)); //[[2, 2, 2, 2], [2, 3, 3], [3, 5]]

    }

    private static List<List<Integer>> result = new ArrayList<>();
    private static List<Integer> temp = new ArrayList<>();



    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 排序，方便后续剪枝

        backtrack(candidates,target,0);

        return result;

    }

    private static void backtrack(int[] candidates, int target, int start) {
        if (target == 0) { // 剩余目标值为0，说明找到合法组合，加入结果集
            result.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0) { // 剩余目标值小于0，说明当前组合不合法，直接返回
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > target) { // 剪枝：当前数字已经大于剩余目标值，后面的数字更大，直接跳过
                break;
            }
            temp.add(candidates[i]);

            //在回溯算法中，start 参数的作用是控制下一层递归的起始位置，从而避免生成重复的组合。
            //start 为 i：允许重复使用当前数字 candidates[i]，因为下一层递归仍然可以从 i 开始选择。
            //start 为 i + 1：不允许重复使用当前数字 candidates[i]，因为下一层递归只能从 i + 1 开始选择。
            backtrack(candidates,target-candidates[i],i);

            temp.removeLast();
        }
    }


}
