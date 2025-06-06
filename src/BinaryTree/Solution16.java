package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution16 {
    public static void main(String[] args) {
        //513.找树左下角的值
        //给定一个二叉树，在树的最后一行找到最左边的值。
        // 树结构：
        //        1
        //       / \
        //      4   3
        //     / \
        //    5  7


        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        int res = findBottomLeftValue(root);
        System.out.println(res); // 5
    }

    public static int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                if (i == 0) {
                    res = node.val;
                }

                if(node.left != null) queue.offer(node.left);
                if(node.right != null) queue.offer(node.right);
            }
        }
        return res;
    }



}
