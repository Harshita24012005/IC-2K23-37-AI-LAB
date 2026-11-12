
import java.util.*;

class Node {
    int value;
    int heuristic;

    Node(int value, int heuristic) {
        this.value = value;
        this.heuristic = heuristic;
    }
}

public class BestFirstSearch {

    public static void main(String[] args) {

        PriorityQueue<Node> pq =
                new PriorityQueue<>(
                        (a, b) -> a.heuristic - b.heuristic
                );

        boolean[] visited = new boolean[6];

        // Insert starting node
        pq.add(new Node(0, 5));

        // Graph representation
        int[][] graph = {
                {1, 2},
                {3, 4},
                {5},
                {},
                {},
                {}
        };

        int[] h = {5, 3, 4, 2, 1, 0};

        System.out.println("Best First Search Traversal:");

        while (!pq.isEmpty()) {

            Node current = pq.poll();

            if (visited[current.value])
                continue;

            visited[current.value] = true;

            System.out.print(current.value + " ");

            for (int neighbour : graph[current.value]) {

                if (!visited[neighbour]) {
                    pq.add(new Node(neighbour, h[neighbour]));
                }
            }
        }
    }
}
