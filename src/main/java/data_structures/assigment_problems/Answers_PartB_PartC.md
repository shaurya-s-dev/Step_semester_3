# Part B — Quiz

Q1: B
Q2: C
Q3: C
Q4: C
Q5: C
Q6: C
Q7: C
Q8: A, B, C, E
Q9: B, C, D
Q10: C

# Part C — Concept Questions

## Question 1
Big-O focuses on the asymptotic growth rate because for sufficiently large inputs (as `n` approaches infinity), the term with the highest growth rate ultimately dominates the total execution time, rendering constants and lower-order terms insignificant. This allows us to compare algorithms fundamentally by how they scale, independent of hardware or minor implementation details.

## Question 2
Primitive data structures hold basic single values (like `int`, `boolean`) and are typically stored directly in memory (often on the stack). Non-primitive structures (like arrays, objects/classes) can hold multiple values or complex data and are stored as references (often on the heap). A scenario where a non-primitive structure is essential is storing a collection of student records, where each record contains related data like ID, name, and grades grouped together as a single logical entity.

## Question 3
Binary search relies on the principle of systematically eliminating half of the remaining search space at each step, which is only possible if the data is ordered (so we know which half to discard based on comparisons). The essential property is that the data must be sorted. If sorting is required before searching, the time complexity cost is typically O(n log n), which overshadows the O(log n) cost of the search itself.
