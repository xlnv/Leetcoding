package Test100;

public class test5 {
    public static void main(String[] args) {
        /*
        给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。

        找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。

        返回容器可以储存的最大水量。

        说明：你不能倾斜容器。
        输入：[1,8,6,2,5,4,8,3,7]
        输出：49
        解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49
         */
        int[] height = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(height));

    }

    public static int maxArea(int[] height) {
        int left = 0;      //左指针
        int right = height.length - 1;   //右指针
        int maxArea = 0;   //最大水量

        while (left < right) {
            //当前容器的高度由两者中较短的决定
            int minHeight = Math.min(height[left], height[right]);
            //容器的宽度
            int width = right - left;
            //计算当前容器的面积
            int currentArea = minHeight * width;
            //更新最大水量
            maxArea = Math.max(maxArea,currentArea);
            //移动较短的一边，尝试找更大的容器
            if (height[left] < height[right]) {
                left++;     //移动左指针
            }else {
                right--;    //移动右指针
            }
        }
        return maxArea;

    }
}
