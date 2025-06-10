package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
47.全排列 II
力扣题目链接(opens new window)

给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：

输入：nums = [1,1,2]
输出： [[1,1,2], [1,2,1], [2,1,1]]
 */
public class Solution16 {
    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        int[] nums = {1, 1, 2};
        System.out.println(solution16.permuteUnique(nums));

    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(nums, new boolean[nums.length], result, new ArrayList<>());
        return result;

    }

    public void backtrack(int[] nums,boolean[] used, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 如果当前数字已经被使用，跳过
            if (used[i]) {
                continue;
            }
            // 剪枝：如果当前数字与前一个数字相同，且前一个数字未被使用，跳过（避免重复排列）
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            temp.add(nums[i]);
            backtrack(nums, used, result, temp);
            temp.remove(temp.size()-1);//回溯，说明同⼀树层nums[i]使⽤过，防止下一树层重复
            used[i] = false; //回溯
        }
    }


}
