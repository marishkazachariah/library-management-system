import java.util.LinkedList;
import java.util.Queue;

public class BorrowQueue {
    private Queue<Book> queueOfBooks = new LinkedList<>();

    public BorrowQueue(Queue<Book> queueOfBooks) {
        this.queueOfBooks = queueOfBooks;
    }

    public Queue<Book> getBooksToBorrow() {
        return queueOfBooks;
    }

    public void setBooksToBorrow(Queue<Book> queueOfBooks) {
        this.queueOfBooks = queueOfBooks;
    }

    public void addBookToQueue(Book book) {
        queueOfBooks.offer(book);
    }

    public void removeBookFromQueue() {
        if(queueOfBooks.isEmpty()) {
            System.out.println("Book queue is already empty");
        } else {
            queueOfBooks.poll();
        }
    }

    public void removeAllBooksFromQueue() {
        queueOfBooks.clear();
    }

    // display all books in queue
    public void displayBookQueue(Queue<Book> queueOfBooks) {
        System.out.println("Books in queue: ");
        for(Book book: queueOfBooks) {
            System.out.println(book);
        }
    }

    public int totalNumberOfBooksInQueue(Queue<Book> queueOfBooks) {
        return queueOfBooks.size();
    }

}
