package Array;

import java.util.Arrays;

public class Solution06 {
    public static void main(String[] args) {
        //59.螺旋矩阵II
        //给定一个正整数 n，生成一个包含 1 到 n^2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
        //
        //示例:
        //
        //输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
        int n = 3;
        int[][] result = generateMatrix(n);
        System.out.println(Arrays.deepToString(result));

    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0, startY = 0; // 定义每一圈起点
        int offset = 1;
        int loop = 1 ; //定义圈数
        int i,j;  // i表示行， j表示列
        int count = 1;

        while (loop <= n / 2) {
            //顶部，
            for (j = startY; j < n - offset; j++) {
                nums[startX][j] = count++;
            }
            //右列
            for (i=startX; i < n - offset; i++) {
                nums[i][j] = count++;
            }
            //底部
            for (; j > startY; j--) {
                nums[i][j] = count++;
            }
            //左列
            for (; i > startX; i--) {
                nums[i][j] = count++;
            }
            startX++;
            startY++;
            loop++;
            offset++;
        }
        if (n % 2 == 1) {
            nums[startX][startY] = count;
        }
        return nums;

    }

}
