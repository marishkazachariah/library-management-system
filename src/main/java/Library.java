import java.util.HashSet;
import java.util.Set;

public class Library {
    private Set<Book> books;
    private Set<Member> members;

    public Library() {
        this.books = new HashSet<>();
        this.members = new HashSet<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public Book searchBook(String bookId) {
        for(Book book: books) {
            if(book.getId().equalsIgnoreCase(bookId)) {
                return book;
            }
        }
        System.out.println("This book does not exist in this library.");
        return null;
    }

    public void updateBook(Book oldBook, Book newBook) {
        if(books.contains(oldBook)) {
            books.remove(oldBook);
            books.add(newBook);
        } else {
            System.out.println("This book does not exist in this library.");
        }
    }

    public void viewBooks() {
       for(Book book: books) {
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
