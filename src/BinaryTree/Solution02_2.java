package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution02_2 {
    public static void main(String[] args) {
        // 中序遍历·递归·LC94_二叉树的中序遍历
        // 树结构：
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //    4  5 6  7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<Integer> res = inorderTraversal(root);
        System.out.println(res);

    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inorder(root, result);
        return result;
    }

    public static void inorder(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inorder(node.left, result);// 1.递归遍历左子树
        result.add(node.val);// 2.访问根节点
        inorder(node.right, result);// 3.递归遍历右子树
    }
}
