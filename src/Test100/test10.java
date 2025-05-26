package Test100;

import java.util.HashMap;

public class test10 {
    public static void main(String[] args) {
        /*
        给你一个整数数组 nums 和一个整数 k ，请你统计并返回该数组中和为k的子数组的个数 。
        子数组是数组中元素的连续非空序列。
        示例 1：
        输入：nums = [1,1,1], k = 2
        输出：2
         */
        int[] nums = {1, 1, 1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }
    public static int subarraySum(int[] nums, int k) {
        // 前缀和哈希表，记录前缀和出现的次数
        HashMap<Integer,Integer> hs = new HashMap<>();
        //初始状态，前缀和为0出现是次数为1
        hs.put(0,1);

        int currentSum = 0;  // 当前前缀和
        int count = 0;       // 记录满足条件的子数组个数

        for (int num : nums) {
             currentSum += num;// 计算当前的前缀和

            if(hs.containsKey(currentSum - k)){
                count += hs.get(currentSum -k);// 找到满足条件的子数组
            }
            // 更新前缀和哈希表
            hs.put(currentSum,hs.getOrDefault(currentSum,0) +1);
        }


        return count; // 返回满足条件的子数组个数

    }
}
