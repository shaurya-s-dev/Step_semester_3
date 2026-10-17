package linked_list.class_problems;

import java.util.Arrays;

/**
 * Problem 5: Library Platform
 *
 * TASK:
 * Design and implement a system for a library platform that manages different types of resources
 * (e.g., books, ebooks). All resources have a unique ID. Some resources can be reserved, and some
 * can be downloaded, but not all. The system should store resources in an array, ordered by their ID.
 * Implement functionality to add resources, rejecting duplicates.
 * Also, implement operations for reserving and downloading resources, rejecting commands for unsupported capabilities.
 * Finally, provide a way to find a resource by its ID.
 */
public class LibraryPlatform {

    public interface Reservable {
        String reserve(String memberId);
    }

    public interface Downloadable {
        String download();
    }

    public static abstract class LibraryResource implements Comparable<LibraryResource> {
        protected String id;

        public LibraryResource(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        @Override
        public int compareTo(LibraryResource o) {
            return this.id.compareTo(o.id);
        }
    }

    public static class Book extends LibraryResource implements Reservable {
        public Book(String id) {
            super(id);
        }

        @Override
        public String reserve(String memberId) {
            return id + " reserved for " + memberId;
        }
    }

    public static class EBook extends LibraryResource implements Reservable, Downloadable {
        public EBook(String id) {
            super(id);
        }

        @Override
        public String reserve(String memberId) {
            return id + " reserved for " + memberId;
        }

        @Override
        public String download() {
            return id + " downloaded";
        }
    }

    public static class Platform {
        private LibraryResource[] resources = new LibraryResource[10];
        private int size = 0;

        private void ensureCapacity() {
            if (size == resources.length) {
                resources = Arrays.copyOf(resources, resources.length * 2);
            }
        }

        private int binarySearch(String id) {
            int left = 0;
            int right = size - 1;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                int cmp = resources[mid].getId().compareTo(id);
                if (cmp == 0) {
                    return mid;
                } else if (cmp < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return -(left + 1);
        }

        public String addResource(LibraryResource resource) {
            if (resource == null) return "Invalid resource";

            int idx = binarySearch(resource.getId());
            if (idx >= 0) {
                return "duplicate rejected";
            }

            int insertPos = -(idx + 1);
            ensureCapacity();

            // Shift elements right to preserve sorted order
            for (int i = size; i > insertPos; i--) {
                resources[i] = resources[i - 1];
            }
            resources[insertPos] = resource;
            size++;

            return resource.getId() + " added";
        }

        public String reserveResource(String id, String memberId) {
            int idx = binarySearch(id);
            if (idx < 0) {
                return id + " not found";
            }
            LibraryResource res = resources[idx];
            if (res instanceof Reservable) {
                return ((Reservable) res).reserve(memberId);
            } else {
                return id + " rejected: reserve unsupported";
            }
        }

        public String downloadResource(String id) {
            int idx = binarySearch(id);
            if (idx < 0) {
                return id + " not found";
            }
            LibraryResource res = resources[idx];
            if (res instanceof Downloadable) {
                return ((Downloadable) res).download();
            } else {
                return id + " rejected: download unsupported";
            }
        }

        public String findResource(String id) {
            int idx = binarySearch(id);
            if (idx >= 0) {
                return id + " found at index " + idx;
            } else {
                return id + " not found";
            }
        }
    }
}
