package Backtrack;
/*
46.全排列
力扣题目链接(opens new window)

给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出: [ [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], [3,2,1] ]
 */

import java.util.ArrayList;
import java.util.List;

public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = {1, 2, 3};
        System.out.println(solution15.permute(nums));

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums,result,new ArrayList<>());
        return result;

    }

    public void backtrack(int[] nums, List<List<Integer>> result, List<Integer> temp) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        //全排列需要从所有未使用的数字中选择，因此不需要 start 参数。直接遍历整个数组即可。

        for (int num : nums) {
            // 如果当前数字已经在路径中，跳过
            if (temp.contains(num)) {
                continue;
            }
            temp.add(num);
            backtrack(nums, result, temp);
            temp.removeLast();

        }
    }
}
