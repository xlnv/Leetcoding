package BinaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution25 {
    public static void main(String[] args) {
        //501.二叉搜索树中的众数
        //给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。
        // 树结构：
        //        1
        //       / \
        //      3   3
        //     / \ / \
        //    3  7 7  5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(Arrays.toString(findMode(root))); // 3
    }

    public static int[] findMode(TreeNode root) {
        // 每次调用时初始化变量，避免静态变量带来的问题
        List<Integer> result = new ArrayList<>();
        int[] current = new int[2]; // current[0] = currentVal, current[1] = currentCount
        int[] max = new int[1];     // max[0] = maxCount

        inorder(root, result, current, max);

        int[] modes = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            modes[i] = result.get(i);
        }
        return modes;
    }

    private static void inorder(TreeNode node, List<Integer> result, int[] current, int[] max) {
        if (node == null) {
            return;
        }

        inorder(node.left, result, current, max);

        // 处理当前节点
        if (node.val == current[0]) {
            current[1]++; // 相同值，计数增加
        } else {
            current[0] = node.val; // 新值，重置计数
            current[1] = 1;
        }

        // 更新结果
        if (current[1] > max[0]) {
            max[0] = current[1];
            result.clear();
            result.add(current[0]);
        } else if (current[1] == max[0]) {
            result.add(current[0]);
        }

        inorder(node.right, result, current, max);
    }
}
