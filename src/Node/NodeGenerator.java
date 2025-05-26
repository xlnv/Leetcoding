package Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Node {
    double x; // 节点的横坐标
    double y; // 节点的纵坐标

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("%.2f %.2f", x, y);
    }
}

public class NodeGenerator {

    public static void main(String[] args) {
        // 示例调用，生成50个节点，坐标范围在[-10, 10]之间
        List<Node> nodes = generateNodes(100, -2, 2, -2, 2);

        // 输出生成的节点信息
        System.out.println("Generated Nodes:");
        for (Node node : nodes) {
            System.out.println(node);
        }

        // 创建邻接矩阵
        int[][] adjacencyMatrix = createAdjacencyMatrix(nodes.size());

        // 打印邻接矩阵
        System.out.println("\nAdjacency Matrix:");
        printAdjacencyMatrix(adjacencyMatrix);

        // 生成连接关系及其权重信息
        List<String> connections = adjacencyMatrixToConnectionsWithWeights(adjacencyMatrix, nodes);


    }

    public static List<Node> generateNodes(int numNodes, double rangeXMin, double rangeXMax, double rangeYMin, double rangeYMax) {
        List<Node> nodeList = new ArrayList<>();
        Random rand = new Random();

        // 定义每个节点所需的最小距离，避免过度集中
        double minDistance = Math.sqrt((rangeXMax - rangeXMin) * (rangeYMax - rangeYMin) / numNodes) / 2.0;

        while (nodeList.size() < numNodes) {
            double x = rangeXMin + (rangeXMax - rangeXMin) * rand.nextDouble();
            double y = rangeYMin + (rangeYMax - rangeYMin) * rand.nextDouble();

            boolean isTooClose = false;
            // 检查生成的点是否与已有的点太接近
            for (Node node : nodeList) {
                double distance = Math.sqrt(Math.pow(node.x - x, 2) + Math.pow(node.y - y, 2));
                if (distance < minDistance) {
                    isTooClose = true;
                    break;
                }
            }

            // 如果距离合适，加入节点列表
            if (!isTooClose) {
                nodeList.add(new Node(x, y));
            }
        }

        return nodeList;
    }



    public static int[][] createAdjacencyMatrix(int numNodes) {
        Random rand = new Random();
        int[][] adjacencyMatrix = new int[numNodes][numNodes];

        // 保证每个节点至少有2个连接
        ensureMinimumConnections(adjacencyMatrix, numNodes, rand);

        // 随机添加更多的连接（可选）
        int additionalEdges = rand.nextInt(numNodes); // 随机添加一些额外的连接
        for (int k = 0; k < additionalEdges; k++) {
            int nodeA = rand.nextInt(numNodes);
            int nodeB = rand.nextInt(numNodes);
            if (nodeA != nodeB && adjacencyMatrix[nodeA][nodeB] == 0) {
                adjacencyMatrix[nodeA][nodeB] = 1;
                adjacencyMatrix[nodeB][nodeA] = 1;
            }
        }

        return adjacencyMatrix;
    }

    private static void ensureMinimumConnections(int[][] adjacencyMatrix, int numNodes, Random rand) {
        // 遍历每个节点，确保每个节点至少有2个连接
        for (int i = 0; i < numNodes; i++) {
            int connections = 0;

            // 检查当前节点的连接数
            for (int j = 0; j < numNodes; j++) {
                if (adjacencyMatrix[i][j] == 1) {
                    connections++;
                }
            }

            // 如果连接数少于2，则添加连接
            while (connections < 2) {
                // 随机选择一个其他节点进行连接
                int randomNode = rand.nextInt(numNodes);
                if (randomNode != i && adjacencyMatrix[i][randomNode] == 0) {
                    adjacencyMatrix[i][randomNode] = 1;
                    adjacencyMatrix[randomNode][i] = 1; // 保证无向图对称连接
                    connections++;
                }
            }
        }
    }

    public static void printAdjacencyMatrix(int[][] adjacencyMatrix) {
        for (int[] row : adjacencyMatrix) {
            for (int value : row) {
                System.out.print(value + "");
            }
            System.out.println();
        }
    }

    public static List<String> adjacencyMatrixToConnectionsWithWeights(int[][] adjMatrix, List<Node> nodes) {
        List<String> connections = new ArrayList<>();
        int numNodes = adjMatrix.length;

        // 状态信息：开始生成连接
        //System.out.println("Status: Starting to generate connections with weights.");

        for (int i = 0; i < numNodes; i++) {
            for (int j = i + 1; j < numNodes; j++) {
                if (adjMatrix[i][j] == 1) {
                    double weight1 = Math.round(randomDouble(0, 1) * 100.0) / 100.0;  // Random weight between 0 and 1
                    double weight2 = Math.round(randomDouble(0, 100) * 100.0) / 100.0; // Random weight between 0 and 100
                    double weight3 = Math.round(randomDouble(0, 1) * 100.0) / 100.0;  // Random weight between 0 and 1

                    String connection = String.format("%d-%d:%.2f,%.2f,%.2f",
                            i + 1, j + 1,
                            nodes.get(i).x, nodes.get(i).y,
                            nodes.get(j).x, nodes.get(j).y,
                            weight1, weight2, weight3);

                    // 添加连接关系和权重
                    connections.add(connection);

                    // 状态信息：输出每次生成的连接和权重信息
                    System.out.println( (i + 1) + "-" + (j + 1) +":" + weight1 + "," + weight2 + "," + weight3 );
                }
            }
        }

        // 状态信息：完成生成
        System.out.println("Status: Finished generating all connections.");

        return connections;
    }

    public static double randomDouble(double min, double max) {
        Random rand = new Random();
        return min + (max - min) * rand.nextDouble();
    }
}
