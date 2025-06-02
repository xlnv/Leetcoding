package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution10 {
    public static void main(String[] args) {
        //111.二叉树的最小深度
        // 树结构：
        //        1
        //       / \
        //      4   3
        //     / \ / \
        //    5  7 6  2
        //             \
        //              8
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(2);
        root.right.right.right = new TreeNode(8);
        int res = minDepth(root);
        System.out.println(res); // 3
    }

    public static int minDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 1;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();

                // 如果当前节点是叶子节点，直接返回当前深度
                if (node.left == null && node.right == null) return depth;

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
