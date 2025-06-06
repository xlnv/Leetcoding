package BinaryTree;

import java.util.ArrayList;
import java.util.List;

public class Solution13 {
    public static void main(String[] args) {
        //257. 二叉树的所有路径
        //给定一个二叉树，返回所有从根节点到叶子节点的路径。
        //说明: 叶子节点是指没有子节点的节点。
        // 树结构：
        //        1
        //       / \
        //      4   3
        //     / \ / \
        //    5  7 6

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        System.out.println(binaryTreePaths(root)); // [1->4->5, 1->4->7, 1->3->6]

    }

    public static List<String> binaryTreePaths(TreeNode root) {
        // 用于存储所有路径的结果列表
        List<String> paths = new ArrayList<>();
        // 如果根节点为空，直接返回空列表
        if (root == null) {
            return paths;
        }
        // 开始深度优先搜索, 前序遍历（中左右）
        dfs(root, "", paths);
        return paths;
    }

    public static void dfs(TreeNode node, String path, List<String> paths) {
        // 将当前节点的值添加到路径中
        path += node.val;

        // 如果是叶子节点（没有左右子节点），将当前路径添加到结果列表中
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        // 如果有左子节点，递归处理左子树
        if (node.left != null) {
            dfs(node.left, path + "->", paths);
        }

        // 如果有右子节点，递归处理右子树
        if (node.right != null) {
            dfs(node.right, path + "->", paths);
        }
    }



}
