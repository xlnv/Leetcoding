package MyArray;

public class Solution02 {
    public static void main(String[] args) {
        /*
        给你一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，
        并返回移除后数组的新长度。元素的顺序可以改变。
        你不需要考虑数组中超出新长度后面的元素。
         */
        int[] nums = {1, 2, 3, 4, 2, 5};
        int val = 2;
        int result = remove(nums, val);

        System.out.println(result);

    }

    public static int remove(int[] nums, int val) {
        /*
        双指针法
        双指针法(快慢指针法): 通过一个快指针和慢指针在一个for循环下完成两个for循环的工作。
        定义快慢指针
        快指针:寻找新数组的元素，新数组就是不含有目标元素的数组
        慢指针:指向更新新数组下标的位置
         */
        int slow = 0;
        for (int fast = 0; fast < nums.length; fast++) {
            if (nums[fast] != val) {
                nums[slow] = nums[fast];
                slow++;
            }

        }
        //返回删除后的新数组的大小
        return slow;
    }

}
