# Category A · Part B Quiz & Part C Concept Questions

## Part B — Quiz
- **Q1:** B (newNode.next = node.next; then node.next = newNode;)
- **Q2:** C (Employing two pointers moving at different speeds)
- **Q3:** D (Approximately at the middle of the list)
- **Q4:** C (O(1) constant space)
- **Q5:** D (O(1) constant space)
- **Q6:** C (It simplifies the logic by handling edge cases where the head node changes without special conditional checks.)
- **Q7:** B (A singly linked list)
- **Q8:** C (O(m + n) time, O(m) space)
- **Q9:** C (The portion of the list that follows the current node will become unreachable.)
- **Q10:** C (A runtime error, such as a NullPointerException, will occur.)

---

## Part C — Concept Questions

### Question 1: Singly vs. Doubly Linked Lists
A singly linked list stores only one forward pointer per node (`next`), whereas a doubly linked list stores two pointers per node (`prev` and `next`), increasing memory overhead. However, doubly linked lists efficiently support bidirectional traversal and $O(1)$ deletion of a given node reference without requiring a search for its predecessor. The risk of pointer manipulation errors is higher in doubly linked lists because every insert/delete requires maintaining two pointers symmetrically. The increased overhead of a doubly linked list is justified in applications requiring frequent backwards navigation or direct node deletions, such as LRU caches, browser history, or text editor cursors.

### Question 2: Cycle Detection — Two Pointers vs. Hash Set
Using a hash-based set requires $O(n)$ time and $O(n)$ extra space to store references to visited nodes. The two-pointer (Floyd's Tortoise and Hare) approach uses $O(n)$ time and $O(1)$ extra space. Mathematically, inside a cycle of length $C$, the relative distance between the fast pointer (speed 2) and slow pointer (speed 1) decreases by 1 node per iteration step (i.e., $(2 - 1) = 1$). Because the distance decreases by 1 on every step modulo $C$, the distance will eventually reach 0, guaranteeing they meet in at most $C$ steps once both are inside the cycle.

### Question 3: In-Place Relinking vs. Array Merging
Merging two sorted linked lists by relinking existing nodes achieves $O(1)$ additional space because only pointers (`next`) of existing nodes are rewired; no new nodes or storage buffers need to be allocated. In contrast, merging two sorted arrays cannot easily be done in-place without either $O(m + n)$ shifting operations ($O((m+n)^2)$ time) or allocating a brand new array of size $m + n$ ($O(m+n)$ space). Relinking nodes thus provides a major memory efficiency advantage while retaining $O(m + n)$ time.

### Question 4: Benefit of a Dummy (Sentinel) Node
A dummy node eliminates special-case checks when inserting or deleting at the head of a linked list. By setting `dummy.next = head`, every node in the actual list (including the original head) has a non-null predecessor (`dummy`). For example, in "remove the n-th node from the end", if $n$ equals the length of the list, the node to delete is the head. With a dummy node, the deletion logic `prev.next = prev.next.next` uniformly deletes the head when `prev` is `dummy`, avoiding an explicit `if (n == length) return head.next;` branch.

### Question 5: Common Null-Reference Scenarios & Prevention
1. **Dereferencing past the end (`curr.next.next` when `curr.next` is null):** Occurs in fast pointer algorithms or step-skipping loops. *Prevention:* Use guarded loop conditions, e.g., `while (fast != null && fast.next != null)`.
2. **Accessing an empty list without checks (`head.val` when `head == null`):** Occurs on empty list inputs. *Prevention:* Add guard checks at the entry point (`if (head == null) return;`) or use sentinel dummy nodes.

### Question 6: Roles of `prev`, `current`, and `next` in Reversal
- `current` references the node currently being inverted.
- `prev` holds the head of the already reversed prefix.
- `next` (temporary) preserves the reference to the rest of the unreversed list (`current.next`).
If `current.next` is overwritten to point to `prev` without first saving it into `next`, all subsequent nodes become detached and completely unreachable, causing the rest of the list to be lost.

### Question 7: 'Inserting in the Middle is O(1)' Claim
The statement is technically accurate **only if** you already possess a direct pointer reference to the node immediately before the insertion point. However, in practical applications where position is given by index or key, one must first traverse from the head taking $O(k)$ steps. Therefore, the overall insertion cost is $O(n)$, comparable to an array's shifting cost, though the list lacks array cache locality.

### Question 8: Circular Linked List Traversal
In a circular linked list, the `next` pointer of the last node points back to the head (or first node) rather than `null`. An ideal real-world use case is Round-Robin CPU scheduling, where processes take turns in a repeating ring. The standard `while (current != null)` condition causes an infinite loop because `null` is never reached. Traversal must instead terminate when `current == head` (after the first step) or use a `do-while` loop.

### Question 9: Linked Lists vs. Arrays CPU Cache Performance
Arrays are allocated in contiguous blocks of memory, allowing the CPU hardware prefetcher to load entire cache lines containing neighboring elements (high spatial locality). In contrast, linked list nodes are allocated dynamically on the heap at arbitrary memory locations. Traversal requires following pointer references, resulting in frequent CPU cache misses and pointer chasing, making linked lists noticeably slower in practice despite having the same $O(n)$ asymptotic complexity.

### Question 10: Memory Management of Unreachable Nodes
In garbage-collected environments (like Java), an unreachable node is automatically detected by tracing garbage collectors and reclaimed. In non-garbage-collected languages (like C/C++), simply removing pointers to a node makes it orphaned on the heap without freeing its memory, leading to memory leaks. Cumulative memory leaks eventually exhaust system RAM, causing application degradation or catastrophic out-of-memory crashes.
