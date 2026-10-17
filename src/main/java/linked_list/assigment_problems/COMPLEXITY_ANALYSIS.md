# Category A · Coding Assignment: Linked Lists — Complexity & Conceptual Analysis

## Problem 2: Merging Two Ticket Counters
- **Naive Array Approach:**
  - Copy all $m$ nodes of list `a` and $n$ nodes of list `b` into an array of size $m + n$.
  - Sort the array using standard comparison sort: $O((m + n) \log(m + n))$ time.
  - Rebuild or populate a linked list: $O(m + n)$ time and $O(m + n)$ auxiliary space.
- **Optimized Two-Pointer Relinking:**
  - **Time Complexity:** $O(m + n)$. We traverse through the two lists in lockstep, comparing the two heads and advancing one pointer each iteration. Each node is inspected and relinked at most once.
  - **Auxiliary Space Complexity:** $O(1)$. No new list nodes are allocated; only a single dummy node and a tail pointer are used to stitch existing nodes together in-place.
- **Why Relinking is Superior:** It eliminates the $O(\log(m + n))$ sorting factor and avoids allocating heap memory for $m + n$ elements.

---

## Problem 5: Cancelling the k-th Last Order
- **Time Complexity:** $O(n)$ where $n$ is the length of the list. Exactly one pass is made: `lead` advances $k + 1$ steps, and then `lead` and `trail` advance together until `lead` reaches `null`.
- **Auxiliary Space Complexity:** $O(1)$ extra space using only two pointer references (`lead` and `trail`) and one dummy node.
- **Handling Head Removal Without Special Cases:**
  - By using a dummy node preceding `head` (`dummy.next = head`), `trail` starts at `dummy`.
  - With `lead` positioned $k + 1$ steps ahead, when the target node is the head ($k = n$), `lead` reaches `null` while `trail` remains at `dummy`.
  - Executing `trail.next = trail.next.next` unlinks the original head directly, and `dummy.next` points to the new head. No special-case `if (k == length)` or null checks are required.

---

## Problem 6: Campus Portal Browser History
- **Cost of Operations:**
  - `visit(url)`: $O(1)$ time. Allocates a new doubly linked list node, sets `curr.next = newNode`, `newNode.prev = curr`, and advances `curr`.
  - `back(steps)`: $O(\min(\text{steps}, B))$ where $B$ is the number of backward pages available.
  - `forward(steps)`: $O(\min(\text{steps}, F))$ where $F$ is the number of forward pages available.
- **Space Complexity:** $O(N)$ where $N$ is the total number of live reachable pages in history.
- **Discarding Forward History:**
  - When `visit(url)` is invoked, `curr.next` is reassigned to the newly visited node.
  - The previous chain of nodes that extended forward from `curr` is disconnected from the list.
  - Because no active reference in the application retains those forward nodes, the Java Garbage Collector identifies them as unreachable and automatically reclaims their memory.

---

## Problem 9: Polynomial Calculator
- **Time Complexity:** $O(m + n)$ where $m$ and $n$ are the number of terms in polynomials $p$ and $q$. Each list is visited exactly once in decreasing order of exponents, comparing at most one term from each list per step.
- **Auxiliary Space Complexity:** $O(m + n)$ to allocate nodes for the resulting polynomial list, which contains at most $m + n$ terms (excluding terms whose coefficients sum to 0).
- **Standard Form Formatting:**
  - Terms are output in descending order of exponents.
  - Signs (`+` and `-`) are spaced (`5x^3 + 9x^2 - 3x + 3`), except for a negative leading term (`-3x^2 + 4x`).
  - Unit coefficients ($\pm 1$) for $x^k$ ($k \ge 1$) omit the number 1 (e.g. $x^2$, not $1x^2$).
  - Zero-exponent terms display only the constant value.
  - If all terms cancel out, the output is `0`.

---

## Problem 10: The Palindrome Train Code
- **Time Complexity:** $O(n)$ where $n$ is the number of nodes in the train code list:
  1. Finding the midpoint with slow/fast pointers: $\approx n/2$ steps.
  2. In-place reversal of the second half: $\approx n/2$ steps.
  3. Comparing first half and second half: $\approx n/2$ steps.
  4. In-place re-reversal to restore original structure: $\approx n/2$ steps.
  - Total operations $\approx 2n = O(n)$.
- **Auxiliary Space Complexity:** $O(1)$. Uses only constant pointer variables (`slow`, `fast`, `prev`, `curr`, `nextTemp`). No array or recursion stack copies.
- **Comparison with Copying into an Array:**
  - An array copy approach requires $O(n)$ auxiliary memory to duplicate list values, which for $n = 10^5$ allocates megabytes of heap memory.
  - The in-place reversal and restoration algorithm satisfies the strict $O(1)$ memory constraint while leaving the list completely unchanged upon completion.
