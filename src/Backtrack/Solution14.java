package Backtrack;
/*
491.递增子序列
力扣题目链接(opens new window)

给定一个整型数组, 你的任务是找到所有该数组的递增子序列，递增子序列的长度至少是2。
给定数组中可能包含重复数字，相等的数字应该被视为递增的一种情况。

示例:

输入: [4, 6, 7, 7]
输出: [[4, 6], [4, 7], [4, 6, 7], [4, 6, 7, 7], [6, 7], [6, 7, 7], [7,7], [4,7,7]]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution14 {
    public static void main(String[] args) {
        Solution14 solution14 = new Solution14();
        int[] nums = {4, 6, 7, 7};
        System.out.println(solution14.findSubsequences(nums));


    }

    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums,result,new ArrayList<>(),0);

        return result;

    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        if (temp.size() >= 2) {
            result.add(new ArrayList<>(temp));
        }

        // 用于记录当前层级已经使用过的数字
        boolean[] used = new boolean[201]; // 题目中数字范围是[-100, 100]，所以用201大小的数组

        for (int i = start; i < nums.length; i++) {

            // 如果当前数字已经被使用过，或者不满足递增条件，则跳过
            // 如果子序列非空且当前数字小于子序列的最后一个数字，说明加入 nums[i] 会破坏递增性，因此跳过。
            // 如果当前数字 nums[i] 在当前层级已经被使用过，则跳过。
            // 题目中数字范围是 [-100, 100]，所以 +100 将范围映射到 [0, 200]，方便用数组索引表示。
            // 必须加 +100（或类似偏移：如果直接用数组记录数字是否使用，负数无法作为索引。
            // 替代方案：用 HashSet 可以避免偏移，但稍慢；如果数字范围固定，+100 是最高效的方式
            if ((!temp.isEmpty() && nums[i] < temp.getLast() || used[nums[i] + 100])) {

                continue;
            }
            // 标记当前数字为已使用
            used[nums[i] + 100 ] = true;

            temp.add(nums[i]);
            backtrack(nums, result, temp, i + 1);
            temp.remove(temp.size()-1);
        }
    }

}
