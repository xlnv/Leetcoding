package Test100;

import java.util.HashMap;
import java.util.Map;

public class test12 {
    public static void main(String[] args) {
        /*
        给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖t所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。

        注意：
        对于 t 中重复字符，我们寻找的子字符串中该字符数量必须不少于 t 中该字符数量。
        如果 s 中存在这样的子串，我们保证它是唯一的答案。
        示例 1：
        输入：s = "ADOBECODEBANC", t = "ABC"
        输出："BANC"
        解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
         */

    }
    public static String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        // 记录 t 中的字符频率
        Map<Character, Integer> need = new HashMap<>();
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }
        // 滑动窗口
        Map<Character, Integer> window = new HashMap<>();
        int left = 0, right = 0;
        int valid = 0;  // 符合条件的字符个数
        int start = 0, minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            // 当前右侧窗口字符
            char c = s.charAt(right);
            right++;

            // 更新窗口
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 尝试收缩窗口
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < minLength) {
                    start = left;
                    minLength = right - left;
                }

                // 当前左侧窗口字符
                char d = s.charAt(left);
                left++;

                // 更新窗口
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);


    }
}
