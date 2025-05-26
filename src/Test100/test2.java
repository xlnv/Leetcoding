package Test100;

public class test2 {
    public static void main(String[] args) {
        /*
        给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。

        示例 1: 输入: s = "anagram", t = "nagaram" 输出: true

        示例 2: 输入: s = "rat", t = "car" 输出: false

        说明: 你可以假设字符串只包含小写字母。
         */
        String s = "anagram";
        String t = "nagraam";
        System.out.println(isAnagram(s, t));

    }
    public static boolean isAnagram(String s, String t){
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i) - 'a']++;
        }
        for (int j = 0; j < t.length(); j++) {
            arr[t.charAt(j)- 'a']--;

        }

        for (int i : arr) {
            if(i != 0){
                return  false;
            }
        }
        return true;
    }
}
