// Library.java
public class Library {
    private int availableBooks;
    
    public Library(int initialBooks) {
        availableBooks = initialBooks;
    }
    
    public void borrowBook() {
        if (availableBooks > 0) {
            availableBooks--;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("No books available!");
        }
    }
    
    public void returnBook() {
        availableBooks++;
        System.out.println("Book returned successfully!");
    }
    
    public int getAvailableBooks() {
        return availableBooks;
    }
}