Lab 2: Search Algorithms

**Student Name:** Harshita Sohner  
**Roll Number:** IC-2k23-37  
**Course:** Artificial Intelligence  
**Year:** 4th Year  
**Semester:** 7  
**Section:** [Your Section]

Aim

To implement and understand different search algorithms used in Artificial Intelligence and analyze their working, performance, and applications using Java.

Algorithms Implemented

1. Breadth-First Search (BFS)
2. Depth-First Search (DFS)
3. Hill Climbing
4. Best-First Search
5. A* Search

 1. Breadth-First Search (BFS)

Problem Statement
Find a path from a starting node to a goal node in a graph using Breadth-First Search.

Algorithm
BFS explores nodes level by level using a queue. It visits all neighbouring nodes before moving to the next level and finds the shortest path in an unweighted graph.

Sample Output

```text
Breadth-First Search Traversal:
0 1 2 3 4 5
```

Complexity Analysis

- Time Complexity: O(V + E)
- Space Complexity: O(V)

Here, V is the number of vertices and E is the number of edges.

2. Depth-First Search (DFS)

### Problem Statement
Traverse a graph by exploring one branch as deeply as possible before backtracking.

### Algorithm
DFS uses a stack or recursion to explore nodes. It continues along a branch until no unvisited neighbouring node is available, then backtracks.

### Sample Output

```text
Depth-First Search Traversal:
0 1 3 4 2 5
```

### Complexity Analysis

- Time Complexity: O(V + E)
- Space Complexity: O(V)

## 3. Hill Climbing

### Problem Statement
Find the maximum value among neighbouring states using a heuristic-based search technique.

### Algorithm
Hill Climbing starts from an initial state and repeatedly moves to a neighbouring state with a higher value. It stops when no better neighbouring state is available.

### Sample Output

```text
Best State: 7
```

### Complexity Analysis

- Time Complexity: O(n), where n is the number of states in the array in the worst case.
- Space Complexity: O(1)

Hill Climbing may get stuck at a local optimum and does not guarantee a global optimum in general.

## 4. Best-First Search

### Problem Statement
Find a path from a starting node to a goal node using heuristic values.

### Algorithm
Best-First Search uses a priority queue to select the most promising node based on its heuristic value. The node with the lowest heuristic value is explored first.

### Sample Output

```text
Best First Search Traversal:
0 1 4 3 2 5
```

Complexity Analysis

- Time Complexity: O((V + E) log V), approximately with a priority queue.
- Space Complexity: O(V)

Best-First Search does not guarantee the shortest path because it considers heuristic values rather than actual path costs.

5. A* Search

### Problem Statement
Find the minimum-cost path from a starting node to a goal node using actual path cost and heuristic estimates.

Algorithm

A* Search uses the following evaluation function:

f(n) = g(n) + h(n)

Where:

- g(n): Actual cost from the starting node to the current node.
- h(n): Estimated cost from the current node to the goal.
- f(n): Estimated total path cost.

A* selects the node with the lowest f(n) value and continues searching until the goal node is reached.

### Sample Output

```text
Shortest Cost: 4
```

### Complexity Analysis

- Time Complexity: O((V + E) log V) for the implemented graph-search approach under suitable heuristic conditions.
- Space Complexity: O(V)

A* can find an optimal path when the heuristic is admissible and the implementation handles node costs correctly.

## Learning Outcomes

- Understood uninformed and informed search strategies.
- Implemented BFS and DFS for graph traversal.
- Learned how heuristic functions guide search algorithms.
- Understood the role of queues, stacks, and priority queues in search algorithms.
- Compared different search algorithms based on their working and complexity.
- Learned how A* combines actual path cost and heuristic estimates to find an optimal path.

## Source Code

The Java implementation of all five algorithms is available in the following files:

- `BFS.java`
- `DFS.java`
- `HillClimbing.java`
- `BestFirstSearch.java`
- `AStar.java`

## Technologies Used

- Programming Language: Java
- Data Structures: Queue, Stack, Priority Queue, Arrays
- IDE: IntelliJ IDEA
