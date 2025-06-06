package BinaryTree;

public class Solution12 {
    public static void main(String[] args) {
        //110.平衡二叉树
        //给定一个二叉树，判断它是否是高度平衡的二叉树。
        //本题中，一棵高度平衡二叉树定义为：一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
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
        System.out.println(isBalanced(root)); // true
    }

    public static boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }

    public static int height(TreeNode node) {
        if(node == null) return 0;

        int leftHeight = height(node.left);
        if (leftHeight == -1) {
            return -1;
        }
        int rightHeight = height((node.right));
        if (rightHeight == -1) {
            return  -1;
        }
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight,rightHeight)+1;

    }
}
