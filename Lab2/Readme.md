# Lab 2 – Search Algorithms in Artificial Intelligence

## 1. Aim / Problem Statement

### Aim

To implement and understand different search algorithms used in Artificial Intelligence using Java and analyze their working, performance, and applications.

### Algorithms Implemented

1. Breadth-First Search (BFS)
2. Depth-First Search (DFS)
3. Hill Climbing
4. Best-First Search
5. A* Search

## 2. Algorithms and Implementation

### 1. Breadth-First Search (BFS)

#### Problem Statement

Find a path from a starting node to a goal node in an unweighted graph using Breadth-First Search.

#### Algorithm

BFS explores nodes level by level using a Queue. It visits all neighboring nodes before moving to the next level.

It finds the shortest path in terms of the number of edges in an unweighted graph.

#### Sample Output

```text
Breadth-First Search
Start Node: A
Goal Node: H
Path: A -> B -> E -> H
Path Length: 3
```

#### Complexity Analysis

- **Time Complexity:** O(V + E)
- **Space Complexity:** O(V)

Here, V represents the number of vertices and E represents the number of edges.

### 2. Depth-First Search (DFS)

#### Problem Statement

Find a path from a starting node to a goal node by exploring one branch deeply before backtracking.

#### Algorithm

DFS uses a Stack or recursion to explore nodes. It continues along a branch until it cannot proceed further, then backtracks to explore other branches.

#### Sample Output

```text
Depth-First Search
Start Node: A
Goal Node: H
Path: A -> C -> G -> H
Path Length: 3
```

#### Complexity Analysis

- **Time Complexity:** O(V + E)
- **Space Complexity:** O(V)

DFS does not guarantee the shortest path.

### 3. Hill Climbing

#### Problem Statement

Find the maximum value of a mathematical function using a heuristic-based search technique.

#### Algorithm

Hill Climbing starts from an initial state and repeatedly moves to a neighboring state with a better heuristic value.

It stops when no better neighboring state is available.

#### Sample Output

```text
Hill Climbing Search
Best State: 5
Maximum Value: 25
```

#### Complexity Analysis

- **Time Complexity:** O(k), where k is the number of steps taken.
- **Space Complexity:** O(1)

Hill Climbing may get stuck at a local optimum and does not guarantee finding the global optimum.

### 4. Best-First Search

#### Problem Statement

Find a path from a starting node to a goal node using heuristic information.

#### Algorithm

Best-First Search uses a Priority Queue to select the node with the lowest heuristic value first.

It uses heuristic information to decide which node should be explored next.

#### Sample Output

```text
Best-First Search
Path: A -> C -> G -> H
Path Length: 3
```

#### Complexity Analysis

- **Time Complexity:** O((V + E) log V), with a priority queue under standard graph-search assumptions.
- **Space Complexity:** O(V)

Best-First Search does not guarantee the shortest path because it considers heuristic values rather than the actual path cost.

### 5. A* Search

#### Problem Statement

Find a minimum-cost path from a starting node to a goal node using actual path cost and heuristic estimates.

#### Algorithm

A* Search uses both the actual path cost and estimated cost to select the next node.

It evaluates each node using the following formula:

**f(n) = g(n) + h(n)**

Where:

- `g(n)` = Actual cost from the start node to node n.
- `h(n)` = Estimated cost from node n to the goal.
- `f(n)` = Estimated total path cost.

#### Sample Output

```text
A* Search
Path: A -> B -> E -> H
Total Cost: 8
```

#### Complexity Analysis

- **Time Complexity:** Exponential in the worst case, depending on the heuristic and search space.
- **Space Complexity:** Exponential in the worst case.

A* can find an optimal path when the heuristic is admissible and the implementation correctly handles path costs and node revisiting.

## 3. Implementation

All five search algorithms are implemented separately using Java. Each algorithm has its own source code file.

**Programming Language:** Java

**Java Concepts Used:**

- Classes and Objects
- ArrayList
- HashMap
- HashSet
- Stack
- Queue
- PriorityQueue
- Recursion
- Heuristic Functions

## 4. Results / Output

The following search algorithms were successfully implemented and tested:

| Algorithm | Path / Result | Path Length / Cost |
|---|---|---|
| BFS | A → B → E → H | 3 |
| DFS | A → C → G → H | 3 |
| Hill Climbing | Best State: 5 | Maximum Value: 25 |
| Best-First Search | A → C → G → H | 3 |
| A* Search | A → B → E → H | Total Cost: 8 |

All five algorithms demonstrated different approaches to searching and finding solutions.

## 5. Performance Analysis

| Algorithm | Search Type | Data Structure | Optimality |
|---|---|---|---|
| BFS | Uninformed | Queue | Yes, for unweighted graphs |
| DFS | Uninformed | Stack / Recursion | No |
| Hill Climbing | Informed | Current State | No |
| Best-First Search | Informed | Priority Queue | No, in general |
| A* Search | Informed | Priority Queue | Yes, with suitable heuristic conditions |

### Complexity Summary

| Algorithm | Time Complexity | Space Complexity |
|---|---|---|
| BFS | O(V + E) | O(V) |
| DFS | O(V + E) | O(V) |
| Hill Climbing | O(k) | O(1) |
| Best-First Search | O((V + E) log V) | O(V) |
| A* Search | Exponential (worst case) | Exponential (worst case) |

Here:
- V = Number of vertices
- E = Number of edges
- k = Number of steps taken by Hill Climbing

## 6. Learning Outcomes

- Understood uninformed and informed search strategies.
- Implemented BFS and DFS for graph traversal using Java.
- Learned how heuristic functions guide search algorithms.
- Understood the role of Queue, Stack, and PriorityQueue.
- Studied Hill Climbing and its limitations, such as local optima.
- Compared Best-First Search and A* Search.
- Understood how heuristic quality affects search efficiency and optimality.
- Analyzed the time and space complexity of different search algorithms.

## 7. Source Code

The Java implementation of each search algorithm is available in separate files:

1. `BFS.java` – Breadth-First Search
2. `DFS.java` – Depth-First Search
3. `HillClimbing.java` – Hill Climbing
4. `BestFirstSearch.java` – Best-First Search
5. `AStarSearch.java` – A* Search

