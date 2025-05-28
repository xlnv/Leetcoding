package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution09 {
    public static void main(String[] args) {
        //题意：给定一个包含 n 个整数的数组 nums 和一个目标值 target，
        // 判断 nums 中是否存在四个元素 a，b，c 和 d ，使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
        //注意：
        //
        //答案中不可以包含重复的四元组。
        //
        //示例： 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。 满足要求的四元组集合为： [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> res = fourSum(nums, target);
        System.out.println(res);


    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        // 如果数组长度小于4，直接返回空结果
        if (nums == null || nums.length < 4) {
            return result;
        }

        // 先对数组进行排序，方便后续处理重复元素和双指针移动
        Arrays.sort(nums);
        int n = nums.length;

        // 外层循环固定第一个数
        for (int i = 0; i < n - 3; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            // 内层循环固定第二个数
            for (int j = i + 1; j < n - 2; j++) {
                // 跳过重复的第二个数
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                // 使用双指针寻找剩下的两个数
                int left = j + 1;
                int right = n - 1;

                while (left < right) {
                    // 计算当前四个数的和
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];

                    if (sum == target) {
                        // 找到符合条件的四元组，加入结果列表
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));

                        // 跳过重复的第三个数
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        // 跳过重复的第四个数
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        // 移动指针寻找下一组可能的解
                        left++;
                        right--;
                    } else if (sum < target) {
                        // 和太小，左指针右移
                        left++;
                    } else {
                        // 和太大，右指针左移
                        right--;
                    }
                }
            }
        }
        return result;
    }

}
