package Test100;

public class test15 {
    public static void main(String[] args) {
        /*
        给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
        示例 1:
        输入: nums = [1,2,3,4,5,6,7], k = 3
        输出: [5,6,7,1,2,3,4]
        解释:
        向右轮转 1 步: [7,1,2,3,4,5,6]
        向右轮转 2 步: [6,7,1,2,3,4,5]
        向右轮转 3 步: [5,6,7,1,2,3,4]
         */
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int k = 3;

        // 调用 rotate 方法
        rotate(nums, k);

        // 打印结果
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        // 1. 获取数组长度
        int n = nums.length;
        //2.处理k,避免冗余
        k = k % n;
        //3.反转整个数组
        reverse(nums,0,n-1);
        //4.反转前k个元素
        reverse(nums,0,k-1);
        //5.反转后n-k个元素
        reverse(nums,k,n-1);
    }

    // 反转数组中的元素
    private static void reverse(int[] nums, int left, int right) {
        while (left < right) {
            //交换left和right位置元素
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            //移动指针
            left++;
            right--;

        }
    }
}
