import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Member> memberList = new ArrayList<>();
    private List<Book> library = new ArrayList<>();
    @IsAvailable
    public boolean isAvailable(int bookId) {
        for (Book book : library) {
            if (book.getId() == bookId) {
                return true;
            }
        }
        return false;
    }

    @ValidateUser(minimumAge = 15, maximumBooks = 5)
    public void registerMember(Member member) {
        memberList.add(member);
    }

    public void processBookAvailability(Book book) {
        Class<?> bookClass = book.getClass();
        Method[] methods = bookClass.getDeclaredMethods();

        for (Method method : methods) {
            IsAvailable annotation = method.getAnnotation(IsAvailable.class);
            if (annotation != null) {
                try {
                    boolean isAvailable = (boolean) method.invoke(book);
                    if (isAvailable) {
                        System.out.println("Book is available for checkout.");
                        // Add additional logic for borrowing
                    } else {
                        System.out.println("Book is not available for checkout.");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
