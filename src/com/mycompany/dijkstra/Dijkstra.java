package com.mycompany.dijkstra;

import java.util.HashMap;
import java.util.Map;

public class Dijkstra {

    static final int V = 7;

    private static int minDistance(int[] dist, boolean[] verticeYaProcesado) {
        int min = Integer.MAX_VALUE;
        int min_index = 0;
        for (int v = 0; v < V; v++)
            if (!verticeYaProcesado[v] && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }

    private static void printSolution(int[] dist, Map<Integer, String> nombresVertices) {
        System.out.println("Distancia del vertice desde el origen\n");
        for (int i = 0; i < V; i++)
            System.out.println(nombresVertices.get(i) + " \t\t " + dist[i]);
    }

    public static void dijkstra(int[][] grafo, int src, Map<Integer, String> nombresVertices) {
        int[] dist = new int[V];
        boolean[] verticeYaProcesado = new boolean[V];

        for (int i = 0; i < V; i++) {
            dist[i] = Integer.MAX_VALUE;
            verticeYaProcesado[i] = false;
        }

        dist[src] = 0;

        for (int count = 0; count < V - 1; count++) {
            int u = minDistance(dist, verticeYaProcesado);
            verticeYaProcesado[u] = true;

            for (int v = 0; v < V; v++)
                if (!verticeYaProcesado[v] && grafo[u][v] > 0 && dist[u] != Integer.MAX_VALUE
                        && dist[u] + grafo[u][v] < dist[v])
                    dist[v] = dist[u] + grafo[u][v];
        }

        printSolution(dist, nombresVertices);
    }

    public static void main(String[] args) {
        int[][] graph = {{0, 7, 10, 5, 0, 0, 0}, 
                          {7, 0, 4, 0, 0, 0, 0},
                          {10, 4, 0, 5, 7, 0, 0}, 
                          {5, 0, 5, 0, 10, 0, 0},
                          {0, 0, 7, 10, 0, 10, 8}, 
                          {0, 12, 0, 0, 10, 0, 6}, 
                          {0, 0, 0, 0, 8, 6, 0}};

        Map<Integer, String> nombresVertices = new HashMap<>();
        nombresVertices.put(0, "Rimac");
        nombresVertices.put(1, "SMP");
        nombresVertices.put(2, "Los Olivos");
        nombresVertices.put(3, "Independencia");
        nombresVertices.put(4, "Comas");
        nombresVertices.put(5, "Puenta Piedra");
        nombresVertices.put(6, "Carabayllo");

        dijkstra(graph, 0, nombresVertices);
    }
}
