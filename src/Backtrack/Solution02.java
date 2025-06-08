package Backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution02 {
    //77. 组合
    //给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
    //示例: 输入: n = 4, k = 2 输出: [ [2,4], [3,4], [2,3], [1,2], [1,3], [1,4], ]

    public static void main(String[] args) {
        List<List<Integer>> res = combine(4, 2);
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
        // 从start到n遍历所有可能的数字
        for (int i = start; i <= n; i++) {
            // 将当前数字加入组合
            tempList.add(i);
            // 递归调用，从i+1开始，避免重复
            backtrack(result, tempList, i + 1, n, k);
            // 回溯，移除最后一个数字，尝试其他可能性
            tempList.remove(tempList.size() - 1);
        }
    }
}
