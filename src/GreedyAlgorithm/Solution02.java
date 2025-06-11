package GreedyAlgorithm;

import java.util.Arrays;

/*
455.分发饼干
力扣题目链接(opens new window)

假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。

对每个孩子 i，都有一个胃口值  g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；
并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，
这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。

示例  1:

输入: g = [1,2,3], s = [1,1]
输出: 1 解释:你有三个孩子和两块小饼干，3 个孩子的胃口值分别是：1,2,3。虽然你有两块小饼干，
由于他们的尺寸都是 1，你只能让胃口值是 1 的孩子满足。所以你应该输出 1。
 */
public class Solution02 {
    public static void main(String[] args) {
        int[] g = {10, 9, 8, 7};
        int[] s = {10, 9, 8, 7};
        Solution02 solution02 = new Solution02();
        System.out.println(solution02.findContentChildren(g, s)); // 1
    }

    public int findContentChildren(int[] g, int[] s) {
        // 首先对两个数组进行排序
        Arrays.sort(g);
        Arrays.sort(s);

        int child = 0; // 指向孩子的指针
        int cookie = 0; // 指向饼干的指针
        int count = 0;  // 记录满足孩子的数量

        // 当还有孩子和饼干未处理时继续循环
        while (child < g.length && cookie < s.length) {
            // 如果当前饼干可以满足当前孩子
            if (s[cookie] >= g[child]) {
                count++;    // 满足孩子数加1
                child++;    // 处理下一个孩子
                cookie++;   // 这块饼干已经被分配，处理下一块
            } else {
                // 当前饼干太小，无法满足当前孩子，尝试更大的饼干
                cookie++;
            }
        }

        return count;
    }

}
