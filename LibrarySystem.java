
import java.util.Scanner;

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();

        // Sample data
        library.addBook(new Book("978-1", "Clean Code", "Robert Martin", "Programming"));
        library.addBook(new Book("978-2", "Java Basics", "James Gosling", "Programming"));

        library.addMember(new Member(1, "Dharshana", "9876543210"));

        while (true) {
            System.out.println("\n--- Library Management System ---");
            System.out.println("1. Search Book by Title");
            System.out.println("2. Search Book by Author");
            System.out.println("3. Borrow Book");
            System.out.println("4. Return Book");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter title: ");
                    library.searchByTitle(sc.nextLine());
                    break;

                case 2:
                    System.out.print("Enter author: ");
                    library.searchByAuthor(sc.nextLine());
                    break;

                case 3:
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    int mid = sc.nextInt();
                    library.borrowBook(isbn, mid);
                    break;

                case 4:
                    System.out.print("Enter ISBN: ");
                    String risbn = sc.nextLine();
                    System.out.print("Enter Member ID: ");
                    int rmid = sc.nextInt();
                    library.returnBook(risbn, rmid);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
