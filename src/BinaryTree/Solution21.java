package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution21 {
    public static void main(String[] args) {
        //617.合并二叉树
        //给定两个二叉树，想象当你将它们中的一个覆盖到另一个上时，两个二叉树的一些节点便会重叠。
        //你需要将他们合并为一个新的二叉树。合并的规则是如果两个节点
    }

    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        // 如果两棵树当前节点都为空，返回null
        if (root1 == null && root2 == null) {
            return null;
        }

        // 如果其中一棵树的当前节点为空，返回另一棵树的当前节点
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        // 创建新节点，值为两个节点值的和
        TreeNode mergedNode = new TreeNode(root1.val + root2.val);

        // 递归合并左子树
        mergedNode.left = mergeTrees(root1.left, root2.left);
        // 递归合并右子树
        mergedNode.right = mergeTrees(root1.right, root2.right);

        return mergedNode;
    }

    public static TreeNode mergeTrees02(TreeNode root1, TreeNode root2) {
        // 处理特殊情况
        if (root1 == null) return root2;
        if (root2 == null) return root1;

        // 使用队列来进行BFS遍历
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root1);
        queue.offer(root2);

        // 从root1开始合并（也可以新建一棵树）
        TreeNode mergedRoot = root1;

        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();

            // 合并节点值
            node1.val += node2.val;

            // 处理左子节点
            if (node1.left != null && node2.left != null) {
                queue.offer(node1.left);
                queue.offer(node2.left);
            } else if (node1.left == null) {
                // 如果node1的左子节点为空，直接使用node2的左子节点
                node1.left = node2.left;
            }
            // 如果node2.left为空，不需要做任何操作

            // 处理右子节点
            if (node1.right != null && node2.right != null) {
                queue.offer(node1.right);
                queue.offer(node2.right);
            } else if (node1.right == null) {
                // 如果node1的右子节点为空，直接使用node2的右子节点
                node1.right = node2.right;
            }
            // 如果node2.right为空，不需要做任何操作
        }

        return mergedRoot;
    }
}
