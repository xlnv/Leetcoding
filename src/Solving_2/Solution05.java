package Solving_2;

public class Solution05 {
    public static void main(String[] args) {
        //给定一个含有 n 个正整数的数组和一个正整数 s ，
        // 找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
        //输入：s = 7, nums = [2,3,1,2,4,3]
        //输出：2
        //解释：子数组 [4,3] 是该条件下的长度最小的子数组。
        int[] nums = {2,3,1,2,4,3};
        int s = 5;
        int result = minSub(nums, s);
        System.out.println(result);

    }
    public static int minSub(int[] nums, int s){
        //滑动窗口法
        int left = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(int right = 0; right<nums.length; right++){
            sum += nums[right];
            while (sum >= s){
                result = Math.min(result, right - left + 1);
                sum = sum -nums[left];
                left++;
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
