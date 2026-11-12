import java.util.*;

public class WaterJugProblem {

    static class State {
        int jug1;
        int jug2;

        State(int jug1, int jug2) {
            this.jug1 = jug1;
            this.jug2 = jug2;
        }
    }

    static void solveWaterJug(int capacity1, int capacity2, int target) {

        Queue<State> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.add(new State(0, 0));
        visited.add("0,0");

        while (!queue.isEmpty()) {

            State current = queue.poll();

            int x = current.jug1;
            int y = current.jug2;

            System.out.println("Jug 1: " + x + " | Jug 2: " + y);

            if (x == target || y == target) {
                System.out.println("Target reached!");
                return;
            }

            // Fill Jug 1
            addState(capacity1, y, queue, visited);

            // Fill Jug 2
            addState(x, capacity2, queue, visited);

            // Empty Jug 1
            addState(0, y, queue, visited);

            // Empty Jug 2
            addState(x, 0, queue, visited);

            // Pour Jug 1 -> Jug 2
            int pour = Math.min(x, capacity2 - y);
            addState(x - pour, y + pour, queue, visited);

            // Pour Jug 2 -> Jug 1
            pour = Math.min(y, capacity1 - x);
            addState(x + pour, y - pour, queue, visited);
        }

        System.out.println("Target cannot be reached.");
    }

    static void addState(int x, int y,
                         Queue<State> queue,
                         Set<String> visited) {

        String state = x + "," + y;

        if (!visited.contains(state)) {
            visited.add(state);
            queue.add(new State(x, y));
        }
    }

    public static void main(String[] args) {

        int jug1Capacity = 4;
        int jug2Capacity = 3;
        int target = 2;

        solveWaterJug(jug1Capacity, jug2Capacity, target);
    }
}
