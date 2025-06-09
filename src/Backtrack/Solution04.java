package Backtrack;

/*
216.组合总和III
找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
说明：
所有数字都是正整数。
解集不能包含重复的组合。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution04 {
    public static void main(String[] args) {
        System.out.println(combinationSum3(3, 7)); // [[1, 2, 4]]

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), 1, k, n);
        return result;

    }

    public static void backtrack(List<List<Integer>> result, List<Integer> tempList, int start, int k, int remaining) {
        // 终止条件：当前组合的长度等于k且剩余目标和为0
        if (tempList.size() == k && remaining == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // 剪枝：如果剩余目标和小于0或组合长度超过k，直接返回
        if (remaining < 0 || tempList.size() > k) {
            return;
        }
        // 从start开始遍历数字1到9
        for (int i = start; i <= 9; i++) {
            tempList.add(i);
            // 递归调用，更新剩余目标和为remaining - i，start为i + 1
            backtrack(result, tempList, i + 1, k, remaining - i);
            // 回溯，移除最后一个数字
            tempList.remove(tempList.size() - 1);
        }
    }
}
