package Test100;

public class test13 {
    public static void main(String[] args) {
        /*
        给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
        子数组是数组中的一个连续部分。
        示例 1：
        输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
        输出：6
        解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
         */
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));  // 输出 6
    }

    public static int maxSubArray(int[] nums) {
        //1.定义dp数组
        int[] dp = new int[nums.length];
        //2.初始化dp数组

        dp[0] = nums[0];
        //3.状态转移方程
        // dp[i] 表示以第 i 个元素结尾的最大子数组和
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        //4.返回dp数组中的最大值
        int maxSum = dp[0];
        for (int i = 1; i < nums.length; i++) {
            maxSum = Math.max(maxSum,dp[i]);

        }
        return maxSum;

    }

}
