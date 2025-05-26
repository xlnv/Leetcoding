package HashTable;

import java.util.HashSet;
import java.util.Set;

public class Solution04 {
    public static void main(String[] args) {
        //编写一个算法来判断一个数 n 是不是快乐数。
        //
        //「快乐数」定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，
        // 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。如果 可以变为  1，那么这个数就是快乐数。
        //
        //如果 n 是快乐数就返回 True ；不是，则返回 False 。
        System.out.println(isHappy(19));

    }

    public static boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        // 当n不等于1且没有进入循环时继续
        while (n != 1 && !seen.contains(n)) {
            seen.add(n);        // 将当前数字加入集合
            n = getNext(n);     // 计算下一个数字
        }

        // 判断是否因为得到1而退出循环
        return n == 1;
    }


    // 辅助方法：计算数字各位平方和
    private static int getNext(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;  // 获取最后一位数字
            sum += digit * digit; // 平方后累加
            n /= 10;             // 去掉最后一位
        }
        return sum;
    }
}
