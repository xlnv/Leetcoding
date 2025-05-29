package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution02_1 {
    public static void main(String[] args) {
        // 前序遍历·递归·LC144_二叉树的前序遍历
        // 树结构：
        //        1
        //       / \
        //      2   3
        //     / \ / \
        //  null  5 6 7

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 调用前序遍历方法
        List<Integer> result = preorderTraversal(root);
        System.out.println(result); // 输出:[1,2,4,5,3,6,7]

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        preorder(root, result);
        return result;
    }

    public static void preorder(TreeNode root, List<Integer> result) {
        // 递归终止条件：当前节点为空
        if (root == null) {
            return;
        }
        // 前序遍历步骤：
        // 1. 访问当前节点（将节点值加入结果列表）
        result.add(root.val);
        // 2. 递归遍历左子树
        preorder(root.left, result);
        // 3. 递归遍历右子树
        preorder(root.right, result);
    }
}
