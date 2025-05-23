package Solving_2;

public class Solution01 {

    public static void main(String[] args) {
        //给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
        //关键词：有序数组、无重复元素
        int[] num1 = {-1,0,3,5,9,12};
        int target1 = 9;
        int result = search2(num1, target1);
        System.out.println(result);


    }
    public static  int search1(int[] num , int target){
        if(target<num[0] || target>num[num.length-1] ){
            return -1;
        }
        int left = 0;
        int right = num.length -1;
        while (left<=right){
            int mid = left + (right-left)/2;
            if(num[mid]>target){
                right = mid -1;
            }else if(num[mid]<target){
                left = mid + 1;
            }else {
                return mid;
            }
        }
        return -1;
    }
    public static int search2(int[]num , int target){
        if(target<num[0]||target>num[num.length-1]){
            return -1;
        }
        int left = 0;
        int right = num.length;
        while (left<right){
            int mid = left + (right-left)/2;
            if(num[mid]==target){
                return mid;
            } else if(num[mid]>target){
                right = mid;
            }else{
                left = mid + 1;
            }

        }
        return -1;
    }

}
