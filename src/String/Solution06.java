package String;

public class Solution06 {
    public static void main(String[] args) {
        //给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
        //
        //示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
        String haystack = "hello";
        String needle =   "lo";
        System.out.println(strStr(haystack, needle));
    }

    public static int strStr(String haystack, String needle) {
        //处理needle为空情况
        if(needle.length()==0)return 0;

        // 1.计算next数组
        int[] next = new int[needle.length()];
        getNext(next, needle);

        // 2. KMP匹配过程
        int j = 0; // needle 的指针
        for (int i = 0; i < haystack.length(); i++) {
            // 如果当前字符不匹配，j 回退到next[j-1]
            while (j > 0 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            // 如果匹配， j前进
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            // 如果j到达neddle末尾，匹配成功
            if (j == needle.length()) {
                return i - needle.length() + 1;
            }

        }
        return -1;
    }

    public static void getNext(int[] next, String s) {
        int j = 0; // 前缀末尾位置
        next[0] = 0; // next[0] 初始化为 0
        for (int i = 1; i < s.length(); i++) {
            // 如果 s[i] != s[j]，j 回退到 next[j-1]
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            // 如果 s[i] == s[j]，j 前进
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            // 记录 next[i] = j
            next[i] = j;
        }
    }


}
