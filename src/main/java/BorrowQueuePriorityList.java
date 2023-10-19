import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class BorrowQueuePriorityList implements Comparable {

    private Queue<Book> bookPriorityQueue = new PriorityQueue<>();
    Comparator<Book> titleComparator = Comparator.comparing(Book::getTitle);

    public BorrowQueuePriorityList(Queue<Book> bookPriorityQueue) {
        this.bookPriorityQueue = bookPriorityQueue;
    }

    // override compareto() method to sort books by name and author
    @Override
    public int compareTo(Object o) {
        if (o instanceof BorrowQueuePriorityList secondBookQueue) {
            // Compare based on the titles of the first books in the queues
            Book thisFirstBook = this.bookPriorityQueue.peek();
            Book otherFirstBook = secondBookQueue.bookPriorityQueue.peek();

            if (thisFirstBook != null && otherFirstBook != null) {
                return titleComparator.compare(thisFirstBook, otherFirstBook);
            }

            if (thisFirstBook == null && otherFirstBook == null) {
                return 0;
            } else if (thisFirstBook == null) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}