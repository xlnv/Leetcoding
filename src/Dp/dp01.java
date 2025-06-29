package Dp;

import java.util.Arrays;
import java.util.Scanner;

public class dp01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取物品数量和背包容量
        int n = scanner.nextInt();       // 物品数量
        int bagweight = scanner.nextInt(); // 背包最大承重

        // 初始化物品重量和价值数组
        int[] weight = new int[n];  // 每个物品的重量
        int[] value = new int[n];   // 每个物品的价值

        // 读取每个物品的重量
        for (int i = 0; i < n; ++i) {
            weight[i] = scanner.nextInt();
        }
        // 读取每个物品的价值
        for (int j = 0; j < n; ++j) {
            value[j] = scanner.nextInt();
        }
        System.out.println(Arrays.toString(weight));
        System.out.println(Arrays.toString(value));

        // 创建动态规划表，dp[i][j]表示前i个物品在容量j时的最大价值
        int[][] dp = new int[n][bagweight + 1]; // +1是因为要考虑容量0到bagweight

        // 初始化第一行：只考虑第一个物品的情况
        for (int j = weight[0]; j <= bagweight; j++) {
            // 当背包容量足够放下第一个物品时，最大价值就是第一个物品的价值
            dp[0][j] = value[0];
        }
        System.out.println(Arrays.deepToString(dp));

        // 动态规划填表过程
        for (int i = 1; i < n; i++) {          // 从第二个物品开始考虑
            for (int j = 0; j <= bagweight; j++) { // 考虑背包容量从0到最大
                if (j < weight[i]) {
                    // 当前物品重量超过当前背包容量j，不能放入
                    // 最大价值等于不考虑当前物品时的价值
                    dp[i][j] = dp[i - 1][j];
                } else {
                    // 当前物品可以放入背包
                    // 比较放入和不放入当前物品两种情况，取较大值
                    // 放入：dp[i-1][j-weight[i]] + value[i]
                    // 不放入：dp[i-1][j]
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        System.out.println(Arrays.deepToString(dp));

        // 输出结果：考虑所有物品(n个)，背包容量为bagweight时的最大价值
        System.out.println(dp[n - 1][bagweight]);
    }

}
