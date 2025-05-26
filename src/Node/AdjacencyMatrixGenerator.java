package Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class AdjacencyMatrixGenerator {
    public static void main(String[] args) {
        // 定义边的连接关系
        int[][] edges = {
                {1, 3}, {1, 6}, {1, 9}, {1, 10}, {1, 11},
                {2, 4}, {2, 7}, {2, 13},
                {3, 5}, {3, 8}, {3, 9}, {3, 11},
                {4, 6}, {4, 7}, {4, 12},
                {5, 8}, {5, 14},
                {6, 10}, {6, 12},
                {7, 12}, {7, 13},
                {8, 11}, {8, 14}, {8, 16},
                {9, 10}, {9, 11}, {9, 15},
                {10, 12}, {10, 15}, {10, 18},
                {11, 14}, {11, 15}, {11, 16}, {11, 19},
                {12, 15}, {12, 17}, {12, 18},
                {13, 17}, {13, 21},
                {14, 16}, {14, 20},
                {15, 18}, {15, 19}, {15, 24},
                {16, 19}, {16, 20}, {16, 23}, {16, 25},
                {17, 21}, {17, 22}, {17, 27},
                {18, 22}, {18, 24}, {18, 26},
                {19, 23}, {19, 24}, {19, 25}, {19, 29},
                {20, 23}, {20, 25}, {20, 30},
                {21, 22}, {21, 27}, {21, 28}, {21, 31},
                {22, 26}, {22, 27},
                {23, 24}, {23, 25}, {23, 29},
                {24, 26}, {24, 29}, {24, 32},
                {25, 29}, {25, 30}, {25, 34}, {25, 35},
                {26, 27}, {26, 29}, {26, 32}, {26, 33}, {26, 37},
                {27, 28}, {27, 31}, {27, 33}, {27, 38},
                {28, 31}, {28, 36},
                {29, 32}, {29, 35},
                {30, 34}, {30, 39},
                {31, 33}, {31, 36}, {31, 38}, {31, 43},
                {32, 33}, {32, 35}, {32, 37}, {32, 40},
                {33, 37}, {33, 38}, {33, 42}, {33, 44},
                {34, 35}, {34, 39}, {34, 41},
                {35, 40}, {35, 41},
                {36, 38}, {36, 43},
                {37, 38}, {37, 40}, {37, 42}, {37, 44},
                {38, 42}, {38, 43}, {38, 48},
                {39, 41}, {39, 47},
                {40, 44}, {40, 45}, {40, 49},
                {41, 46}, {41, 47},
                {42, 43}, {42, 44}, {42, 48}, {42, 50},
                {43, 48},
                {44, 49}, {44, 50},
                {45, 46}, {45, 49},
                {46, 47},
                {48, 50}
        };

        // 确定节点数量
        int numNodes = 0;
        for (int[] edge : edges) {
            numNodes = Math.max(numNodes, Math.max(edge[0], edge[1]));
        }

        // 初始化邻接矩阵
        int[][] adjacencyMatrix = new int[numNodes][numNodes];

        // 填充邻接矩阵
        for (int[] edge : edges) {
            int node1 = edge[0] - 1; // 0-indexed
            int node2 = edge[1] - 1; // 0-indexed
            adjacencyMatrix[node1][node2] = 1; // 节点1到节点2的连接
            adjacencyMatrix[node2][node1] = 1; // 节点2到节点1的连接（无向图）
        }

        // 输出邻接矩阵
        /*System.out.println("Adjacency Matrix:");
        for (int i = 0; i < numNodes; i++) {
            StringBuilder row = new StringBuilder();
            for (int j = 0; j < numNodes; j++) {
                row.append(adjacencyMatrix[i][j]);
            }
            System.out.println(row);
        }*/
        // 创建随机数生成器
        Random random = new Random();

        // 输出连接情况及随机权重信息
        System.out.println("Connections with Random Weights:");
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            // 生成随机权重 (范围: 1.0 到 10.0)
            double weight1 = 1.0 + (9.0 * random.nextDouble()); // 随机生成 [1.0, 10.0)
            double weight2 = 1.0 + (10.0 * random.nextInt(2,10));
            double weight3 = 0.90 + (0.10 * random.nextDouble()); // 随机生成 [0.90, 1.00)
            System.out.printf("%d-%d:%.2f,%.2f,%.2f%n", node1, node2, weight1, weight2, weight3);
        }
    }
}

