package BinaryTree;

public class Solution17 {
    public static void main(String[] args) {
        //112. 路径总和
        //给定一个二叉树和一个目标和，判断该树中是否存在根节点到叶子节点的路径，这条路径上所有节点值相加等于目标和。
        //说明: 叶子节点是指没有子节点的节点。
        // 树结构：
        //        1
        //       / \
        //      4   3
        //     / \
        //    5  7


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(hasPathSum(root, 8)); // false
        System.out.println(hasPathSum(root, 12)); // true
    }

    public static boolean hasPathSum(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null) {
            return root.val == target;
        }

        return hasPathSum(root.left,target-root.val) || hasPathSum(root.right,target-root.val);
    }
}
