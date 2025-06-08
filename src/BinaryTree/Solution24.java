package BinaryTree;

public class Solution24 {
    public static void main(String[] args) {
        //530.二叉搜索树的最小绝对差
        //给你一棵所有节点为非负值的二叉搜索树，请你计算树中任意两节点的差的绝对值的最小值。
        // 树结构：
        //        4
        //       / \
        //      2   7
        //     / \
        //    1  3

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        System.out.println(getMinimumDifference(root)); // 1
    }

    private static int prev = -1; // 初始化-1，表示还没有访问任何节点
    private static int  minDiff = Integer.MAX_VALUE;

    public static int getMinimumDifference(TreeNode root) {
        inorder(root);
        return minDiff;
    }

    public static void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // 递归处理左子树
        inorder(node.left);

        // 处理当前节点
        if (prev != -1) {
            // 计算当前节点与前一个节点的差值
            int diff = node.val - prev;
            // 更新最小差值
            minDiff = Math.min(minDiff, diff);
        }
        // 更新前一个节点为当前节点
        prev = node.val;

        // 递归处理右子树
        inorder(node.right);
    }

}
