import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        bookMap.put(book.getId(), book);
    }

    public void removeBook(Book book) {
        books.remove(book);
        bookMap.remove(book.getId());
        favoriteBooks.remove(book);
    }

    public Book searchBook(int bookId) {
        // old code
//        for(Book book: books) {
//            if(book.getId() == bookId) {
//                return book;
//            }
//        }
//        System.out.println("This book does not exist in this library.");
//        return null;
        return bookMap.get(bookId);
    }

    public void updateBook(Book oldBook, Book newBook) {
        if(books.contains(oldBook)) {
            books.set(books.indexOf(oldBook), newBook);
        } else {
            System.out.println("This book does not exist in this library.");
        }
    }

    public List<Book> searchBookByAuthor(String author) {
        System.out.println("Search results by author: ");
        List<Book> searchResults = new ArrayList<>();
        for(Book book: books) {
            if(book.getAuthor().equalsIgnoreCase(author)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public List<Book> searchBookByTitle(String title) {
        System.out.println("Search results by title: ");
        List<Book> searchResults = new ArrayList<>();
        for(Book book: books) {
            if(book.getTitle().equalsIgnoreCase(title)) {
                searchResults.add(book);
            }
        }
        return searchResults;
    }

    public void displayBooks() {
       for(Book book: books) {
           System.out.println(book);
       }
    }

    public void addBookToFavorites(Book book){
        favoriteBooks.add(book);
    }

    public void removeBookFromFavorites(Book book) {
        favoriteBooks.remove(book);
    }



    public void displayFavorites() {
        System.out.println("Favourite Books: ");
        for(Book book: favoriteBooks) {
            System.out.println(book);
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

    // Day 3 - Streams
    public List<Book> searchBookByAuthorStreams(String author) {
        System.out.println("Search results by author: ");
        return books.stream().filter(book -> book.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public List<Book> searchBookByTitleStreams(String title) {
        System.out.println("Search results by title: ");
        return books.stream().filter(book -> book.getTitle().equalsIgnoreCase(title))
                .collect(Collectors.toList());
    }

    public List<Member> sortMembersByName() {
       return members.stream()
               .sorted(Comparator.comparing(Member::getName))
               .collect(Collectors.toList());
    }

}
