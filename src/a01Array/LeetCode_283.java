package a01Array;

public class LeetCode_283 {
    public static void main(String[] args) {
        /*
        给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
        请注意 ，必须在不复制数组的情况下原地对数组进行操作。
        输入: nums = [0,1,0,3,12]
        输出: [1,3,12,0,0]
         */
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        // 打印结果数组
        System.out.print("处理后的数组: ");
        for (int num : nums) {
            System.out.print(num + " ");
        }


    }
    public static void moveZeroes(int[] nums){
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
        }

        // 将剩余的部分填充为0
        for (int i = slow; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
