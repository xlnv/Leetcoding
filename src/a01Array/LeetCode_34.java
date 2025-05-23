package a01Array;

public class LeetCode_34 {
    public static void main(String[] args) {
        /*
        给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。
        请你找出给定目标值在数组中的开始位置和结束位置。
        如果数组中不存在目标值 target，返回 [-1, -1]。
        你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
         */
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 12;
        int[] result = searchRange(nums, target);
        System.out.println("示例1: 目标值 " + target + " 的范围为 [" + result[0] + ", " + result[1] + "]");


    }
    public static int[] searchRange(int[] nums, int target){
        int[] arr = new int[2];
        arr[0] = findStartingIndex(nums,target);
        arr[1] = findEndingIndex(nums,target);
        return arr;

    }

    // 找到目标值的起始位置
    public static int findStartingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int startIndex = -1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                startIndex = mid;
                right = mid -1;// 继续在左半部分查找
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return startIndex;
    }

    // // 找到目标值的结束位置
    public static int findEndingIndex(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;
        int endIndex = -1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                endIndex = mid;
                left = mid + 1;// 继续在右半部分查找
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return endIndex;
    }

}
