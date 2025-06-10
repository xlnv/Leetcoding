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
        System.out.println(letterCombinations("23")); // [ad, ae, af, bd, be, bf, cd, ce, cf]

    }

    //设置全局列表存储最后的结果
    private static  List<String> result = new ArrayList<>();
    private static StringBuilder  path = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return result;
        }

        //初始对应所有的数字，为了直接对应2-9，新增了两个无效的字符串""
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        backtrack(digits, numString, 0);

        return result;

    }

    public static void backtrack(String digits, String[] numString, int index) {
        //递归遍历结果判断
        if (index == digits.length()) {
            result.add(path.toString());
            return;
        }

        String str = numString[digits.charAt(index) - '0']; //str 表示当前num对应的字符串

        for (int i = 0; i < str.length(); i++) {

            path.append(str.charAt(i));
            //递归，处理下一层
            backtrack(digits, numString, index + 1);
            //剔除末尾的继续尝试
            path.deleteCharAt(path.length()-1);
        }
    }


}
