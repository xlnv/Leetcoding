package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution09 {
    public static void main(String[] args) {
        //104.二叉树的最大深度
        //给定一个二叉树，找出其最大深度。
        //
        //二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
        //
        //说明: 叶子节点是指没有子节点的节点。
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
        int depthMax = depthMax(root);
        int res = maxDepth(root);
        System.out.println(depthMax);//4
        System.out.println(res); // 4

    }

    public static int depthMax(TreeNode root) {
        if(root == null)return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int depth = 0;
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // 当前层的节点数
            depth++; // 每遍历完一层，深度加 1

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll(); // 出队

                // 将左右子节点入队（如果存在）
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }

        return depth;
    }
    public static int maxDepth(TreeNode root) {
        // 递归终止条件：如果当前节点为空，返回深度0
        if (root == null) {
            return 0;
        }

        // 递归计算左子树的最大深度
        int leftDepth = maxDepth(root.left);
        // 递归计算右子树的最大深度
        int rightDepth = maxDepth(root.right);

        // 当前节点的最大深度等于左右子树中较大的深度+1（当前节点本身）
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
