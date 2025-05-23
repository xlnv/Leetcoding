package a01Array;



public class LeetCode_35 {
    public static void main(String[] args) {
        /*
        给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
        如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        请必须使用时间复杂度为 O(log n) 的算法。
         */
        int[] nums = {1,3,5,6};
        int target = 5;
        int result = searchInsert(nums, target);
        System.out.println(result);
    }

    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        // 2.目标值在数组所有元素之前
        // 3.目标值插入数组中
        // 4.目标值在数组所有元素之后
        // return left;
        /*
        二分查找的终止条件是 left > right。此时，left 指向的是插入位置：
        如果 target 小于数组中的所有元素，left 将保持为 0，这是 target 应该插入的位置。
        如果 target 大于数组中的所有元素，left 将等于数组的长度，这是 target 应该插入的位置。
        如果 target 在数组中的某些元素之间，left 将指向第一个大于 target 的元素位置，
        这是 target 应该插入的位置。
         */
        return left;

    }
}
