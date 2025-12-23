
import java.util.ArrayList;

public class Member {
    private int memberId;
    private String name;
    private String contact;
    private ArrayList<Book> borrowedBooks;

    public Member(int memberId, String name, String contact) {
        this.memberId = memberId;
        this.name = name;
        this.contact = contact;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
