package Backtrack;

import java.util.ArrayList;
import java.util.List;

/*
131.分割回文串
力扣题目链接(opens new window)

给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。

返回 s 所有可能的分割方案。

示例: 输入: "aab" 输出: [ ["aa","b"], ["a","a","b"] ]
 */
public class Solution09 {
    public static void main(String[] args) {
        Solution09 solution09 = new Solution09();
        String s = "aab";
        System.out.println(solution09.partition(s));

    }

    public  List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    // 回溯函数
    private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        // 如果起始位置已经到达字符串末尾，说明当前分割方案有效，加入结果
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        // 尝试从start开始的所有可能的分割点
        for (int end = start ; end < s.length(); end++) {
            String substring = s.substring(start, end+1);
            // 如果当前子串是回文串，则继续递归处理剩余部分
            if (isPalindrome(substring)) {
                current.add(substring); // 加入当前分割方案
                backtrack(s, end + 1, current, result); // 递归处理剩余部分
                current.remove(current.size() - 1); // 回溯，移除当前子串
            }
        }
    }

    // 判断字符串是否是回文串
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }


}
