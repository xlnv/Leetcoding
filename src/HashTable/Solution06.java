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
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B) {
                int sumAB = a + b;
                map.put(sumAB, map.getOrDefault(sumAB, 0) + 1);
            }
        }
        int count = 0;

        for (int c : C) {
            for (int d : D) {
                int sumCD = c + d;
                count += map.getOrDefault(-sumCD, 0);
            }
        }
        return count;
    }
}
