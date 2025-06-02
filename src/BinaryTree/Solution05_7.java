package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class Solution05_7 {
    public static void main(String[] args) {
        //116.填充每个节点的下一个右侧节点指针
        //给定一个完美二叉树，其所有叶子节点都在同一层，每个父节点都有两个子节点。
    }

    public static Node connect(Node root) {
        if(root ==null) return null;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node node = queue.poll();
                if (i < levelSize - 1) {
                    node.next = queue.peek();
                }
                if(root.left!=null) queue.offer(node.left);
                if(root.right!=null) queue.offer(node.right);
            }
        }
        return root;
    }
}
