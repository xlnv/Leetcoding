package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Solution06 {
    public static void main(String[] args) {
        //给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[l] = 0。
        //
        //为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。
        // 所有整数的范围在 -2^28 到 2^28 - 1 之间，最终结果不会超过 2^31 - 1 。
        //
        //例如:
        //
        //输入:
        //
        //A = [ 1, 2]
        //B = [-2,-1]
        //C = [-1, 2]
        //D = [ 0, 2]
        //输出:
        //
        //2
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        int res = fourSumCount(A, B, C, D);
        System.out.println(res);

    }

    public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        // 使用哈希表存储A和B数组元素两两之和的出现次数
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组A和B，计算所有可能的a+b的和，并记录每个和出现的次数
        for (int a : A) {
            for (int b : B) {
                int sumAB = a + b;
                // 将当前和存入哈希表，如果已存在则增加计数，否则初始化为1
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }

        int count = 0; // 统计满足条件的元组数量

        // 遍历数组C和D，计算所有可能的c+d的和
        for (int c : C) {
            for (int d : D) {
                int sumCD = c + d;
                // 检查哈希表中是否存在-(c+d)，如果存在则说明有对应的a+b使得a+b+c+d=0
                // 将对应的出现次数累加到count中
                count += map.getOrDefault(-sumCD, 0);
            }
        }

        return count;
    }
}
