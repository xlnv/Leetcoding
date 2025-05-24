package Test100;


import java.util.*;

public class test1 {
    public static void main(String[] args) {
        /*
        给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。

        字母异位词 是由重新排列源单词的所有字母得到的一个新单词。

        示例 1:
        输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
        输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
         */
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> lists = groupAnagrams(strs);
        System.out.println(lists);

    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        //边界调节判断
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        //创建map集合存储字符串
        Map<String, List<String>> map = new HashMap<>();

        //遍历字符串，把字符串变成字符数组
        char[] chars;
        for (int i = 0; i < strs.length; i++) {
            //转成字符数组
            chars = strs[i].toCharArray();
            //对字符数组进行排序
            Arrays.sort(chars);
           //将排序之后是字符数组再转成字符串
            String keyStr = String.valueOf(chars);
            //判断map集合中有没有这个键，
            //如果没有说明还没有出现和这个字符串一样的字母异词
            //要创建一个新的list存储它
            if (!map.containsKey(keyStr)) {
                //如果不存在，就创建一个新list，把原来旧的字符串存储进去
                map.put(keyStr,new ArrayList<>());
                List<String> list = map.get(keyStr);
                //把字符串添加进去
                list.add(strs[i]);
            }else {
                //如果存在则直接在list中添加旧的字符串
                map.get(keyStr).add(strs[i]);
            }
        }
        //最后返回map集合当中由值组成的list列表
        return new ArrayList<>(map.values());


    }


}
