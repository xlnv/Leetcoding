package BinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution05_8 {
    public static void main(String[] args) {
        //104.二叉树的最大深度
        //给定一个二叉树，找出其最大深度。
        //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        //说明: 叶子节点是指没有子节点的节点。
        // 树结构：
        //        1
        //       / \
        //      2   3
        //     /     \
        //    4       7
        //             \
        //              9

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(9);

        int res = maxDepth01(root);
        System.out.println(res); //4
    }

    public static int maxDepth01(TreeNode root) {
        if(root ==null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
            depth++; //每遍历完一层，深度加 1
        }
        return depth;
    }
    public static int maxDepth02(TreeNode root) {
        // 递归终止条件：如果当前节点为空，返回深度0
        if (root == null) {
            return 0;
        }

        // 递归计算左子树的最大深度
        int leftDepth = maxDepth02(root.left);
        // 递归计算右子树的最大深度
        int rightDepth = maxDepth02(root.right);

        // 当前节点的最大深度等于左右子树中较大的深度+1（当前节点本身）
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
