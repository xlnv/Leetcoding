package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution05_1 {
    public static void main(String[] args) {
        //102.二叉树的层序遍历
        //给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
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

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists); //[[1], [2, 3], [4, 5, 6, 7]]

    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        // 初始化结果列表，用于存储每层的节点值
        List<List<Integer>> result = new ArrayList<>();

        // 如果根节点为空，直接返回空列表
        if (root == null) {
            return result;
        }

        // 使用队列辅助进行层序遍历
        Queue<TreeNode> queue = new LinkedList<>();
        // 将根节点加入队列
        queue.offer(root);

        // 当队列不为空时循环
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int levelSize = queue.size();
            // 当前层的节点值列表
            List<Integer> currentLevel = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                // 取出队列头部的节点
                TreeNode currentNode = queue.poll();
                // 将节点值加入当前层列表
                currentLevel.add(currentNode.val);

                // 如果左子节点不为空，加入队列
                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                // 如果右子节点不为空，加入队列
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }

            // 将当前层列表加入结果列表
            result.add(currentLevel);
        }

        // 返回最终的层序遍历结果
        return result;
    }

}
