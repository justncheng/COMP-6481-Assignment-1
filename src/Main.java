import java.util.Scanner;

public class Main {

    private static final String password = "password"; // Setting the password to "password"
    private static final int MAX_PASSWORD_ATTEMPTS = 3; // Max number of attempts for 1 cycle
    private static final int MAX_FAILED_CYCLES = 4; // Max number of cycles before shutting down

    // Helper function to verify the passwords of a user
    private static boolean authenticateOwner() {
        final String PASSWORD = "password";
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= MAX_PASSWORD_ATTEMPTS; i++) {
            System.out.println("Enter owner password: ");
            String entered = sc.next();
            if (entered.equals(password)) {
                return true;
            }
            System.out.println("Incorrect password. Attempt " + i + " of 3.");
        }
        return false; // 3 failed attempts
    }

    // Find all the books by a certain author
    public static void findBooksBy(String author, Book[] inventory) {

        if (inventory == null || inventory.length == 0 ) {
            System.out.println("No books found.");
            return;
        }

        boolean found = false;
        for (Book book : inventory) {
            if (book != null && book.getAuthor().equals(author)) {
                System.out.println(book);
                System.out.println("");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found by author " + author);
        }
    }

    // Finds all the books that are cheaper than a certain price
    public static void findCheaperThan(double price, Book[] inventory) {
        if (inventory == null || inventory.length == 0) {
            System.out.println("No books found.");
            System.out.println("");
            return;
        }

        boolean found = false;
        for (Book book : inventory) {
            if (book != null && book.getPrice() < price) {
                System.out.println(book);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found less than " + price);
        }
    }

    public static void updateBook(Book[] inventory) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("What book would you like to change?");
            int index = sc.nextInt();

            if(inventory[index] == null) {
                System.out.println("No book found at index " + index);
                System.out.println("Enter an option: ");
                System.out.println("1. Change book information");
                System.out.println("2. Exit");
                System.out.print("Please enter your choice (1-2) > ");

                int select1 = sc.nextInt();
                if(select1 == 1) {
                    continue;
                }
                else{
                    return;
                }
            }

            Book b = inventory[index];
            System.out.println(inventory[index]);

            while(true) {
                System.out.println("What information would you like to change?");
                System.out.println("1. Author");
                System.out.println("2. Title");
                System.out.println("3. ISBN");
                System.out.println("4. Price");
                System.out.println("5. Exit");
                System.out.print("Please enter your choice (1-5) > ");
                int select2 = sc.nextInt();
                sc.nextLine();

                if (select2 == 1) {
                    System.out.println("Enter author: ");
                    String author = sc.nextLine();
                    b.setAuthor(author);
                } else if (select2 == 2) {
                    System.out.println("Enter title: ");
                    String title = sc.nextLine();
                    b.setTitle(title);
                } else if (select2 == 3) {
                    System.out.println("Enter ISBN: ");
                    long isbn = sc.nextLong();
                    b.setISBN(isbn);
                } else if (select2 == 4) {
                    System.out.println("Enter price: ");
                    double price = sc.nextDouble();
                    b.setPrice(price);
                } else if (select2 == 5) {
                    System.out.println("Exit");
                    return;
                }

                System.out.println("Updated book info: ");
                System.out.println(inventory[index]);
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
        int max;

        System.out.println("Welcome to the bookstore!");
        do
        {
            System.out.println("What is the maximum number of books in your store?");
            while (!sc.hasNextInt())
            {
                System.out.println("Invalid input. Enter a non-negative number.");
                sc.nextLine();
            }
            max = sc.nextInt();
            sc.nextLine();

            if (max < 0) {
                System.out.println("Maximum number cannot be negative.");
            }
        } while(max < 0);

        Book[] inventory = new Book[max]; // Creation of an array with the max number of books

        int failedCycle = 0; // Counts the number of failed cycles for choice 1

        while (true) {
            displayMenu();
            int choice = sc.nextInt();

            switch (choice) {
                case 1: // Enter a new book
                    boolean authenticated1 = authenticateOwner();
                    if (!authenticated1) {
                        failedCycle++;
                        if(failedCycle == MAX_FAILED_CYCLES) {
                            System.out.println("Program detected suspicous activities and will terminate immediately!");
                            System.exit(0);
                        }
                        break;
                    }
                    int nbBooks;

                    sc.nextLine();

                    while (true) {
                        System.out.println("Enter number of books to create: ");
                        if (!sc.hasNextInt()) {
                            System.out.println("Invalid input. Enter a valid number.");
                            sc.nextLine();
                            continue;
                        }

                        nbBooks = sc.nextInt();
                        sc.nextLine();

                        if (nbBooks < 0) {
                            System.out.println("Number of books cannot be negative.");
                        } else {
                            break;
                        }
                    }
                    int remainingSpace = inventory.length - Book.getNbOfCreatedBooks();

                    if(nbBooks < remainingSpace) {
                        for (int i = 0; i < nbBooks; i++) {
                            System.out.println("Entering book #" + Book.getNbOfCreatedBooks());

                            System.out.println("Enter title: ");
                            String title = sc.nextLine();

                            System.out.println("Enter author: ");
                            String author = sc.nextLine();

                            System.out.println("Enter ISBN: ");
                            long isbn = sc.nextLong();
                            sc.nextLine();

                            System.out.println("Enter price: ");
                            double price = sc.nextDouble();
                            sc.nextLine();

                            inventory[Book.getNbOfCreatedBooks()] = new Book(title, author, isbn, price);
                            Book.incrementBookCounter();
                        }
                    }
                    else {
                        System.out.println("You don't have enough space in your inventory to add all books.\n"
                                + "There are " + remainingSpace + " space(s) left in your inventory.");
                    }

                    break;

                case 2:
                    boolean authenticated2 = authenticateOwner();
                    if (!authenticated2) {
                        break;
                    }
                    updateBook(inventory);
                    break;
                case 3:
                    System.out.println("Enter an author name: ");
                    String author = sc.next();
                    findBooksBy(author, inventory);
                    break;
                case 4:
                    double price;

                    //clear any leftover newline before reading
                    sc.nextLine();

                    while (true) {
                        System.out.print("Enter the price of the book: ");

                        if (!sc.hasNextDouble()) {
                            System.out.println("Invalid input. Enter a numeric price.");
                            sc.nextLine(); // discard bad input
                            continue;
                        }

                        price = sc.nextDouble();
                        sc.nextLine();

                        if (price < 0) {
                            System.out.println("Price cannot be negative.");
                        } else {
                            break;
                        }
                    }

                    findCheaperThan(price, inventory);
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                default:
                    System.out.println();
                    System.out.println("Invalid Choice Try Again!");
            }
        }


    }
}