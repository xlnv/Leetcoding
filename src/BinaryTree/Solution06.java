package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution06 {
    public static void main(String[] args) {
        //226.翻转二叉树
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
        TreeNode treeNode = invertTree(root);
        printTree(treeNode);
    }

    public static TreeNode invertTree(TreeNode root) {
        // 如果根节点为空，直接返回null
        if (root == null) {
            return null;
        }

        // 递归翻转左子树
        TreeNode left = invertTree(root.left);
        // 递归翻转右子树
        TreeNode right = invertTree(root.right);

        // 交换当前节点的左右子树
        root.left = right;
        root.right = left;

        // 返回翻转后的根节点
        return root;
    }
    public static TreeNode invertTree02(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // 根节点入队

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll(); // 取出当前节点

            //交换左右子树
            TreeNode temp = node.left;
            node.left =node.right;
            node.right =temp;

            // 如果左子树非空，加入队列
            if (node.left != null) {
                queue.offer(node.left);
            }
            // 如果右子树非空，加入队列
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return root;

    }
    // 辅助方法：层序遍历打印二叉树
    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("空树");
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                System.out.print(node.val + " ");
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            System.out.println();
        }
    }
}
