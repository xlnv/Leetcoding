package Solving_2;

public class Solution02 {

    public static void main(String[] args) {
        int[] nums ={1,3,5,6};
        int target = 2;
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
