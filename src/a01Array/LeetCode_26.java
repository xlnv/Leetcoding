package a01Array;

public class LeetCode_26 {
    public static void main(String[] args) {
        /*
        给你一个非严格递增排列 的数组nums，请你原地删除重复出现的元素，使每个元素只出现一次 ，
        返回删除后数组的新长度。元素的相对顺序应该保持一致 。然后返回nums中唯一元素的个数。
        考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
        更改数组nums ，使nums的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。
        nums 的其余元素与 nums 的大小不重要。
        返回 k 。
         */
        int[] arr = {0,0,1,1,1,2,2,3,3,4,5};
        int result = removeDuplicates(arr);
        System.out.println(result);
    }

    public static int removeDuplicates(int[] nums){
        int slow = 0;
        for (int fast = 1; fast < nums.length; fast++) {
            if(nums[fast] != nums[slow]){
                slow++;
                nums[slow] = nums[fast];
            }
        }
        //slow` 是索引，所以返回 `slow + 1` 是元素的数量
        return slow + 1;
    }
}
