package Backtrack;
/*
7.电话号码的字母组合
力扣题目链接(opens new window)

给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。

给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。


示例:

输入："23"
输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
说明：尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */

import java.util.ArrayList;
import java.util.List;

public class Solution05 {
    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));

    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return result;
        }

        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        backtrack(digits, 0, new StringBuilder(), numString, result);
        return result;

    }

    public static void backtrack(String digits, int index,StringBuilder path, String[] numString, List<String> result) {
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = numString[digit - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits,index+1,path,numString,result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
