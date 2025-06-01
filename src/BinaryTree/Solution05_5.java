package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution05_5 {
    public static void main(String[] args) {
        //给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
        // 构建测试用例1
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        List<Node> childrenOf3 = new ArrayList<>();
        childrenOf3.add(node5);
        childrenOf3.add(node6);

        Node node3 = new Node(3, childrenOf3);
        Node node2 = new Node(2);
        Node node4 = new Node(4);

        List<Node> childrenOf1 = new ArrayList<>();
        childrenOf1.add(node3);
        childrenOf1.add(node2);
        childrenOf1.add(node4);

        Node root = new Node(1, childrenOf1);


        List<List<Integer>> result = levelOrder(root);

        // 预期输出: [[1], [3, 2, 4], [5, 6]]
        System.out.println(result);
    }

    public static List<List<Integer>> levelOrder(Node root) {
        // 用于存储最终结果的列表，每个子列表代表一层的节点值
        List<List<Integer>> result = new ArrayList<>();

        // 如果根节点为空，直接返回空列表
        if (root == null) {
            return result;
        }

        // 使用队列辅助进行层序遍历
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);  // 将根节点加入队列

        while (!queue.isEmpty()) {
            // 当前层的节点数量
            int levelSize = queue.size();
            // 存储当前层节点值的列表
            List<Integer> currentLevel = new ArrayList<>();

            // 遍历当前层的所有节点
            for (int i = 0; i < levelSize; i++) {
                Node currentNode = queue.poll();  // 取出队列头部的节点
                currentLevel.add(currentNode.val);  // 将节点值加入当前层列表

                // 将该节点的所有子节点加入队列，用于下一层的遍历
                if (currentNode.children != null) {
                    for (Node child : currentNode.children) {
                        queue.offer(child);
                    }
                }
            }

            // 将当前层的结果加入最终结果列表
            result.add(currentLevel);
        }

        return result;

    }
}
