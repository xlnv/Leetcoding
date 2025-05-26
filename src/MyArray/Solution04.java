package MyArray;

public class Solution04 {
    public static void main(String[] args) {
        /*
        给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。
        如果不存在符合条件的子数组，返回 0。
         */
        int[] nums = {2, 3, 1, 2, 4, 3};
        int s = 9;
        System.out.println(minSubArrayLen(s, nums));
    }


    public static int minSubArrayLen(int s, int[] nums) {
        /*
        滑动窗口法
        在本题中实现滑动窗口，主要确定如下三点：
        窗口内是什么？
        如何移动窗口的起始位置？
        如何移动窗口的结束位置？
        窗口就是 满足其和 ≥ s 的长度最小的连续子数组。
        窗口的起始位置如何移动：如果当前窗口的值大于等于s了，窗口就要向前移动了（也就是该缩小了）。
        窗口的结束位置如何移动：窗口的结束位置就是遍历数组的指针，也就是for循环里的索引
     */
        //定义窗口起始索引
        int start = 0;
        // 定义变量表示滑动窗口数值之和
        int sum = 0;
        //开始将滑动窗口的长度定义为无穷大
        int result = Integer.MAX_VALUE;

        //end表示窗口结束索引
        for (int end = 0; end < nums.length; end++) {
            sum = sum + nums[end];

            // 当窗口内的和大于等于 s 时，尝试缩小窗口
            while (sum >= s) {
                // 更新结果，取当前窗口长度和之前记录的最小长度中的较小值
                result = Math.min(result, end - start + 1);
                // 窗口左边界右移，并更新窗口的和
                sum = sum - nums[start++];
            }
        }

        // 如果 result 没有更新，表示没有找到符合条件的子数组，返回 0
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}
