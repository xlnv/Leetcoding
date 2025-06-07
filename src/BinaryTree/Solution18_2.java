package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Solution18_2 {
    public static void main(String[] args) {
        //105.从前序与中序遍历序列构造二叉树
    }
    public static TreeNode buildTree(int[] preorder, int[] inorder ) {
        // 存储中序遍历中值到索引的映射，方便快速查找
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        // 调用递归函数，初始参数为整个中序和后序数组范围
        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, inOrderMap);
    }

    private static TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart,
                                            int inEnd, Map<Integer, Integer> inOrderMap) {
        // 递归终止条件：当没有元素需要处理时返回null
        if ( preStart > preEnd) {
            return null;
        }
        // 在前序的第一个元素找到根节点
        int rootVal = preorder[preStart];
        // 创建二叉树的根节点
        TreeNode root = new TreeNode(rootVal);

        //在中序数组中找到根节点的位置索引
        int rootIndexInInorder = inOrderMap.get(rootVal);

        // 在中序数组中划分左子树的节点个数，即根节点左边的元素个数
        int leftSubtreeSize = rootIndexInInorder - inStart;

        //递归构建左子树
        // 递归构建左子树
        // 前序遍历中左子树的范围：[preStart + 1, preStart + leftSize]
        // 中序遍历中左子树的范围：[inStart, rootIndex - 1]
        root.left = buildTreeHelper(preorder, preStart + 1, preStart + rootIndexInInorder,
                inorder, inStart, leftSubtreeSize - 1, inOrderMap);

        //递归构建右子树
        // 前序遍历中右子树的范围：[preStart + leftSize + 1, preEnd]
        // 中序遍历中右子树的范围：[rootIndex + 1, inEnd]
        root.right = buildTreeHelper(preorder, preStart + rootIndexInInorder + 1, preEnd,
                inorder, leftSubtreeSize+1, inEnd, inOrderMap);

        return root;

    }
}
