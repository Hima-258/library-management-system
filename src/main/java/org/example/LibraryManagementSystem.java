import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int id;
    String title;
    String author;
    boolean available;

    Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    void displayBook() {
        System.out.println(
                "ID: " + id +
                        " | Title: " + title +
                        " | Author: " + author +
                        " | Available: " + available
        );
    }
}

class Member {
    int id;
    String name;
    String email;

    Member(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    void displayMember() {
        System.out.println(
                "ID: " + id +
                        " | Name: " + name +
                        " | Email: " + email
        );
    }
}gu

public class git  s {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    // Add Book
    static void addBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        books.add(new Book(id, title, author));

        System.out.println("Book added successfully!");
    }

    // Display Books
    static void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book book : books) {
            book.displayBook();
        }
    }

    // Add Member
    static void addMember() {
        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        members.add(new Member(id, name, email));

        System.out.println("Member added successfully!");
    }

    // Display Members
    static void displayMembers() {
        if (members.isEmpty()) {
            System.out.println("No members available.");
            return;
        }

        for (Member member : members) {
            member.displayMember();
        }
    }

    // Issue Book
    static void issueBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {

                if (book.available) {
                    book.available = false;
                    System.out.println("Book issued successfully!");
                } else {
                    System.out.println("Book is already issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Return Book
    static void returnBook() {
        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        for (Book book : books) {
            if (book.id == id) {

                if (!book.available) {
                    book.available = true;
                    System.out.println("Book returned successfully!");
                } else {
                    System.out.println("Book was not issued.");
                }

                return;
            }
        }

        System.out.println("Book not found.");
    }

    // Search Book
    static void searchBook() {
        sc.nextLine();

        System.out.print("Enter book title: ");
        String title = sc.nextLine();

        boolean found = false;

        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                book.displayBook();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Book not found.");
        }
    }

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Add Member");
            System.out.println("4. Display Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    addMember();
                    break;

                case 4:
                    displayMembers();
                    break;

                case 5:
                    issueBook();
                    break;

                case 6:
                    returnBook();
                    break;

                case 7:
                    searchBook();
                    break;

                case 8:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 8);

        sc.close();
    }
}