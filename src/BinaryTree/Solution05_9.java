package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution05_9 {
    public static void main(String[] args) {
        //111.二叉树的最小深度
        //给定一个二叉树，找出其最小深度。
        //最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
        //说明：叶子节点是指没有子节点的节点。
        //说明: 叶子节点是指没有子节点的节点。
        // 树结构：
        //        1
        //       / \
        //      2   3
        //           \
        //            7
        //             \
        //              9

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(9);
        int res = minDepth(root);
        System.out.println(res);//2
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
                if(node.left ==null && node.right ==null) return depth;

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++;
        }
        return depth;
    }
}
