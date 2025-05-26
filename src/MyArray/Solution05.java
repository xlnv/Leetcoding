package MyArray;

public class Solution05 {
    public static void main(String[] args) {
        int[][] result = generateMatrix(3);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result.length; j++) {
                System.out.print(result[i][j]+ " ");
            }
            System.out.println();

        }
    }

    public static int[][] generateMatrix(int n) {
        int[][] nums = new int[n][n];
        int startX = 0;
        int startY = 0; // 每一圈的起始点
        int offset = 1;
        int count = 1; // 矩阵中需要填写的数字
        int loop = 1; //记录当前的圈数
        int i, j; //j 代表列, i 代表行;
        while (loop <= n / 2) {
            // 顶部
            // 左闭右开，所以判断循环结束时， j 不能等于 n - offset
            for (j = startX; j < n - offset; j++) {
                nums[startX][j] = count++;
            }

            //右列
            // 左闭右开，所以判断循环结束时， i 不能等于 n - offset
            for (i = startY; i < n - offset; i++) {
                nums[i][j] = count++;
            }

            // 底部
            // 左闭右开，所以判断循环结束时， j != startX
            for (; j > startX; j--){

                nums[i][j] = count++;
            }

            //左列
            // 左闭右开，所以判断循环结束时， i != startY
            for (; i > startY; i--) {
                nums[i][j] = count++;
            }

            startX++;
            startY++;
            offset++;
            loop++;
        }
        if (n % 2 == 1) { // n 为奇数时，单独处理矩阵中心的值
            nums[startX][startY] = count;
        }
        return nums;
    }


}

