package String;

import java.util.Scanner;

public class Solution05 {
    public static void main(String[] args) {
        //字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
        //例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
        //输入：输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
        //输出：输出共一行，为进行了右旋转操作后的字符串。
        //样例输入：
        // 2
        // abcdefg
        //样例输出：fgabcde
        Scanner scanner = new Scanner(System.in);
        int k = scanner.nextInt();
        scanner.nextLine();
        String s = scanner.nextLine();
        char[] arr = s.toCharArray();
        int n = arr.length;

        k = k % n;  // 处理 k > n 的情况
        // 1.整体反转
        reverse(arr, 0, n - 1);
        // 2.反转前k个字符
        reverse(arr, 0, k - 1);
        // 3.反转剩下的n-k个字符
        reverse(arr, k, n - 1);

        System.out.println(new String(arr));

    }

    public static void reverse(char[] arr, int start, int end) {
        // 反转字符数组的指定区间
        while (start < end) {
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
