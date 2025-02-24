package us.ivannikov.algo.graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Graph {
    private int vertices; // Количество вершин
    private List<List<Node>> adjacencyList; // Список смежности

    // Конструктор
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new ArrayList<>();
        for (int i = 0; i < vertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }
    }

    // Класс для представления вершины и её веса
    class Node {
        int vertex;
        int weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    // Добавление ребра в граф
    public void addEdge(int source, int destination, int weight) {
        adjacencyList.get(source).add(new Node(destination, weight));
    }

    // Алгоритм Дейкстры
    public void dijkstra(int startVertex) {
        // Массив для хранения кратчайших расстояний
        int[] distances = new int[vertices];
        Arrays.fill(distances, Integer.MAX_VALUE); // Инициализация бесконечностью
        distances[startVertex] = 0; // Расстояние до начальной вершины равно 0

        // Приоритетная очередь для выбора вершины с минимальным расстоянием
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(node -> node.weight));
        pq.add(new Node(startVertex, 0));

        while (!pq.isEmpty()) {
            int currentVertex = pq.poll().vertex;

            // Обновляем расстояния до соседей текущей вершины
            for (Node neighbor : adjacencyList.get(currentVertex)) {
                int newDistance = distances[currentVertex] + neighbor.weight;
                if (newDistance < distances[neighbor.vertex]) {
                    distances[neighbor.vertex] = newDistance;
                    pq.add(new Node(neighbor.vertex, newDistance));
                }
            }
        }

        // Вывод результатов
        System.out.println("Кратчайшие расстояния от вершины " + startVertex + ":");
        for (int i = 0; i < vertices; i++) {
            System.out.println("До вершины " + i + ": " + distances[i]);
        }
    }
}

public class DijkstraExample {


    /*
    Вершины: 0, 1, 2, 3, 4
    Рёбра:
    0 -> 1 (вес 4)
    0 -> 2 (вес 1)
    1 -> 3 (вес 1)
    2 -> 1 (вес 2)
    2 -> 3 (вес 5)
    3 -> 4 (вес 3)

    * */
    /*
    граф
       4
   0 -----> 1
   |     /| |
 1 |  2 /   |
   |   /   1|
   v  /     v
   2 -----> 3--->4
       5      3
     * */

    public static void main(String[] args) {

        int vertices = 5;
        Graph graph = new Graph(vertices);

        // Добавляем рёбра
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 1);
        graph.addEdge(1, 3, 1);
        graph.addEdge(2, 1, 2);
        graph.addEdge(2, 3, 5);
        graph.addEdge(3, 4, 3);

        // Запускаем алгоритм Дейкстры
        graph.dijkstra(0);
    }
}

