import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Member> members;

    public Library() {
        books = new ArrayList<>();
        members = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                book.displayBook();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    public void searchByAuthor(String author) {
        boolean found = false;
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                book.displayBook();
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found for this author.");
        }
    }

    public void borrowBook(String isbn, int memberId) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && book.isAvailable()) {
                for (Member member : members) {
                    if (member.getMemberId() == memberId) {
                        book.setAvailable(false);
                        member.borrowBook(book);
                        System.out.println("Book borrowed successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Book not available or member not found.");
    }

    public void returnBook(String isbn, int memberId) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn) && !book.isAvailable()) {
                for (Member member : members) {
                    if (member.getMemberId() == memberId) {
                        book.setAvailable(true);
                        member.returnBook(book);
                        System.out.println("Book returned successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Invalid return operation.");
    }
}

