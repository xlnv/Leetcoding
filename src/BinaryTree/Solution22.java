package BinaryTree;

public class Solution22 {
    public static void main(String[] args) {
        //700.二叉搜索树中的搜索

        //给定二叉搜索树（BST）的根节点和一个值。 你需要在BST中找到节点值等于给定值的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 NULL。
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        // 如果当前节点为空，说明没找到，返回null
        if (root == null) {
            return null;
        }

        // 如果当前节点的值等于目标值，返回当前节点
        if (root.val == val) {
            return root;
        }

        // 由于是二叉搜索树，可以根据值的大小决定搜索方向
        // 如果目标值小于当前节点值，在左子树中搜索
        if (val < root.val) {
            return searchBST(root.left, val);
        }
        // 否则在右子树中搜索
        else {
            return searchBST(root.right, val);
        }
    }
}
