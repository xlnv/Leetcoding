package BinaryTree;

public class Solution08 {
    public static void main(String[] args) {
        //101. 对称二叉树
        //给定一个二叉树，检查它是否是镜像对称的。
        // 树结构：
        //        1
        //       / \
        //      3   3
        //     / \ / \
        //    5  7 7  5

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        boolean res = isSymmetric(root);
        System.out.println(res);
    }

    public static boolean isSymmetric(TreeNode root) {
        // 如果根节点为空，直接返回true（空树被认为是对称的）
        if(root==null) return true;
        // 比较左右子树是否对称
        return isMirror(root.left, root.right);


    }

    public static boolean isMirror(TreeNode left, TreeNode right) {
        // 如果两个节点都为空，认为是对称的
        if (left == null && right == null) {
            return true;
        }
        // 如果只有一个节点为空，不对称
        if (left == null || right == null) {
            return false;
        }
        //检查当前节点的值是否相等
        if (left.val != right.val) {
            return false;
        }
        // 并且递归检查左子树的左节点和右子树的右节点，
        // 以及左子树的右节点和右子树的左节点是否对称
        // 比较外侧
        boolean out = isMirror(left.left, right.right);
        // 比较内侧
        boolean in  = isMirror(left.right, right.left);
        return out && in;

    }
}
