package String;

public class Solution03 {
    public static void main(String[] args) {
        //给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
        //
        //例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
        //
        //对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"
        //
        //输入：一个字符串 s,s 仅包含小写字母和数字字符。
        //
        //输出：打印一个新的字符串，其中每个数字字符都被替换为了number
        //
        //样例输入：a1b2c3
        //
        //样例输出：anumberbnumbercnumber
        //
        //数据范围：1 <= s.length < 10000
        String s = "a1b2c3";
        System.out.println(replaceDigits(s));

    }

    public static String replaceDigits(String s) {
        // 使用StringBuilder来高效构建字符串
        StringBuilder result = new StringBuilder();
        // 遍历输入字符串的每个字符
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 判断当前字符是否是数字
            if (Character.isDigit(c)) {
                // 如果是数字，则追加"number"
                result.append("number");
            } else {
                // 如果不是数字，保持原样
                result.append(c);
            }
        }
        // 将StringBuilder转换为String并返回
        return result.toString();
    }
}
