package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution05_3 {
    public static void main(String[] args) {
        //199.二叉树的右视图
        //给定一棵二叉树，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。
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

        List<Integer> lists = rightSideView(root);
        System.out.println(lists); // [1,3,7]

    }

    private static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        // 使用队列进行BFS遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            System.out.println(levelSize);

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // 如果是当前层的最后一个节点，加入结果列表
                if (i == levelSize - 1) {
                    result.add(node.val);
                }

                // 将左右子节点加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return result;
    }


}
