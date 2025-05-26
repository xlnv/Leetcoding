package Test100;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class test9 {
    public static void main(String[] args) {
        /*
        给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词的子串
        返回这些子串的起始索引。不考虑答案输出的顺序。

        示例 1:

        输入: s = "cbaebabacd", p = "abc"
        输出: [0,6]
        解释:
        起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
         */
        String s= "cbaebabacd",p = "abc";
        List<Integer> result = findAnagrams(s, p);
        System.out.println(result);
    }

    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if (s.length() < p.length()) return result;

        // 定义需要的字符频率表
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 初始化字符频率表
        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0; // 用来记录窗口中满足条件的字符种类数

        while (right < s.length()) {
            // c 是将移入窗口的字符
            char c = s.charAt(right);
            right++; // 右移窗口

            // 更新窗口内的数据
            if (need.containsKey(c)) {
                //如果当前字符 c 在 need 中，更新 window 中该字符的频率。
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    //当 window 中字符 c 的频率和 need 中相同，则 valid++，表示该字符在窗口内已经满足要求。
                    valid++;
                }
            }

            /*** debug 输出的位置 ***/
            System.out.printf("window: [%d, %d)\n", left, right);
            /********************/

            // 判断左侧窗口是否要收缩
            while (right - left == p.length()) {
                // 如果找到符合条件的子串，添加起始索引
                if (valid == need.size()) {
                    result.add(left);
                }

                // d 是将移出窗口的字符
                char d = s.charAt(left);
                left++; // 左移窗口

                // 更新窗口内的数据
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        //首先判断 d 是否是一个已经满足条件的字符，如果是，valid--。然后减少 window 中该字符的频率。
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return result;
    }


}
