package algorithm.graph;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author 李文浩
 * @date 2018/6/23
 */

public class Graph {

    final int MIN = -256;
    final int MAX = 256;
    int numVertexes;
    int numEdges;
    String[] vex;
    int acr[][];

    public Graph() {
        vex = new String[MAX];
        acr = new int[MAX][MAX];
    }

    // 建立无向网图，  给图中的  顶点内容 和  边权重  赋值
    public void buildGraph(Graph g) {
        //读入顶点数和边数
        System.out.println("请输入顶点数：\n");
        Scanner sc = new Scanner(System.in);
        numVertexes = sc.nextInt();

        System.out.println("请输入边数：\n");
        numEdges = sc.nextInt();

        //读入顶点信息，建立顶点表
        for (int i = 0; i < g.numVertexes; i++) {
            System.out.print("第" + i + "个顶点信息为：");
            vex[i] = sc.next();
        }


        //邻接矩阵初始化
        for (int i = 0; i < g.numVertexes; i++)
            for (int j = 0; j < g.numVertexes; j++) {
                g.acr[i][j] = MIN;
            }

        //读入边信息，建立邻接矩阵
        for (int k = 0; k < g.numEdges; k++) {
            System.out.println("请输入边(i,j)的下标i：\n");
            int i = sc.nextInt();
            System.out.println("请输入边(i,j)的下标j：\n");
            int j = sc.nextInt();
            System.out.println("请输入边(i,j)的权重w：\n");
            int w = sc.nextInt();

            g.acr[i][j] = w;
            g.acr[j][i] = g.acr[i][j];
        }
        sc.close();
    }


    public void printGraph(Graph g) {
        System.out.print("        ");
        for (int i = 0; i < g.numVertexes; i++) {
            System.out.print(g.vex[i] + "     ");
        }

        for (int i = 0; i < g.numVertexes; i++) {
            System.out.println();
            System.out.print(g.vex[i] + "      ");
            for (int j = 0; j < g.numVertexes; j++) {
                System.out.print(g.acr[i][j] + "     ");
            }

        }
    }

    //深度优先遍历
    public void DFSTraverse(Graph g) {
        //建立访问数组
        boolean[] visited = new boolean[g.numVertexes];
        //初始化 访问顶点
        for (int i = 0; i < visited.length; i++)
            visited[i] = false;
        //对未访问顶点调用DFS
        for (int i = 0; i < visited.length; i++)
            if (!visited[i])
                DFS(g, i, visited);
    }


    //从顶点i开始进行的深度优先搜索DFS
    public void DFS(Graph g, int i, boolean[] visited) {
        visited[i] = true;
        System.out.print("已访问" + g.vex[i] + "  ");
        for (int j = 0; j < g.numVertexes; j++) {
            if (g.acr[i][j] > 0 && !visited[j])
                DFS(g, j, visited);
        }

    }


    //广度优先搜索
    public void BFS(Graph g) {
        int i = 0;
        Queue<Integer> q = new LinkedList<Integer>();
        //建立访问数组
        boolean visited[] = new boolean[MAX];
        //初始化 访问顶点
        for (i = 0; i < g.numVertexes; i++)
            visited[i] = false;

        //对每个顶点做循环
        for (i = 0; i < g.numVertexes; i++) {
            if (!visited[i]) {
                visited[i] = true;
                System.out.print("已访问" + g.vex[i] + "   ");
                q.offer(i);
                while (!q.isEmpty()) {
                    i = q.poll();
                    for (int j = 0; j < g.numVertexes; j++) {
                        if (g.acr[i][j] > 0 && !visited[j]) {
                            visited[j] = true;
                            System.out.print("已访问" + g.vex[j] + "   ");
                            q.offer(j);
                        }
                    }


                }

            }
        }
    }

    public static void main(String[] args) {
        Graph g = new Graph();
        g.buildGraph(g);
        g.printGraph(g);

        System.out.println();
        System.out.println("深度优先搜索结果：");
        g.DFSTraverse(g);

        System.out.println();
        System.out.println("广度优先搜索结果：");
        g.BFS(g);
    }

}
