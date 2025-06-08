package BinaryTree;

public class Solution29 {
    public static void main(String[] args) {
        //701.二叉搜索树中的插入操作
        //给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。
        //返回插入后二叉搜索树的根节点。 输入数据保证，新值和原始二叉搜索树中的任意节点值都不同。
        //注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
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
        TreeNode res = insertIntoBST(root, 5);
        System.out.println("前序遍历结果" + res.preorderTraversal());
        System.out.println("中序遍历结果" + res.inorderTraversal());
        System.out.println("后序遍历结果" + res.postorderTraversal());
        System.out.println("层序遍历结果" + res.levelOrderTraversal());

    }


    /*
    1.从根节点开始遍历:比较当前节点的值与待插入的值。
    2.根据比较结果决定移动方向:
    如果待插入的值小于当前节点的值，移动到左子树。
    如果待插入的值大于当前节点的值，移动到右子树。
    3.找到插入位置:当到达叶子节点(即当前节点的左或右子节点为空)时，将新节点插入到该位置。
    4.返回根节点:插入完成后，返回树的根节点。
     */
    public static TreeNode insertIntoBST(TreeNode root, int val) {
        // 如果树为空，直接创建新节点作为根节点
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode current = root; // 使用 current 指针遍历，避免修改 root
        while (true) {
            // 如果待插入的值小于当前节点的值
            if (val < current.val) {
                // 如果左子节点为空，插入新节点
                if (current.left == null) {
                    current.left = new TreeNode(val);
                    break;
                } else {
                    // 否则继续向左子树移动
                    current = current.left;
                }
            }
            // 如果待插入的值大于当前节点的值
            else {
                // 如果右子节点为空，插入新节点
                if (current.right == null) {
                    current.right = new TreeNode(val);
                    break;
                } else {
                    // 否则继续向右子树移动
                    current = current.right;
                }
            }
        }
        return root;

    }
}
