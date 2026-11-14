# Lab 1 – Water Jug Problem

## 1. Aim / Problem Statement

### Aim

To implement the Water Jug Problem in Java using a state-transition approach and determine a sequence of operations to measure an exact target quantity of water.

### Problem Statement

Two water jugs have capacities of 4 litres and 9 litres. Initially, both jugs are empty. The objective is to measure exactly 6 litres using the following operations:

1. Fill a jug completely.
2. Empty a jug completely.
3. Pour water from one jug into another until the source jug is empty or the destination jug is full.

**Input:**
- First Jug Capacity = 4 L
- Second Jug Capacity = 9 L
- Target = 6 L

## 2. Algorithm

### State Representation

A state is represented as `(a, b)` where:

- `a` represents the quantity of water in the first jug.
- `b` represents the quantity of water in the second jug.

Initial State: `(0, 0)`

Goal State: Any state where `a = 6` or `b = 6`.

### Algorithm Steps

1. Initialize both jugs with zero water.
2. Create a Queue to store the possible states.
3. Create a HashSet to keep track of visited states.
4. Add the initial state `(0, 0)` to the Queue.
5. Remove a state from the Queue and check whether the target is reached.
6. Generate possible next states using fill, empty, and pour operations.
7. Add unvisited states to the Queue.
8. Repeat until the target amount is reached or no states remain.
9. Display the solution and final state.

### Pseudocode

```text
START

Set first_capacity = 4
Set second_capacity = 9
Set target = 6

Create a Queue
Create a HashSet for visited states

Add initial state (0, 0) to Queue

WHILE Queue is not empty:

    Remove a state from Queue

    IF first_jug = target OR second_jug = target:
        Display "Target Reached"
        STOP

    Generate possible states using:
        1. Fill first jug
        2. Fill second jug
        3. Empty first jug
        4. Empty second jug
        5. Pour first jug into second jug
        6. Pour second jug into first jug

    Add unvisited states to Queue

Display "Target cannot be reached"

END
```

## 3. Implementation

The program is implemented in Java using Object-Oriented Programming concepts and collections.

**Programming Language:** Java

**Source File:** `WaterJugProblem.java`

**Java Concepts Used:**
- Classes and Objects
- Constructors
- Queue using LinkedList
- HashSet for visited-state tracking
- Breadth-First Search (BFS)
- State Transition

## 4. Results / Output

### Console Output

```text
Initial State: (0, 0)

Fill 4L jug
State: (4, 0)

Pour 4L from first jug into second jug
State: (0, 4)

Fill 4L jug
State: (4, 4)

Pour 4L from first jug into second jug
State: (0, 8)

Fill 4L jug
State: (4, 8)

Pour 1L from first jug into second jug
State: (3, 9)

Empty 9L jug
State: (3, 0)

Pour 3L from first jug into second jug
State: (0, 3)

Fill 4L jug
State: (4, 3)

Pour 4L from first jug into second jug
State: (0, 7)

Fill 4L jug
State: (4, 7)

Pour 2L from first jug into second jug
State: (2, 9)

Empty 9L jug
State: (2, 0)

Pour 2L from first jug into second jug
State: (0, 2)

Fill 4L jug
State: (4, 2)

Pour 4L from first jug into second jug
State: (0, 6)

Target reached! Final State: (0, 6)
```

### Result

The Water Jug Problem was successfully solved using Java. The program measured exactly 6 litres of water in the second jug.

**Final State:** `(0, 6)`

## 5. Performance Analysis

| Metric | Result |
|---|---|
| Target Achieved | Yes |
| Number of Operations | 15 |
| Search Algorithm | Breadth-First Search (BFS) |
| Time Complexity | O(X × Y) |
| Auxiliary Space Complexity | O(X × Y) |
| Accuracy / Precision / Recall / F1-score | Not applicable |

Here, `X` and `Y` represent the capacities of the two jugs.

There are `(X + 1) × (Y + 1)` possible states. BFS explores these states while the HashSet prevents revisiting previously explored states.

The problem is deterministic and does not involve classification or prediction. Therefore, classification metrics are not applicable.

## 6. State Visualization

```text
(0,0)
  ↓
(4,0)
  ↓
(0,4)
  ↓
(4,4)
  ↓
(0,8)
  ↓
(4,8)
  ↓
(3,9)
  ↓
(3,0)
  ↓
(0,3)
  ↓
(4,3)
  ↓
(0,7)
  ↓
(4,7)
  ↓
(2,9)
  ↓
(2,0)
  ↓
(0,2)
  ↓
(4,2)
  ↓
(0,6)
```

## 7. Learning Outcomes

- Understood problem formulation in Artificial Intelligence.
- Learned to represent a problem using states.
- Implemented state transitions using Java.
- Applied fill, empty, and pour operations.
- Understood Breadth-First Search (BFS) for exploring possible states.
- Learned to use Queue and HashSet in Java.
- Understood the role of visited-state tracking.
- Analyzed the time and space complexity of a state-based problem.
