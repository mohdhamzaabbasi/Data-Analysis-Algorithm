import java.util.Arrays;
public class FloydWarshall{
    final static int INF = 99999;
    void floydWarshall(int graph[][]) {
        int vertices = graph.length;
        int[][] dist = new int[vertices][vertices];
        for (int i = 0; i < vertices; i++) {
            dist[i] = Arrays.copyOf(graph[i], vertices);
        }
        for (int k = 0; k < vertices; k++) {
            for (int i = 0; i < vertices; i++) {
                for (int j = 0; j < vertices; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        printSolution(dist);
    }
    void printSolution(int[][] dist) {
        int vertices = dist.length;
        System.out.println("The following matrix shows the shortest distances between every pair of vertices:");
        for (int i = 0; i < vertices; i++) {
            for (int j = 0; j < vertices; j++) {
                if (dist[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(dist[i][j] + "   ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int graph[][] = {
                {0, 5, INF, 10},
                {INF, 0, 3, INF},
                {INF, INF, 0, 1},
                {INF, INF, INF, 0}
        };
        FloydWarshall fw = new FloydWarshall();
        fw.floydWarshall(graph);
    }
}