package a01Array;

public class LeetCode_367 {
    public static void main(String[] args) {
        /*
        给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
        完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
        不能使用任何内置的库函数，如  sqrt 。
         */
        System.out.println(isPerfectSquare(5));
        System.out.println(isPerfectSquare(15));
        System.out.println(isPerfectSquare(25));

    }

    public static boolean isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            // 需要确保 mid * mid == num 以避免整除的误导
            if (mid * mid == num) {
                return true;
            } else if (mid > num / mid) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
