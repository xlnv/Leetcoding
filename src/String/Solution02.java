package String;

public class Solution02 {
    public static void main(String[] args) {
        //给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
        //
        //如果剩余字符少于 k 个，则将剩余字符全部反转。
        //
        //如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
        //
        //示例:
        //
        //输入: s = "abcdefg", k = 2
        //输出: "bacdfeg"
        String s = "abcdefgh";
        int k = 2;
        System.out.println(reverseStr(s, k));
    }

    public static String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        for(int i = 0;i < ch.length;i += 2 * k){
            int start = i;
            // 判断尾数够不够k个来取决end指针的位置
            int end = Math.min(ch.length - 1,start + k - 1);
            while(start < end){

                char temp = ch[start];
                ch[start] = ch[end];
                ch[end] = temp;

                start++;
                end--;
            }
        }
        return new String(ch);
    }
}
