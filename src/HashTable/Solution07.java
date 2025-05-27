package HashTable;

public class Solution07 {
    public static void main(String[] args) {
        //给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，判断第一个字符串 ransom 能不能由第二个字符串 magazines 里面的字符构成。如果可以构成，返回 true ；否则返回 false。
        //
        //(题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。杂志字符串中的每个字符只能在赎金信字符串中使用一次。)
        //
        //注意：
        //
        //你可以假设两个字符串均只含有小写字母。
        //
        //canConstruct("a", "b") -> false
        //canConstruct("aa", "ab") -> false
        String r = "aa";
        String m = "ab";
        System.out.println(canConstruct(r,m));
    }

    public static boolean canConstruct(String ransomNote, String magazine) {
        // 创建一个长度为26的数组来记录每个字母的出现次数（因为只有小写字母）
        int[] count = new int[26];

        // 遍历杂志字符串，统计每个字符出现的次数
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++; // 'a'对应索引0，'b'对应索引1，以此类推
        }

        // 遍历赎金信字符串，检查每个字符是否在杂志中有足够的数量
        for (char c : ransomNote.toCharArray()) {
            // 如果当前字符的计数为0，说明杂志中没有足够的该字符
            if (count[c - 'a'] == 0) {
                return false;
            }
            // 使用一个字符后，对应的计数减1
            count[c - 'a']--;
        }

        // 如果所有字符都满足条件，返回true
        return true;

    }
}
