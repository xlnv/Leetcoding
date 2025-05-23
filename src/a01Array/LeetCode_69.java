package a01Array;

public class LeetCode_69 {
    public static void main(String[] args) {
        /*
        给你一个非负整数 x ，计算并返回 x 的算术平方根 。
        由于返回类型是整数，结果只保留整数部分 ，小数部分将被舍去 。
        注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。
         */

        int result = mySqrt(15);
        System.out.println(result);
    }

    public static int mySqrt(int x) {
        //如果 x 是 0，直接返回 0，因为 0 的平方根是 0。
        if (x == 0) {return 0;
        }

        int left = 1;
        int right = x;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (mid  == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                right = mid -1;
            }else {
                left = mid + 1;
            }
        }
        //返回结果：
        //当 left 超过 right 时，说明查找范围已经缩小到一个位置，
        // 此时 right 是最后一个满足 mid <= x / mid 的 mid。
        return right;
    }
}
