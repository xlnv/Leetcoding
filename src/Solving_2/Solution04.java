package Solving_2;

import java.util.Arrays;

public class Solution04 {
    public static void main(String[] args) {
        //给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
        //输入：nums = [-4,-1,0,3,10]
        //输出：[0,1,9,16,100]
        int[] nums = {-4, -1, 0, 3, 10};
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = nums[i] * nums[i];
//        }
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
        int[] result = sort(nums);
        System.out.println(Arrays.toString(result));

    }
    public static int[] sort(int[] nums){
        int left = 0;
        int right = nums.length-1;
        int[] result = new int[nums.length];
        int index = result.length-1;
        while (left<=right){
            if (nums[left] * nums[left] > nums[right] * nums[right]) {
                result[index] = nums[left] * nums[left];
                index--;
                ++left;
            } else {
                result[index] = nums[right] * nums[right];
                index--;
                --right;
            }
        }
        return result;
    }

}
