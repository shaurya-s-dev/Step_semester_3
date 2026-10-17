# Part B — Quiz

- **Q1:** A, B, D, E  
  *(A concrete class can always be instantiated; an abstract type can have constructors and hold state; a type with at least one abstract operation must be declared abstract; an interface can define default operations).*
- **Q2:** A  
  *(Inheritance represents an "IS-A" family relationship sharing identity and state; interfaces represent a "CAN-DO" capability shared across unrelated types).*
- **Q3:** A, C, E  
  *(Operations in an interface are implicitly public; operations are implicitly abstract unless declared default, static, or private; an interface can extend multiple other interfaces).*
- **Q4:** C  
  *(The primary purpose of overriding `toString()` is to provide a meaningful self-description for logging, debugging, and display).*
- **Q5:** C  
  *(The hashCode() method must be redefined such that equal objects according to `equals()` produce equal hash values to ensure correct hashing collection behavior).*
- **Q6:** C  
  *(In a shallow copy, object references are copied rather than duplicated; modifying the mutable nested object through one copy directly reflects in the original).*
- **Q7:** C  
  *(Inserting or deleting in the middle of a fixed-size array requires shifting subsequent elements forward or backward, resulting in $O(n)$ time complexity).*
- **Q8:** A  
  *(Accessing an array element by index is an $O(1)$ constant-time operation calculated directly via base address + index * element size).*
- **Q9:** B  
  *(The data set must be sorted in ascending or descending order for binary search to correctly eliminate half the search space at each comparison).*
- **Q10:** C  
  *(Linear search checks elements one-by-one in $O(n)$ worst-case time, while binary search repeatedly halves the search space in $O(\log n)$ worst-case time).*

---

# Part C — Concept Questions

### Question 1: Abstract Type vs. Interface
- **Core Distinction:** An **abstract class** represents an *IS-A* hierarchical relationship that can hold mutable instance state (fields), constructors, and partial concrete implementations. An **interface** represents a *CAN-DO* contract or capability that unrelated classes can implement, defining public behaviors without holding per-instance state.
- **Use Cases & Abstraction:** Use abstract classes for closely related types sharing common code, state, and lifecycle initialization (e.g., base `Device` or `LibraryResource`). Use interfaces to define contracts that cross-cut unrelated class hierarchies (e.g., `Dimmable`, `Reservable`, `Downloadable`). In Java 8+, interfaces support `default` and `static` methods, but they still cannot possess instance fields or constructors.

### Question 2: The Equality Contract & Consistency with Hash Values
- **The Equality Contract:** The `equals(Object o)` method establishes equivalence relation (reflexive, symmetric, transitive, consistent, and null-hostile).
- **Consistency with `hashCode()`:** If two objects are equal according to `equals(Object)`, they **must** return the identical integer value from `hashCode()`.
- **Implications in Hash-Based Collections:** Collections like `HashSet` and `HashMap` use `hashCode()` to route objects to specific hash buckets before invoking `equals()`. If `equals()` is overridden without a consistent `hashCode()`, two logically equal objects will produce different hash codes and land in different buckets. Consequently, `contains()`, `get()`, or duplicate checks fail, violating collection set invariants.

### Question 3: Instance-Bound (Inner) vs. Independent (Static) Nested Types
- **Inner Class (Non-Static):** Strongly bound to an instance of the enclosing outer class. It holds an implicit reference to the outer instance (`Outer.this`) and has full access to all instance fields and methods of the enclosing class. It cannot exist without an outer class instance.
  - *Preferred when:* The nested object represents an internal helper or component that intrinsically depends on the state of a specific outer instance (e.g., custom iterator).
- **Static Nested Class:** Independent of any instance of the enclosing class. It behaves like a top-level class nested namespace-wise within the outer class and cannot directly access non-static outer members without an explicit outer reference.
  - *Preferred when:* The nested class is logically grouped with the outer class for packaging and cohesion, but does not need access to outer instance variables (e.g., `Node`, `PriceRangeResult`, `Customer`). It avoids the memory overhead of an outer instance reference and prevents potential memory leaks.

### Question 4: Performance of Array Insertion/Deletion and Mitigation Strategies
- **Performance Characteristics:** Both insertion and deletion in the middle of a fixed-size linear array take $O(n)$ time.
- **Why Costly:** Arrays occupy contiguous blocks of memory. Inserting an element requires shifting all elements from the target index to the end one position to the right. Deleting requires shifting all subsequent elements one position to the left.
- **Mitigation Strategies:**
  1. *Linked Lists:* Provide $O(1)$ node insertion and deletion once the pointer reference is obtained.
  2. *Gap Buffers / Deques:* Allow localized insertions and deletions around an active cursor.
  3. *Balanced Search Trees or Hash Tables:* Provide $O(\log n)$ or $O(1)$ dynamic insertion/deletion without mass shifting.

### Question 5: Linear Search vs. Binary Search Trade-offs
- **Linear Search:** Requires $O(n)$ worst-case and average time. It operates directly on unsorted data and works on all sequential structures (including linked lists and streams).
- **Binary Search:** Requires $O(\log n)$ worst-case time, but strictly mandates random access in $O(1)$ and that the data is already sorted.
- **Decision Matrix & Conditions:**
  - *Choose Linear Search:* When data is unsorted, the dataset is small, or queries are rare (one-off searches where the $O(n \log n)$ pre-sorting cost exceeds the cost of a single $O(n)$ scan).
  - *Choose Binary Search:* When data is already maintained in sorted order, the dataset is large, or when query frequency is high (where paying an initial sorting cost amortizes to near-zero over thousands of subsequent $O(\log n)$ queries).
