package Array;

import java.util.Scanner;

public class Solution07 {
    public static void main(String[] args) {
        //58. 区间和
        //给定一个整数数组 Array，请计算该数组在每个指定区间内元素的总和。
        //
        //输入描述
        //
        //第一行输入为整数数组 Array 的长度 n，接下来 n 行，每行一个整数，表示数组的元素。随后的输入为需要计算总和的区间，直至文件结束。
        //
        //输出描述
        //
        //输出每个指定区间内元素的总和。
        //前缀和
        Scanner sc = new Scanner(System.in);
        System.out.println("输入数组长度：");
        int n = sc.nextInt();
        int[] vec = new int[n];
        int[] p = new int[n];

        int presum = 0;
        System.out.println("输入数组元素");
        for (int i = 0; i < n; i++) {
            vec[i] = sc.nextInt();
            presum += vec[i];
            p[i] = presum;
        }
        System.out.println("输入区间");
        while (sc.hasNextInt()){

            int a  = sc.nextInt();
            int b = sc.nextInt();

            int sum = 0;
            if (a == 0) {
                sum = p[b];
            }else {
                sum = p[b] - p[a - 1];
            }
            System.out.println(sum);
        }

    }

}
