package us.ivannikov.algo.graph.bellman_ford;

import java.util.Arrays;

public class BellmanFord {

    class Edge {
        int source, dest, weight;
        Edge() { source = dest = weight = 0; }
    }

    private int V, E;
    private Edge[] edges;

    public BellmanFord(int v, int e) {
        V = v;
        E = e;
        edges = new Edge[e];
        for (int i = 0; i < e; ++i)
            edges[i] = new Edge();
    }

    public void bellmanFord(int src) {

        //v - 5
        //e - 8
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        // Релаксация всех рёбер V-1 раз
        for (int i = 1; i < V; ++i) {
            for (int j = 0; j < E; ++j) {
                int u = edges[j].source;
                int v = edges[j].dest;
                int weight = edges[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
                    dist[v] = dist[u] + weight;
            }
        }

        // Проверка на отрицательные циклы
        for (int j = 0; j < E; ++j) {
            int u = edges[j].source;
            int v = edges[j].dest;
            int weight = edges[j].weight;
            if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                System.out.println("Граф содержит отрицательный цикл");
                return;
            }
        }

        printSolution(dist);
    }

    private void printSolution(int[] dist) {
        System.out.println("Вершина \t Расстояние от источника");
        for (int i = 0; i < V; ++i)
            System.out.println(i + "\t\t" + dist[i]);
    }

    public static void main(String[] args) {

        /*
         (-1)
      0 -----> 1
      |       /| \
      |      / |  \(2)
   (4)|  (3)/  |(2)\
      |    /   |    \
      v  v     |     v
      2 <----- 3 <--- 4
        (5)    ^   (-3)
                \    /
                  (1)
         * */

        int V = 5; // Количество вершин
        int E = 8; // Количество рёбер

        BellmanFord graph = new BellmanFord(V, E);

        // Пример графа
        graph.edges[0].source = 0;
        graph.edges[0].dest = 1;
        graph.edges[0].weight = -1;

        graph.edges[1].source = 0;
        graph.edges[1].dest = 2;
        graph.edges[1].weight = 4;

        graph.edges[2].source = 1;
        graph.edges[2].dest = 2;
        graph.edges[2].weight = 3;

        graph.edges[3].source = 1;
        graph.edges[3].dest = 3;
        graph.edges[3].weight = 2;

        graph.edges[4].source = 1;
        graph.edges[4].dest = 4;
        graph.edges[4].weight = 2;

        graph.edges[5].source = 3;
        graph.edges[5].dest = 2;
        graph.edges[5].weight = 5;

        graph.edges[6].source = 3;
        graph.edges[6].dest = 1;
        graph.edges[6].weight = 1;

        graph.edges[7].source = 4;
        graph.edges[7].dest = 3;
        graph.edges[7].weight = -3;

        graph.bellmanFord(0); // Запуск алгоритма с вершины 0
    }
}