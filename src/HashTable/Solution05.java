package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution05 {
    public static void main(String[] args) {
        //给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
        //
        //你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
        //
        //示例:
        //
        //给定 nums = [2, 7, 11, 15], target = 9
        //
        //因为 nums[0] + nums[1] = 2 + 7 = 9
        //
        //所以返回 [0, 1]
        int[] nums = {2, 7, 11, 15};
        int target = 13;
        int[] res = twoSum(nums, target);
        System.out.println(Arrays.toString(res));

    }

    public static int[] twoSum(int[] nums, int target) {
        // 创建一个哈希表来存储数组元素和对应的索引
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组中的每个元素
        for (int i = 0; i < nums.length; i++) {
            // 计算当前元素与目标值的差值
            int complement = target - nums[i];

            // 检查哈希表中是否已存在这个差值
            if (map.containsKey(complement)) {
                // 如果存在，返回当前元素的索引和差值的索引
                return new int[] { map.get(complement), i };
            }

            // 将当前元素及其索引存入哈希表
            map.put(nums[i], i);
        }
        return null;
    }

}
