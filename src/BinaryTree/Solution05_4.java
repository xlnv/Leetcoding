package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution05_4 {
    public static void main(String[] args) {
        //637.二叉树的层平均值
        //给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
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

        List<Double> lists = averageOfLevels(root);
        System.out.println(lists); // [1.0,2.5,5.5]
    }
    public static List<Double> averageOfLevels(TreeNode root) {
        // 使用队列来实现广度优先搜索(BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        // 存储最终结果的列表
        List<Double> result = new ArrayList<>();

        // 如果根节点不为空，将其加入队列
        if (root != null) {
            queue.offer(root);
        }

        // 当队列不为空时循环处理
        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int levelSize = queue.size();
            // 当前层节点值的总和
            double levelSum = 0;

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                // 从队列中取出节点
                TreeNode node = queue.poll();
                // 累加节点值
                levelSum += node.val;

                // 如果左子节点不为空，加入队列
                if (node.left != null) {
                    queue.offer(node.left);
                }
                // 如果右子节点不为空，加入队列
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 计算当前层的平均值并加入结果列表
            result.add(levelSum / levelSize);
        }

        return result;
    }


}
