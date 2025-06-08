package BinaryTree;

import java.util.HashMap;
import java.util.Map;

public class Solution18 {
    public static void main(String[] args) {
        //106.从中序与后序遍历序列构造二叉树
        //根据一棵树的中序遍历与后序遍历构造二叉树。
        //注意: 你可以假设树中没有重复的元素。
        // 测试用例1
        int[] inorder1 = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder1 = {4, 5, 2, 6, 7, 3, 1};
        TreeNode node = buildTree(inorder1, postorder1);
        System.out.println(node.levelOrderTraversal());

    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // 存储中序遍历中值到索引的映射，方便快速查找
        Map<Integer, Integer> inOrderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        // 调用递归函数，初始参数为整个中序和后序数组范围
        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, inOrderMap);
    }

    private static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart,
                                            int postEnd, Map<Integer, Integer> inOrderMap) {
        // 递归终止条件：当没有元素需要处理时返回null
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }
        // 在后序的最后一个元素找到根节点
        int rootVal = postorder[postEnd];
        // 创建二叉树的根节点
        TreeNode root = new TreeNode(rootVal);

        //在中序数组中找到根节点的位置索引
        int rootIndexInInorder = inOrderMap.get(rootVal);

        // 在中序数组中划分左子树的节点个数，即根节点左边的元素个数
        int leftSubtreeSize = rootIndexInInorder - inStart;

        //递归构建左子树
        // 左子树在中序遍历的范围：[inStart,rootIndexInInorder-1]
        // 左子树在后序遍历的范围：[postStart,postStart + leftSubtreeSize-1]
        root.left = buildTreeHelper(inorder, inStart, rootIndexInInorder - 1, postorder, postStart,
                postStart + leftSubtreeSize - 1, inOrderMap);

        //递归构建右子树
        // 右子树在中序遍历的范围：[rootIndexInInorder+1,inEnd]
        //右子树在后序中的范围是左子树之后到倒数第二个元素（因为最后一个元素是根节点）
        // 右子树在后序遍历的范围：[postStart + leftSubtreeSize ,postEnd-1]
        root.right = buildTreeHelper(inorder, rootIndexInInorder + 1, inEnd,
                postorder, postStart + leftSubtreeSize, postEnd - 1, inOrderMap);

        return root;

    }


}

/*
基本概念回顾：
​​中序遍历（Inorder）​​：左子树 → 根节点 → 右子树
​​后序遍历（Postorder）​​：左子树 → 右子树 → 根节点
关键思路：
​​后序遍历的最后一个元素​​一定是整棵树的​​根节点​​。
在中序遍历中找到这个根节点，它的​​左边就是左子树​​，​​右边就是右子树​​。
通过左右子树的大小，可以在后序遍历中划分出左右子树的部分。
具体例子：
假设有以下遍历结果：

中序遍历：[4, 2, 5, 1, 6, 3, 7]
后序遍历：[4, 5, 2, 6, 7, 3, 1]
步骤1：确定根节点
后序遍历的最后一个元素是1，所以1是整棵树的根节点。
在中序遍历中找到1的位置：
[4, 2, 5, **1**, 6, 3, 7]
1的左边[4, 2, 5]是左子树，右边[6, 3, 7]是右子树。
步骤2：递归构建左子树
​​左子树的中序遍历​​：[4, 2, 5]
​​左子树的后序遍历​​：怎么找？
后序遍历中，左子树的部分是紧跟着左子树节点数的部分。
左子树有3个节点（4,2,5），所以从后序遍历的前3个元素[4, 5, 2]是左子树的后序遍历。
现在问题变成：
中序：[4, 2, 5]
后序：[4, 5, 2]
重复步骤1：
后序的最后一个元素2是左子树的根。
在中序中找到2的位置：
[4, **2**, 5]
2的左边[4]是左子树，右边[5]是右子树。
递归下去，最终左子树的结构是：
  2
 / \
4   5
步骤3：递归构建右子树
​​右子树的中序遍历​​：[6, 3, 7]
​​右子树的后序遍历​​：后序遍历中剩下的部分（去掉左子树和根节点）是[6, 7, 3]。
现在问题变成：
中序：[6, 3, 7]
后序：[6, 7, 3]
重复步骤1：
后序的最后一个元素3是右子树的根。
在中序中找到3的位置：
[6, **3**, 7]
3的左边[6]是左子树，右边[7]是右子树。
递归下去，最终右子树的结构是：
  3
 / \
6   7
最终二叉树：
      1
     / \
    2   3
   / \ / \
  4 5 6 7
代码关键点解释：
​​哈希表优化​​：为了快速找到根节点在中序遍历中的位置，先用哈希表存储中序遍历的值和索引。
​​递归构建​​：
每次用后序的最后一个元素确定根节点。
用中序划分左右子树。
根据左子树的大小，在后序中划分左右子树的部分。
​​终止条件​​：当没有节点需要处理时（即start > end），返回null。
 */