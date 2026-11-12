
import java.util.*;

public class HillClimbing {

    public static void main(String[] args) {

        int[] states = {1, 3, 5, 7, 6, 4, 2};

        int current = 0;

        while (true) {

            int next = current;

            // Check left neighbour
            if (current > 0 &&
                    states[current - 1] > states[next]) {
                next = current - 1;
            }

            // Check right neighbour
            if (current < states.length - 1 &&
                    states[current + 1] > states[next]) {
                next = current + 1;
            }

            // Stop if no better neighbour exists
            if (next == current) {
                break;
            }

            current = next;
        }

        System.out.println("Best State: " + states[current]);
    }
}
