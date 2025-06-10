package Backtrack;
/*
90.子集II
力扣题目链接(opens new window)

给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例:

输入: [1,2,2]
输出: [ [2], [1], [1,2,2], [2,2], [1,2], [] ]
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution13 {
    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[] nums = {1, 2, 2};
        System.out.println(solution13.subsetsWithDup(nums));

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);//为了将重复的数字都放到一起，所以先进行排序

        backtrack(nums,result,new ArrayList<>(),0);

        return result;

    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        result.add(new ArrayList<>(temp)); // 添加当前子集到结果中
        for (int i = start; i < nums.length; i++) {
            // 跳过重复元素，避免生成重复子集
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            temp.add(nums[i]); // 包含当前元素
            backtrack(nums, result, temp, i + 1); // 递归处理下一个元素
            temp.remove(temp.size() - 1); // 回溯，不包含当前元素
        }
    }
}
