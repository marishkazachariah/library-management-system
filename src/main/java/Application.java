import java.util.ArrayList;
import java.util.List;

import static java.lang.System.*;

public class Application {
    public void run() {
        // Day 1 - Annotations
        Inventory inventory = new Inventory();

        List<Book> usersBooks = new ArrayList<>();
        usersBooks.add(new Book(23, "MFSDF3243423","Title 1", "J.F.D") );
        usersBooks.add(new Book(434, "MFSDF3243423","Title 2", "P. Yoon") );
        usersBooks.add(new Book(532, "BRWEW3463464","Title 3", "E. Dent") );
        usersBooks.add(new Book(6456, "RG36346DGDdF","Title 4", "M. Poole") );
        usersBooks.add(new Book(5465, "DFGDF4534534","Title 5", "S. Stowl") );

        Member newMember = new Member("3242", "John", "john@example.com", 12, usersBooks);
        UserValidator userValidator = new UserValidator();

        try {
            userValidator.validateUser(Inventory.class.getMethod("registerMember", Member.class), newMember);
            inventory.registerMember(newMember);
        } catch (Exception e) {
            out.println("Validation error: " + e.getMessage());
        }

        try {
            userValidator.validateBookAmount(Inventory.class.getMethod("registerMember", Member.class), newMember);
            inventory.registerMember(newMember);
        } catch (Exception e) {
            out.println("Validation error: " + e.getMessage());
        }

        Book book = new Book(345, "The Adventure Book", "GMRET4353463M", "Jane G.");

        // Check book availability
        inventory.processBookAvailability(book);

        // Day 2 - Collections
        Library library = new Library();

        library.addBook(new Book(1, "The Great Gatsby", "9780385547345", "F. Scott Fitzgerald"));
        library.addBook(new Book(2, "To Kill a Mockingbird", "778075649843", "Harper Lee"));
        library.addMember(new Member("101", "Mary", "mart@emxaple.com", 18, usersBooks));
        library.addMember(new Member("102", "Bob", "bob@example.com", 20, usersBooks));

        Book searchBook = library.searchBook(2);
        Member member = library.searchMember("102");

        if (searchBook != null) {
            System.out.println("Found Book: " + book);
        } else {
            System.out.println("Book not found.");
        }

        if (member != null) {
            System.out.println("Found Member: " + member);
        } else {
            System.out.println("Member not found.");
        }

        library.removeBook(new Book(1, "The Great Gatsby", "9780385547345", "F. Scott Fitzgerald"));

        library.displayBooks();
        library.addBook(book);
        library.addBookToFavorites(book);

        library.searchBookByTitle("The Great Gatsby");
        library.searchBookByAuthor("Harper Lee");

        // Day 3 - Streams
        System.out.println(library.searchBookByAuthorStreams("Harper Lee"));
        System.out.println(library.searchBookByTitleStreams("The Great Gatsby"));
        System.out.println(library.sortMembersByName());

        // Day 4 - Queue Data Structure
    }
}
