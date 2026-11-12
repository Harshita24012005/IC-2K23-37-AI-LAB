
import java.util.*;

class AStarNode {
    int vertex;
    int cost;
    int heuristic;

    AStarNode(int vertex, int cost, int heuristic) {
        this.vertex = vertex;
        this.cost = cost;
        this.heuristic = heuristic;
    }

    int getF() {
        return cost + heuristic;
    }
}

public class AStar {

    public static void main(String[] args) {

        int[][] graph = {
                {0, 1, 4, 0},
                {1, 0, 2, 5},
                {4, 2, 0, 1},
                {0, 5, 1, 0}
        };

        int[] h = {4, 3, 1, 0};

        int start = 0;
        int goal = 3;

        int[] g = new int[4];
        Arrays.fill(g, Integer.MAX_VALUE);

        boolean[] visited = new boolean[4];

        PriorityQueue<AStarNode> pq =
                new PriorityQueue<>(
                        (a, b) -> Integer.compare(a.getF(), b.getF())
                );

        g[start] = 0;

        pq.add(new AStarNode(start, 0, h[start]));

        while (!pq.isEmpty()) {

            AStarNode current = pq.poll();

            int u = current.vertex;

            if (visited[u])
                continue;

            visited[u] = true;

            if (u == goal) {
                System.out.println("Shortest Cost: " + g[u]);
                return;
            }

            for (int v = 0; v < 4; v++) {

                if (graph[u][v] > 0 && !visited[v]) {

                    int newCost = g[u] + graph[u][v];

                    if (newCost < g[v]) {

                        g[v] = newCost;

                        pq.add(new AStarNode(v, g[v], h[v]));
                    }
                }
            }
        }

        System.out.println("Goal not reachable");
    }
}
