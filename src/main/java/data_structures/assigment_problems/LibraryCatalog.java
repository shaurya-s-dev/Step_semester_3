package data_structures.assigment_problems;

public class LibraryCatalog {
    public static class BookRecord {
        String isbn;
        String title;
        
        public BookRecord(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }
    
    public static String findBook(BookRecord[] catalog, String targetIsbn) {
        int left = 0;
        int right = catalog.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);
            
            if (cmp == 0) {
                return catalog[mid].title;
            } else if (cmp < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return "Not Found";
    }
}
