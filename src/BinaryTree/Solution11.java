package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution11 {
    public static void main(String[] args) {
        //222.完全二叉树的节点个数
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

        int res = countNode(root);
        System.out.println(res);    //6

    }

    public static int countNode(TreeNode root) {
        if (root == null) {
            return 0; // 如果根节点为空，返回0
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 将根节点加入队列
        int count = 0; // 初始化节点计数器

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 取出队首节点
            count++; // 统计节点数

            // 将左子节点加入队列
            if (node.left != null) {
                queue.offer(node.left);
            }

            // 将右子节点加入队列
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return count; // 返回节点总数
    }
}
