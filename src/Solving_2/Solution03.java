package Solving_2;

public class Solution03 {
    public static void main(String[] args) {
        //给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
        //
        //如果数组中不存在目标值 target，返回 [-1, -1]。
        int[] nums = {5, 7, 7, 8, 8, 10};
        int target = 8;



    }
    public static int[] searchRang(int[] nums,int target){
        int leftBorder = searchLeftBorder(nums, target);
        int rightBorder = searchRightBorder(nums, target);
        //情况1 target 在数组范围的右边或者左边，例如数组{3, 4, 5}，target为2或者数组{3, 4, 5},target为6，此时应该返回{-1, -1}
        if (leftBorder == -2 || rightBorder == -2) {
            return new int[]{-1, -1};
        }
        //情况三：target 在数组范围中，且数组中存在target，例如数组{3,6,7},target为6，此时应该返回{1, 1}
        if (rightBorder - leftBorder > 1) {
            return new int[]{leftBorder + 1, rightBorder - 1};
        }
        //情况二：target 在数组范围中，且数组中不存在target，例如数组{3,6,7},target为5，此时应该返回{-1, -1}
        return new int[]{-1, -1};


    }
    public static int searchRightBorder(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int rightBorder = -2;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if(nums[mid] > target){
                right = mid -1;
            }else {
                left= mid + 1;
                rightBorder = left;
            }
        }
        return rightBorder;
    }

    public static int searchLeftBorder(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        int leftBorder = -2;
        while (left<= right){
            int mid = left + (right - left) / 2;
            if(nums[mid]>= target){
                right = mid -1;
                leftBorder = right;
            }else {
                left = mid +1;
            }
        }
        return leftBorder;
    }
}
