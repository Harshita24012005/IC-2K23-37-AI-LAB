import java.util.*;

public class BFS {

    static void bfs(int start, ArrayList<ArrayList<Integer>> graph, int V) {

        boolean[] visited = new boolean[V];

        Queue<Integer> queue = new LinkedList<>();

        // Start node
        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int node = queue.poll();

            System.out.print(node + " ");

            // Visit all neighbours
            for (int neighbour : graph.get(node)) {

                if (!visited[neighbour]) {
                    visited[neighbour] = true;
                    queue.add(neighbour);
                }
            }
        }
    }

    public static void main(String[] args) {

        int V = 6;

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            graph.add(new ArrayList<>());
        }

        // Edges
        graph.get(0).add(1);
        graph.get(0).add(2);

        graph.get(1).add(0);
        graph.get(1).add(3);
        graph.get(1).add(4);

        graph.get(2).add(0);
        graph.get(2).add(5);

        graph.get(3).add(1);
        graph.get(4).add(1);
        graph.get(5).add(2);

        bfs(0, graph, V);
    }
}
