package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution05_6 {
    public static void main(String[] args) {
        //515.在每个树行中找最大值
        // 树结构：
        //        1
        //       / \
        //      4   3
        //     / \ / \
        //    5  7 6  2

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(2);

        List<Integer> res = largestValues(root);
        System.out.println(res);
    }

    public static List<Integer> largestValues(TreeNode root) {
        // 初始化结果列表
        List<Integer> result = new ArrayList<>();

        // 如果树为空，直接返回空列表
        if (root == null) {
            return result;
        }

        // 使用队列进行BFS遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 将根节点加入队列

        while (!queue.isEmpty()) {
            // 获取当前层的节点数量
            int levelSize = queue.size();
            // 初始化当前层的最大值
            int levelMax = Integer.MIN_VALUE;

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // 取出队首节点
                // 更新当前层的最大值
                levelMax = Math.max(levelMax, node.val);

                // 将当前节点的左右子节点加入队列（如果存在）
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            // 将当前层的最大值加入结果列表
            result.add(levelMax);
        }

        return result;
    }

}
