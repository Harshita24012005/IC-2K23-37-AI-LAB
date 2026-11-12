import java.util.*;

public class DFS {

    static void dfs(int node,
                    ArrayList<ArrayList<Integer>> graph,
                    boolean[] visited) {

        // Mark current node as visited
        visited[node] = true;

        // Print current node
        System.out.print(node + " ");

        // Visit neighbours
        for (int neighbour : graph.get(node)) {

            if (!visited[neighbour]) {
                dfs(neighbour, graph, visited);
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

        boolean[] visited = new boolean[V];

        dfs(0, graph, visited);
    }
}
