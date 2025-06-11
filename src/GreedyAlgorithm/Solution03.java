package GreedyAlgorithm;
/*
376. 摆动序列
力扣题目链接(opens new window)

如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。
第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。

例如， [1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3)  是正负交替出现的。
相反, [1,4,7,2,5]  和  [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。

给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 */
public class Solution03 {
    public static void main(String[] args) {
        int[] nums = {1, 7, 4, 9, 2, 5};
        Solution03 solution03 = new Solution03();
        System.out.println(solution03.wiggleMaxLength(nums));
        System.out.println(solution03.wiggleMaxLength02(nums));

    }

    public int wiggleMaxLength(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }

        int up = 1; // 最后一个摆动是上升的最长子序列长度
        int down = 1; // 最后一个摆动是下降的最长子序列长度

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) {
                up = down + 1; // 上升摆动，只能在下降摆动后接上
            } else if (nums[i] < nums[i - 1]) {
                down = up + 1; // 下降摆动，只能在上升摆动后接上
            }
            // 相等的情况不处理，up和down保持不变
        }

        return Math.max(up, down);
    }

    public int wiggleMaxLength02(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        //当前差值
        int curDiff = 0;
        //上一个差值
        int preDiff = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //得到当前差值
            curDiff = nums[i] - nums[i - 1];
            //如果当前差值和上一个差值为一正一负
            //等于0的情况表示初始时的preDiff
            if ((curDiff > 0 && preDiff <= 0) || (curDiff < 0 && preDiff >= 0)) {
                count++;
                preDiff = curDiff;
            }
        }
        return count;
    }
}
