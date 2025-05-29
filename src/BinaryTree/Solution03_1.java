package BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution03_1 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        // 调用前序遍历方法
        List<Integer> result = preorderTraversal(root);
        System.out.println(result); // 输出:[1,2,4,5,3,6,7]

    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>(); // 模拟递归栈
        if(root != null)st.push(root); // 根节点入栈

        while (!st.empty()) {
            TreeNode node = st.peek(); // 查看栈顶元素
            if (node != null) {
                st.pop();
                // 前序顺序：中 → 左 → 右，入栈顺序逆序：右 → 左 → 中
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
                st.push(node);
                st.push(null);
            } else {
                st.pop(); // 弹出null
                node = st.peek();
                st.pop();
                result.add(node.val);
            }
        }
        return result;

    }
}
