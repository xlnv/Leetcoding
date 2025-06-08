package BinaryTree;

public class Solution28 {
    public static void main(String[] args) {
        //235. 二叉搜索树的最近公共祖先
        //给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。

    }
    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       TreeNode current = root;
        while (current != null) {
            // 如果当前节点的值大于 p 和 q 的值，LCA在左子树
            if (current.val > p.val && current.val > q.val) {
                current = current.left;
            }
            // 如果当前节点的值小于 p 和 q 的值，LCA在右子树
            else if (current.val < p.val && current.val < q.val) {
                current = current.right;
            }
            // 否则，当前节点就是LCA
            else {
                return current;
            }
        }

        // 理论上不会走到这里，因为题目保证 p 和 q 在树中
        return null;
    }
}
