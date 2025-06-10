package Backtrack;
/*
78.子集
力扣题目链接(opens new window)

给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。

说明：解集不能包含重复的子集。

示例: 输入: nums = [1,2,3] 输出: [ [3],   [1],   [2],   [1,2,3],   [1,3],   [2,3],   [1,2],   [] ]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int[] nums = {1, 2, 3};

        System.out.println(solution11.subsets(nums));
    }




    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, result, new ArrayList<>(), 0);
        return result;

    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp, int start) {
        // 将当前子集加入结果列表
        result.add(new ArrayList<>(temp));

        // 从start开始遍历数组，避免重复子集
        for (int i = start; i < nums.length; i++) {
            // 将当前元素加入子集
            temp.add(nums[i]);
            // 递归处理下一个元素
            backtrack(nums, result, temp, i + 1);
            // 回溯，移除当前元素，尝试不包含该元素的子集
            temp.remove(temp.size() - 1);
        }
    }

}
