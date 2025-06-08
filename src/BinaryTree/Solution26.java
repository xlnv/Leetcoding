package BinaryTree;

public class Solution26 {
    public static void main(String[] args) {
        //236. 二叉树的最近公共祖先
        //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
        //百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，
        //最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
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

    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return left != null ? left : right;
    }
}
