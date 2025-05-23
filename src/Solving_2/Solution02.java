package Solving_2;

public class Solution02 {

    public static void main(String[] args) {
        //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
        //
        //如果数组中不存在目标值 target，返回 [-1, -1]。
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
