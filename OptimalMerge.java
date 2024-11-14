import java.util.PriorityQueue;

public class OptimalMerge {
    public static int optimalMerge(int[] files) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int file : files) pq.add(file);
        
        int totalCost = 0;
        while (pq.size() > 1) {
            int first = pq.poll();
            int second = pq.poll();
            int cost = first + second;
            totalCost += cost;
            pq.add(cost);
        }
        
        return totalCost;
    }

    public static void main(String[] args) {
        int[] files = {4, 3, 2, 6};
        System.out.println("Minimum cost of merging: " + optimalMerge(files));
    }
}
