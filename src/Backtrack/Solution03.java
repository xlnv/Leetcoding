package Backtrack;

import java.util.ArrayList;
import java.util.List;

public class Solution03 {
    //77. 组合优化
    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    //示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]

    public static void main(String[] args) {
        List<List<Integer>> res = combine(10, 5);
        System.out.println(res);

    }
    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, n, k);
        return result;

    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int n, int k) {
        // 如果当前组合的大小等于k，将其加入结果列表
        if (tempList.size() == k) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // 剪枝优化：剩余的数字不足以填满组合的剩余位置
        // 剩余的数字数量：n - i + 1
        // 需要的数字数量：k - tempList.size()
        // 所以循环条件改为：i <= n - (k - tempList.size()) + 1
        for (int i = start; i <= n - (k - tempList.size()) + 1; i++) {
            // 将当前数字加入组合
            tempList.add(i);
            // 递归调用，从i+1开始，避免重复
            backtrack(result, tempList, i + 1, n, k);
            // 回溯，移除最后一个数字，尝试其他可能性
            tempList.remove(tempList.size() - 1);
        }
    }
}
