package Array;

public class Solution02 {

    public static void main(String[] args) {
        //35.搜索插入位置
        //给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
        int[] nums ={1,3,5,6};
        int target = 7;
        int result = search(nums, target);
        System.out.println(result);


    }
    public static int search(int[] nums,int target){
        int left = 0;
        int right = nums.length - 1;
        while (left<=right){
            int mid = left + (right - left) / 2;
            if(nums[mid]>target){
                right = mid-1;
            }else if (nums[mid]<target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return right + 1;
    }


}
