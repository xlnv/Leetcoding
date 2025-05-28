package String;

public class Solution07 {
    public static void main(String[] args) {
        //给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。
        //示例 1:
        //输入: "abab"
        //输出: True
        //解释: 可由子字符串 "ab" 重复两次构成。
        String s1 = "abab";
        String s2 = "abcab";
        System.out.println(repeatedSubstringPattern(s1));
        System.out.println(repeatedSubstringPattern(s2));
    }

    public static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int[] next = new int[len];
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }

        if (next[len - 1] > 0 && len % (len - next[len - 1]) == 0) {
            return true;
        } else {
            return false;
        }
    }

}
