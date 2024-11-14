import java.util.*;
class Edge implements Comparable<Edge> {
    int src, dest, weight;
    public int compareTo(Edge other) { return this.weight - other.weight; }
}
public class KruskalAlgorithm {
    int V;
    List<Edge> edges = new ArrayList<>();

    int find(int[] parent, int i) {
        if (parent[i] != i) parent[i] = find(parent, parent[i]);
        return parent[i];
    }

    void union(int[] parent, int[] rank, int x, int y) {
        int rootX = find(parent, x), rootY = find(parent, y);
        if (rank[rootX] < rank[rootY]) parent[rootX] = rootY;
        else if (rank[rootX] > rank[rootY]) parent[rootY] = rootX;
        else { parent[rootY] = rootX; rank[rootX]++; }
    }

    void kruskalMST() {
        Collections.sort(edges);
        int[] parent = new int[V], rank = new int[V];
        for (int i = 0; i < V; i++) parent[i] = i;

        System.out.println("Edge \tWeight");
        for (Edge edge : edges) {
            int x = find(parent, edge.src), y = find(parent, edge.dest);
            if (x != y) {
                System.out.println(edge.src + " - " + edge.dest + "\t" + edge.weight);
                union(parent, rank, x, y);
            }
        }
    }

    public static void main(String[] args) {
        KruskalAlgorithm graph = new KruskalAlgorithm();
        graph.V = 4;
        graph.edges.add(new Edge() {{ src = 0; dest = 1; weight = 10; }});
        graph.edges.add(new Edge() {{ src = 0; dest = 2; weight = 6; }});
        graph.edges.add(new Edge() {{ src = 0; dest = 3; weight = 5; }});
        graph.edges.add(new Edge() {{ src = 1; dest = 3; weight = 15; }});
        graph.edges.add(new Edge() {{ src = 2; dest = 3; weight = 4; }});

        graph.kruskalMST();
    }
}
