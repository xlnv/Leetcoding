package Backtrack;

import java.util.ArrayList;
import java.util.List;

/*
93.复原IP地址
力扣题目链接(opens new window)

给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。

有效的 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。

例如："0.1.2.201" 和 "192.168.1.1" 是 有效的 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效的 IP 地址。

示例 1：

输入：s = "25525511135"
输出：["255.255.11.135","255.255.111.35"]
 */
public class Solution10 {
    public static void main(String[] args) {
        Solution10  solution10 = new Solution10();
        String s = "25525511135";
        String s1 = "101023";
        System.out.println(solution10.restoreIpAddresses(s)); // [255.255.11.135, 255.255.111.35]
        System.out.println(solution10.restoreIpAddresses(s1)); // [1.0.10.23, 1.0.102.3, 10.1.0.23, 10.10.2.3, 101.0.2.3]

    }

    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(String s, int start, List<String> path, List<String> result) {
        // 如果已经找到4个部分
        if (path.size() == 4) {
            // 如果字符串刚好用完，说明找到了一个有效IP
            if (start == s.length()) {
                result.add(String.join(".", path));
            }
            return;
        }

        // 尝试取1位、2位或3位
        for (int len = 1; len <= 3; len++) {
            // 确保不会越界
            if (start + len > s.length()) {
                break;
            }

            String segment = s.substring(start, start + len);

            // 检查是否有效
            if (isValid(segment)) {
                path.add(segment); // 选择
                //start + len 表示处理完当前分割段后，下一个分割段的起始位置
                backtrack(s, start + len, path, result); // 递归
                path.remove(path.size() - 1); // 回溯
            }
        }
    }

    private boolean isValid(String segment) {
        // 长度大于1且以0开头无效
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        // 转换为数字检查范围
        int num = Integer.parseInt(segment);
        return num >= 0 && num <= 255;
    }
}
