package MyArray;

public class Solution01 {
    public static void main(String[] args) {
        // 测试示例
        int[] nums1 = {2, 5, 6, 8, 10, 12, 15};
        int target1 = 10;
        System.out.println("示例1: 目标值 " + target1 + " 在数组中的下标为 " + search(nums1, target1));

        int[] nums2 = {1, 3, 4, 5, 7, 9, 11};
        int target2 = 6;
        System.out.println("示例2: 目标值 " + target2 + " 在数组中的下标为 " + search(nums2, target2));

        int[] nums3 = {-10, -5, 0, 5, 10, 15, 20};
        int target3 = -5;
        System.out.println("示例3: 目标值 " + target3 + " 在数组中的下标为 " + search(nums3, target3));

    }

    public static int search(int[] nums, int target) {
        /*
        标签：二分查找
        过程：
        设定左右指针
        找出中间位置，并判断该位置值是否等于 target
        nums[mid] == target 则返回该位置下标
        nums[mid] > target 则右侧指针移到中间
        nums[mid] < target 则左侧指针移到中间
        时间复杂度：O(logN)
         */
        //判断target是否超出数组
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                //nums[mid] < target
                left = mid + 1;
            }
        }
        // 未找到目标值
        return -1;

    }

}
