package Exception;


class BookNotAvailableException extends Exception {
    public BookNotAvailableException(String message) {
        super(message);
    }
}

class Book {
    String title, author;
    boolean isAvailable = true;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    void borrowBook() throws BookNotAvailableException {
        if (!isAvailable)
            throw new BookNotAvailableException("Book already borrowed: " + title);
        isAvailable = false;
        System.out.println(title + " borrowed successfully.");
    }

    void returnBook() {
        isAvailable = true;
        System.out.println(title + " returned successfully.");
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("Java Basics", "James Gosling");
        try {
            b1.borrowBook();
            b1.borrowBook(); // second attempt → throws exception
        } catch (BookNotAvailableException e) {
            System.out.println("Error: " + e.getMessage());
        }
        b1.returnBook();
    }
}

