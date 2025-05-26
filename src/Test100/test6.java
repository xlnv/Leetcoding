package Test100;

import java.util.*;

public class test6 {
    public static void main(String[] args) {
        /*
        给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]]
        满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。
        请你返回所有和为 0 且不重复的三元组。

        注意：答案中不可以包含重复的三元组。
        示例 1：

        输入：nums = [-1,0,1,2,-1,-4]
        输出：[[-1,-1,2],[-1,0,1]]
        解释：
        nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
        nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
        nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
        不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
        注意，输出的顺序和三元组的顺序并不重要。
         */
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        /*
        排序：首先对数组进行排序，这样可以更方便地避免重复并使用双指针。
        遍历：固定一个数字 nums[i]，然后使用双指针法来寻找其他两个数字，使得它们的和等于 -nums[i]。
        双指针：定义两个指针，左指针从 i+1 开始，右指针从数组末尾开始，根据当前三元组的和来移动指针：
        如果和小于 0，移动左指针向右增加和。
        如果和大于 0，移动右指针向左减少和。
        如果和等于 0，找到一个三元组，并且移动指针去寻找下一个可能的三元组。
        去重：在遍历和双指针的过程中，需要跳过重复的数字。
         */
        List<List<Integer>> list = new ArrayList<>();
        //排除特殊情况
        if (nums == null || nums.length < 3) {
            return list;
        }
        Arrays.sort(nums);  //对数组进行排序
        //遍历数组
        for (int i = 0; i < nums.length - 2; i++) {
            //去掉重复数字
            if (i > 0 && nums[i] == nums[i - 1])
            {
                continue;
            }
            int left = i + 1;   //左指针从i的后一位开始
            int right = nums.length - 1; //右指针从数组最后一位开始
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    //和小于0 ，移动左指针向右增加和。
                    left++;
                } else if (sum > 0) {
                    //如果和大于 0，移动右指针向左减少和。
                    right--;
                } else {
                    //如果和等于 0，找到一个三元组，并且移动指针去寻找下一个可能的三元组。
                    list.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    //去重：在遍历和双指针的过程中，需要跳过重复的数字。
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right++;
                    }
                }
                left++;
                right--;
            }


        }
        return list;

    }
}

