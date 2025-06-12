package GreedyAlgorithm;

import java.util.Arrays;

/*
53. 最大子序和
力扣题目链接(opens new window)

给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例:

输入: [-2,1,-3,4,-1,2,1,-5,4]
输出: 6
解释:  连续子数组  [4,-1,2,1] 的和最大，为  6。

 */
public class Solution04 {
    public static void main(String[] args) {
        Solution04 solution04 = new Solution04();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(solution04.maxSubArray(nums)); //  6
        System.out.println(Arrays.toString(solution04.maxSubArrayWithIndices(nums))); // [3,6]

    }

    public int maxSubArray(int[] nums){
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSum = nums[0]; // 初始化全局最大和为第一个元素
        int currentSum = nums[0]; // 当前子数组的和也初始化为第一个元素

        for (int i = 1; i < nums.length; i++) {
            // 决定是继续扩展当前子数组，还是以当前元素开始新的子数组
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // 更新全局最大和
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public int[] maxSubArrayWithIndices(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};

        int maxSum = nums[0];
        int currentSum = nums[0];
        int start = 0, end = 0;
        int tempStart = 0; // 临时起始索引

        for (int i = 1; i < nums.length; i++) {
            if (currentSum + nums[i] > nums[i]) {
                currentSum += nums[i];
            } else {
                currentSum = nums[i];
                tempStart = i; // 更新临时起点
            }

            if (currentSum > maxSum) {
                maxSum = currentSum;
                start = tempStart;
                end = i;
            }
        }

        return new int[]{start, end};
    }
}
