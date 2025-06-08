package BinaryTree;

public class Solution30 {
    //450.删除二叉搜索树中的节点
    //给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
    //并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
    public static void main(String[] args) {
        //        4
        //       / \
        //      2   7
        //     / \
        //    1   3
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        TreeNode node = deleteNode(root, 2);
        System.out.println(node.levelOrderTraversal()); // [4, 3, 7, 1]

    }

    public static TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        // 如果当前节点的值大于key，去左子树删除
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        // 如果当前节点的值小于key，去右子树删除
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        // 找到要删除的节点
        else {
            // 情况1：节点是叶子节点
            if (root.left == null && root.right == null) {
                return null; //返回NULL为根节点

            }
            // 情况2：节点只有一个子节点
            else if (root.left == null) {
                return root.right; // 返回右孩子为根节点
            } else if (root.right == null) {
                return root.left; //返回左孩子为根节点
            }
            // 情况3：节点有两个子节点
            else {
                // 找到右子树的最小节点（后继节点）
                TreeNode successor = findMin(root.right);
                // 用后继节点的值替换当前节点的值
                root.val = successor.val;
                // 递归删除后继节点
                root.right = deleteNode(root.right, successor.val);
            }
        }
        return root;
    }

    // 辅助方法：找到子树的最小节点,右子树根节点一直往左走找到左子树为空的节点
    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
