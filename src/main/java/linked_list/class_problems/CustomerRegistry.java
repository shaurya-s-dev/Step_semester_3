package linked_list.class_problems;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Problem 2: Customer Registry
 *
 * TASK:
 * Design a Customer class with an ID and name. Implement a customer registry system that stores
 * Customer objects in a collection where only unique customers are counted, even if they are added
 * from different branches. Specifically, if two Customer objects represent the same real-world customer
 * (i.e., same ID and name), they should be considered equal for the purpose of unique counts and behave
 * correctly in hash-based collections (like a HashSet or HashMap keys).
 * The system should report whether a customer already exists and the total unique customer count.
 */
public class CustomerRegistry {

    public static class Customer {
        private int id;
        private String name;

        public Customer(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Customer customer = (Customer) o;
            return id == customer.id && Objects.equals(name, customer.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name);
        }

        @Override
        public String toString() {
            return "(" + id + ", " + name + ")";
        }
    }

    private Set<Customer> registry = new HashSet<>();

    /**
     * Adds a customer to the registry.
     *
     * @param customer Customer to add
     * @return "true" if newly added, or "false (duplicate rejected)" if duplicate
     */
    public String addCustomer(Customer customer) {
        boolean added = registry.add(customer);
        if (added) {
            return "true";
        } else {
            return "false (duplicate rejected)";
        }
    }

    public boolean contains(Customer customer) {
        return registry.contains(customer);
    }

    public int getUniqueCount() {
        return registry.size();
    }
}
