import java.util.*;
class DijkstraAlgorithm {
    static int findMinVertex(int[] distance, boolean[] visited, int vertices) {
        int minDistance = Integer.MAX_VALUE;
        int minVertex = -1;

        for (int i = 0; i < vertices; i++) {
            if (!visited[i] && distance[i] < minDistance) {
                minDistance = distance[i];
                minVertex = i;
            }
        }
        return minVertex;
    }
    static void dijkstra(int[][] graph, int source) {
        int vertices = graph.length;
        int[] distance = new int[vertices]; 
        boolean[] visited = new boolean[vertices]; 
        Arrays.fill(distance, Integer.MAX_VALUE);
        Arrays.fill(visited, false);
        distance[source] = 0;
        for (int i = 0; i < vertices - 1; i++) {
            int minVertex = findMinVertex(distance, visited, vertices);
            visited[minVertex] = true;
            for (int v = 0; v < vertices; v++) {
                if (!visited[v] && graph[minVertex][v] != 0 && distance[minVertex] != Integer.MAX_VALUE
                        && distance[minVertex] + graph[minVertex][v] < distance[v]) {
                    distance[v] = distance[minVertex] + graph[minVertex][v];
                }
            }
        }
        printSolution(distance, vertices);
    }
    static void printSolution(int[] distance, int vertices) {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < vertices; i++) {
            System.out.println(i + " \t\t " + distance[i]);
        }
    }
    public static void main(String[] args) {
        int[][] graph = {
                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 14, 10, 0, 2, 0, 0},
                {0, 0, 0, 0, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        int source = 0;
        dijkstra(graph, source);
    }
}