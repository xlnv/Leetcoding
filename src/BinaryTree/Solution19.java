package BinaryTree;

public class Solution19 {
    public static void main(String[] args) {
        //654.最大二叉树
        //给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
        //二叉树的根是数组中的最大元素。
        //左子树是通过数组中最大值左边部分构造出的最大二叉树。
        //右子树是通过数组中最大值右边部分构造出的最大二叉树。
        //通过给定的数组构建最大二叉树，并且输出这个树的根节点。
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private static TreeNode buildTree(int[] nums, int start, int end) {
        if (start > end) {// 没有元素了
            return null;
        }

        if (end - start == 1) {// 只有一个元素
            return new TreeNode(nums[start]);
        }

        // 找到当前子数组的最大值及其索引
        int maxIndex = start;
        int maxVal = nums[maxIndex];

        for (int i = start + 1; i < end; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(nums[maxVal]);

        // 递归构建左子树（最大值左边的子数组）
        root.left = buildTree(nums,start, maxIndex - 1);
        // 递归构建右子树（最大值右边的子数组）
        root.right = buildTree(nums, maxIndex + 1, end);
        return root;
    }


}
