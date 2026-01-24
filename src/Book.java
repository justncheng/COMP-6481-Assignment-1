public class Book {

    private String title;
    private String author;
    private long ISBN;
    private double price;

    private static int nbOfCreatedBooks;

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
        return nbOfCreatedBooks;
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
