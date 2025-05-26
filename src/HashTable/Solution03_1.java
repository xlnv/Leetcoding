package HashTable;

import java.util.*;

public class Solution03_1 {
    public static void main(String[] args) {
        //给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。
        // 返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。
        // 可以不考虑输出结果的顺序。

        //示例 1：
        //
        //输入：nums1 = [1,2,2,1], nums2 = [2,2]
        //输出：[2,2]
        int[] nums1 = {1, 1, 1, 12, 1, 3};
        int[] nums2 = {1, 1, 2, 3};
        int[] result = intersect(nums1, nums2);
        System.out.println(Arrays.toString(result));
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        //使用哈希表来统计nums中每个数字出现的次数
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        //使用列表来动态存储结果
        List<Integer> resultList = new ArrayList<>();
        for (int num : nums2) {
            // 如果当前数字存在于map中且计数大于0
            if (map.containsKey(num) && map.get(num) > 0) {
                // 添加到结果列表
                resultList.add(num);
                //减少该数字次数
                map.put(num, map.get(num) - 1);
            }

        }
        //将列表转为数字返回
        int[] result = new int[resultList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}
