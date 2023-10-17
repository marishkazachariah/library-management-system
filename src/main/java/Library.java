import java.util.*;

public class Library {
    private List<Book> books;
    private Map<Integer, Book> bookMap;
    private Set<Member> members;
    private Set<Book> favoriteBooks;

    public Library() {
        this.books = new ArrayList<>();
        this.bookMap = new HashMap<>();
        this.members = new HashSet<>();
        this.favoriteBooks = new HashSet<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public Book searchBook(int bookId) {
        for(Book book: books) {
            if(book.getId() == bookId) {
                return book;
            }
        }
        System.out.println("This book does not exist in this library.");
        return null;
    }

    public void updateBook(Book oldBook, Book newBook) {
        if(books.contains(oldBook)) {
            books.set(books.indexOf(oldBook), newBook);
        } else {
            System.out.println("This book does not exist in this library.");
        }
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> searchResults = new ArrayList<>();
        for(Book book: books) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                searchResults.add(book);
                System.out.println("search results: " + searchResults);
            }
        }
        return searchResults;
    }

    public List<Book> searchBookByTitle(String title) {
        List<Book> searchResults = new ArrayList<>();
        for(Book book: books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                searchResults.add(book);
                System.out.println(searchResults);
            }
        }
        return searchResults;
    }

    public void displayBooks() {
       for(Book book: books) {
           System.out.println("- Title: " + book.getTitle() + " Author: " + book.getAuthor());
       }
    }

    public void addBookToFavorites(Book book){
        favoriteBooks.add(book);
    }

    public void removeBookFromFavorites(Book book) {
        favoriteBooks.remove(book);
    }



    public void displayFavorites() {
        for(Book book: favoriteBooks) {
            System.out.println("- Title: " + book.getTitle() + " Author: " + book.getAuthor());
        }
    }

    public void addMember(Member member) {
        members.add(member);
    }

    public void deleteMember(Member member) {
        members.remove(member);
    }

    public Member searchMember(String memberId) {
        for(Member member: members) {
            if(member.getId().equalsIgnoreCase(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void editMember(Member oldMember, Member newMember) {
        if(members.contains(oldMember)) {
            members.remove(oldMember);
            members.add(newMember);
        } else {
            System.out.println("This member does not exist in this library.");
        }
    }

    public void viewMembers() {
        for(Member member: members) {
            System.out.println("- ID: " + member.getId() + " Name: " + member.getName());
        }
    }
}
