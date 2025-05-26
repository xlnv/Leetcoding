package HashTable;

import java.util.*;

public class Solution02_1 {
    public static void main(String[] args) {
        //给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
        //
        //字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

        //示例 1:
        //
        //输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        //输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        // 创建一个哈希表，键是排序后的字符串，值是对应的字母异位词列表
        Map<String, List<String>> map = new HashMap<>();

        // 遍历输入字符串数组
        for (String str : strs) {
            // 将字符串转换为字符数组，便于排序
            char[] charArray = str.toCharArray();
            // 对字符数组进行排序，这样字母异位词排序后会得到相同的字符串
            Arrays.sort(charArray);
            // 将排序后的字符数组转换回字符串，作为哈希表的键
            String sortedStr = new String(charArray);

            // 如果哈希表中不存在这个键，就创建一个新的列表
            if (!map.containsKey(sortedStr)) {
                map.put(sortedStr, new ArrayList<>());
            }
            // 将原始字符串添加到对应的列表中
            map.get(sortedStr).add(str);
        }

        // 将哈希表中的所有值（即分组后的字母异位词列表）转换为List返回
        return new ArrayList<>(map.values());
    }
    

}
