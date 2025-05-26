package Test100;

import java.util.HashSet;
import java.util.Set;


public class test3 {
    public static void main(String[] args) {
        /*
    给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
    请你设计并实现时间复杂度为 O(n) 的算法解决此问题。

    示例 1：
    输入：nums = [100,4,200,1,3,2]
    输出：4
    解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
     */
        int[] nums = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));

    }



    public static int longestConsecutive(int[] nums) {
        if(nums.length == 0 || nums == null){
            return 0;
        }
        int res = 0;    // 记录最长连续序列的长度
        Set<Integer> numSet = new HashSet<>();  // 记录所有的数值
        for(int num: nums){
            numSet.add(num);    // 将数组中的值加入哈希表中
        }
        int seqLen;     //记录连续序列长度
        for (Integer num : numSet) {
            if(!numSet.contains(num -1)){
                seqLen = 1;
                while (numSet.contains(num + 1)){       // 不断查找连续序列，直到num的下一个数不存在于数组中
                    num++;
                    seqLen++;
                    res = Math.max(res,seqLen);      // 更新最长连续序列长度
                }
            }
        }
        return res;

        }

}
