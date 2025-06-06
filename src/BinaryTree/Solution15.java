package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution15 {
    public static void main(String[] args) {
        //404.左叶子之和
        //计算给定二叉树的所有左叶子之和。
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
        int res = sumOfLeftLeaves02(root);
        System.out.println(res); //5+6=11
    }

    public static int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null) {
            sum += root.left.val;
        }
        sum += sumOfLeftLeaves(root.left);
        sum += sumOfLeftLeaves(root.right);
        return sum;
    }

    public static int sumOfLeftLeaves02(TreeNode root) {
        int sum = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return 0;
        }
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int res = 0; res < levelSize; res++) {
                TreeNode node = queue.poll();

                if (node.left != null) {// 左节点不为空
                    queue.offer(node.left);
                    if (node.left.left == null && node.left.right == null) {// 左叶子节点
                        sum += node.left.val;
                    }
                }

                if(node.right != null) queue.offer(node.right);
            }
        }
        return sum;
    }
}
