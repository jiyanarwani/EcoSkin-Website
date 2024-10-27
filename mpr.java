import java.util.ArrayList;
import java.util.Scanner;

// Book class
class Book {
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void issueBook() {
        if (!isIssued) {
            isIssued = true;
            System.out.println("The book '" + title + "' has been issued.");
        } else {
            System.out.println("Sorry, the book is already issued.");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println("The book '" + title + "' has been returned.");
        } else {
            System.out.println("This book was not issued.");
        }
    }
}

// Member class
class Member {
    private String name;
    private ArrayList<Book> issuedBooks;

    public Member(String name) {
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void issueBook(Book book) {
        if (book.isIssued()) {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is already issued.");
        } else {
            issuedBooks.add(book);
            book.issueBook();
        }
    }

    public void returnBook(Book book) {
        if (issuedBooks.contains(book)) {
            issuedBooks.remove(book);
            book.returnBook();
        } else {
            System.out.println("You don't have this book issued.");
        }
    }

    public void listIssuedBooks() {
        if (issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
        } else {
            System.out.println("Books issued by " + name + ":");
            for (Book book : issuedBooks) {
                System.out.println(" - " + book.getTitle());
            }
        }
    }
}

// Library class
class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        this.books = new ArrayList<>();
        this.members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book '" + book.getTitle() + "' added to the library.");
    }

    public void addMember(Member member) {
        members.add(member);
        System.out.println("Member '" + member.getName() + "' added to the library.");
    }

    public Book findBook(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Book '" + title + "' not found.");
        return null;
    }

    public Member findMember(String name) {
        for (Member member : members) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        System.out.println("Member '" + name + "' not found.");
        return null;
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        // Sample data
        library.addBook(new Book("Java Programming", "John Doe"));
        library.addBook(new Book("Data Structures", "Jane Smith"));
        library.addMember(new Member("Alice"));
        library.addMember(new Member("Bob"));

        int choice;
        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Issue Book");
            System.out.println("2. Return Book");
            System.out.println("3. List Issued Books");
            System.out.println("4. Add Book");
            System.out.println("5. Add Member");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume leftover newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter member name: ");
                    String memberName = scanner.nextLine();
                    Member member = library.findMember(memberName);
                    if (member != null) {
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        Book book = library.findBook(bookTitle);
                        if (book != null) {
                            member.issueBook(book);
                        }
                    }
                    break;
                case 2:
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    member = library.findMember(memberName);
                    if (member != null) {
                        System.out.print("Enter book title: ");
                        String bookTitle = scanner.nextLine();
                        Book book = library.findBook(bookTitle);
                        if (book != null) {
                            member.returnBook(book);
                        }
                    }
                    break;
                case 3:
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    member = library.findMember(memberName);
                    if (member != null) {
                        member.listIssuedBooks();
                    }
                    break;
                case 4:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();
                    library.addBook(new Book(title, author));
                    break;
                case 5:
                    System.out.print("Enter member name: ");
                    memberName = scanner.nextLine();
                    library.addMember(new Member(memberName));
                    break;
                case 0:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}