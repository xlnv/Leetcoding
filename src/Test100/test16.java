package Test100;

public class test16 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        int[] result = productExceptSelf(nums);
        for (int value : result) {
            System.out.print(value + " ");

        }
    }
    /**
     * 给定一个整数数组 nums，返回一个数组 answer，
     * 其中 answer[i] 等于数组 nums 中除 nums[i] 之外的其余各元素的乘积。
     * 题目数据保证数组 nums 中任意元素的全部前缀元素和后缀的乘积都在 32 位整数范围内。
     * 请不要使用除法运算，且在 O(n) 时间复杂度内完成此题。
     */

    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // 计算左侧乘积
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // 计算右侧乘积并得到最终结果
        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            //right 用于存储从当前元素开始，右侧所有元素的乘积。
            right *= nums[i];
        }

        return answer;

    }
}
