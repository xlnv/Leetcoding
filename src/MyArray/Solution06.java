package MyArray;

import java.util.Scanner;

public class Solution06 {
    public static void main(String[] args) {
        //区间和
        /*
        前缀和在涉及计算区间和的问题时非常有用！
        前缀和的思路其实很简单，我给大家举个例子很容易就懂了。
        例如，我们要统计 vec[i] 这个数组上的区间和。
        我们先做累加，即 p[i] 表示 下标 0 到 i 的 vec[i] 累加 之和。
         */
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入整数数组 Array 的长度 n");
        int n = sc.nextInt();
        int[] arr = new int[n];
        int[] p = new int[n];

        int presum = 0;
        System.out.println("请输入数组的元素:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            presum = presum + arr[i];
            p[i] = presum;
        }
        System.out.println("请输入区间 (输入非整数结束):");
        while (sc.hasNextInt()) {

            int a = sc.nextInt();
            int b = sc.nextInt();
            int sum;
            if (a == 0) {
                sum = p[b];
            } else {
                sum = p[b] - p[a - 1];
            }
            System.out.println("区间和: " + sum);
        }

        sc.close();
    }
}
