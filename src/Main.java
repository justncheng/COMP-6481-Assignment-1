import java.util.Scanner;

public class Main {

    private static final String password = "password"; // Setting the password to "password"
    private static final int MAX_PASSWORD_ATTEMPTS = 3; // Max number of attempts for 1 cycle
    private static final int MAX_FAILED_CYCLES = 4; // Max number of cycles before shutting down

    // Helper function to verify the passwords of a user
    public static boolean checkPassword(String password) {
        for (int i = 0; i < MAX_PASSWORD_ATTEMPTS; i++) {
            System.out.println("Enter password: ");
            Scanner sc = new Scanner(System.in);
            String passwordInput = sc.nextLine();
            if(passwordInput.equals(password)) {
                return true;
            }
            System.out.println("Wrong password!");
        }
        return false;
    }

    // Find all the books by a certain author
    public static void findBooksBy(String author, Book[] inventory) {
        for (Book book : inventory) {
            if (book.getAuthor().equals(author)) {
                System.out.println(book);
            }
        }
    }

    // Finds all the books that are cheaper than a certain price
    public static void findCheaperThan(double price, Book[] inventory) {
        for (Book book : inventory) {
            if (book.getPrice() < price) {
                System.out.println(book);
            }
        }
    }

    public static void displayMenu(){
        System.out.println("\nWhat do you want to do?");
        System.out.println("1. Enter new books (password required)");
        System.out.println("2. Change information of a book (password required)");
        System.out.println("3. Display all books by a specific author");
        System.out.println("4. Display all books under a certain price");
        System.out.println("5. Quit");
        System.out.print("Please enter your choice > ");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); // Create scanner sc

        System.out.println("Welcome to the bookstore!");
        System.out.println("What is the maximum number of books in your store?");

        int max = sc.nextInt(); // Max number of books an bookstore may contain
        Book[] inventory = new Book[max]; // Creation of an array with the max number of books

        int choice = 0;

        while (choice != 5) {
            displayMenu();
            choice = sc.nextInt();

            switch (choice) {
                case 1: // Enter a new book
                    boolean authenticated = false;

                    int counter = 0;
                    do while (!password.equals(sc.next()) && counter < 3) {
                        System.out.print("Enter the book password: ");
                        String passwordAttempt = sc.next();
                        counter++;
                    }
                case 2:

                case 3:
                    System.out.println("Enter an author name: ");
                    String author = sc.next();
                    findBooksBy(author, inventory);
                case 4:
                    System.out.println("Enter the price of the book: ");
                    int price = sc.nextInt();
                    findCheaperThan(price, inventory);
                case 5:
                    System.out.println("Goodbye!");
                    break;
            }
        }


    }
}