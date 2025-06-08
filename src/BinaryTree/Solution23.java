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
        //        5
        //       / \
        //      4   7
        //     / \ / \
        //    3  5 6  8

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(8);
        System.out.println(isValidBST(root)); // false
    }

    public static boolean isValidBST(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrder(root, result);
        //二叉搜索树的中序遍历结果应该是一个严格递增的序列
        for (int i = 0; i < result.size(); i++) {
            if (result.get(i) >= result.get(i + 1)) {
                return false;
            }
        }
        return true;

    }

    public static void inOrder(TreeNode root, List<Integer> result) {
        //中序遍历
        if (root == null) {
            return;
        }
        inOrder(root.left,result);
        result.add(root.val);
        inOrder(root.right, result);
    }


}
