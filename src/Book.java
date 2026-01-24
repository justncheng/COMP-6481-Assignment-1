/**
 * -----------------------------------------------------
 * Assignment #: 1
 * Course: COMP6481
 * Due Date: January 30 2026
 * Written by: Cristian Gasparesc 40209205, Justin Cheng 40210279
 * -----------------------------------------------------
 */

/**
 * The Book class is the blueprint for a book object with a title, author,
 * ISBN number, and price. It contains constructors, accessors,
 * mutators, and utility methods to manipulate and display
 * book information. Our program is user friendly as it has clear instructions
 * for users on how to find the information that they require.
 */

public class Book {

    private String title;
    private String author;
    private long ISBN;
    private double price;

    private static int bookCounter = 0;

    // Default constructor
    public Book() {
        this.title = "";
        this.author = "";
        this.ISBN = 0;
        this.price = 0;
    }

    // Parameterized Constructor
    public Book(String title, String author, long ISBN, double price) {
        this.title = title;
        this.author = author;
        this.ISBN = ISBN;
        this.price = price;
    }

    // Copy constructor
    public Book(Book book) {
        this(book.title, book.author, book.ISBN, book.price);
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Find the total number of created books
    public static int getNbOfCreatedBooks() {
        return bookCounter;
    }

    // Increment the number of books in the inventory
    public static void incrementBookCounter() {
        bookCounter++;
    }

    // toString() method
    public String toString() {
        return "Title: " + title + "\nAuthor: " + author + "\nISBN: " + ISBN + "\nPrice: " + price;
    }

    // equals method
    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass())
            return false;

        Book other = (Book) obj;
        return this.ISBN == other.ISBN && this.price == other.price;
    }
}
