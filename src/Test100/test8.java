package Test100;

import java.util.HashMap;

public class test8 {
    public static void main(String[] args) {
        /*
        给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度。

        示例 1:

        输入: s = "abcabcbb"
        输出: 3
        解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
         */
        String s = "abcabcbb";
        int result = lengthOfLongestSubstring(s);
        System.out.println(result);

    }

    public static int lengthOfLongestSubstring(String s) {
        //定义一个集合来存储无重复字符
        HashMap<Character, Integer> hs = new HashMap<>();
        int left = 0;   //初始化滑动窗口左边界
        int maxLen = 0; //初始化最长字串长度

        //遍历字符串
        for (int right = 0; right < s.length(); right++) {
            //获取当前字符
            char currentChar = s.charAt(right);
            //判断当前字符是否在集合中
            if (hs.containsKey(currentChar)) {
                //如果存在，说明遇到重复字符，需要更新滑动窗口的左边界到该字符的下一位
                left = Math.max(hs.get(currentChar) + 1, left);
            }
            //不存在不用管,更新当前字符的位置
            hs.put(currentChar, right);
            //更新最长字串长度
            maxLen = Math.max(right - left + 1, maxLen);

        }
        return maxLen;


    }

}

