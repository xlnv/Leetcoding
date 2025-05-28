package String;

import java.util.ArrayList;
import java.util.List;

public class Solution04 {
    public static void main(String[] args) {
        //给定一个字符串，逐个翻转字符串中的每个单词。
        //
        //示例 1：
        //输入: "the sky is blue"
        //输出: "blue is sky the"
        String  s = "the sky is blue";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        // 1. 去除首尾空格
        int left = 0, right = s.length() - 1;
        while (left <= right && s.charAt(left) == ' ') left++;
        while (left <= right && s.charAt(right) == ' ') right--;

        // 2. 分割单词
        List<String> words = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        for (int i = left; i <= right; i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                word.append(c);
            } else {
                if (word.length() > 0) {
                    words.add(word.toString());
                    word.setLength(0); // 清空StringBuilder
                }
            }
        }
        // 添加最后一个单词
        if (word.length() > 0) {
            words.add(word.toString());
        }

        // 3. 反转单词顺序
        reverseList(words);

        // 4. 拼接结果字符串
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            result.append(words.get(i));
            if (i != words.size() - 1) {
                result.append(" ");
            }
        }

        return result.toString();

    }

    private static void reverseList(List<String> list) {
        int left = 0, right = list.size() - 1;
        while (left < right) {
            String temp = list.get(left);
            list.set(left, list.get(right));
            list.set(right, temp);
            left++;
            right--;
        }
    }
}
