package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution23 {
    public static void main(String[] args) {
        //98.验证二叉搜索树
        //给定一个二叉树，判断其是否是一个有效的二叉搜索树。
        //假设一个二叉搜索树具有如下特征：
        //节点的左子树只包含小于当前节点的数。
        //节点的右子树只包含大于当前节点的数。
        //所有左子树和右子树自身必须也是二叉搜索树。
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

        System.out.println(isValidBST(root)); // true
    }

    private static Integer prev = null;

    public static boolean isValidBST(TreeNode root) {
        return inOrder(root);

    }

    public static boolean inOrder(TreeNode root) {
        if (root == null) {
            return true; // 空节点不影响BST性质
        }

        // 1. 先遍历左子树
        if (!inOrder(root.left)) {
            return false; // 如果左子树不是BST，直接返回false
        }

        // 2. 处理当前节点
        if (prev != null && root.val <= prev) {
            return false;// 当前值不大于前一个值，不是BST
        }
        prev = root.val;// 更新前一个值为当前值

        // 3. 最后遍历右子树
        return inOrder(root.right);
    }



}
