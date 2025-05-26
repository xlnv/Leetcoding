package HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution03 {
    //题意：给定两个数组，编写一个函数来计算它们的交集。
    //输入:nums1=[1,2,2,1]，nums2 =[2,2]输出:[2]
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6};
        int[] nums2 = {1, 2, 4, 4, 5, 6};
        int[] result = intersection(nums1, nums2);
        System.out.println(Arrays.toString(result));

    }
    public static int[] intersection(int[] nums1, int[] nums2) {
        // 使用HashSet来存储第一个数组的元素，自动去重
        Set<Integer> set = new HashSet<>();
        for (int num : nums1) {
            set.add(num);
        }

        // 使用另一个HashSet来存储结果，避免重复
        Set<Integer> resultSet = new HashSet<>();
        for (int num : nums2) {
            // 如果第二个数组中的元素存在于第一个数组中，则加入结果集
            if (set.contains(num)) {
                resultSet.add(num);
            }
        }

        // 将结果集转换为数组返回
        int[] result = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            result[index++] = num;
        }
        return result;

    }


}
