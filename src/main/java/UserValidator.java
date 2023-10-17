import java.lang.reflect.Method;

public class UserValidator {
    public void validateUser(Method method, Member member) {
        ValidateUser annotation = method.getAnnotation(ValidateUser.class);
        if (method.isAnnotationPresent(ValidateUser.class)) {
            int minimumAge = annotation.minimumAge();

            if (member.getAge() < minimumAge) {
                throw new IllegalArgumentException("User is too young to perform this action.");
            }
        }
    }

    public void validateBookAmount(Method method, Member member) {
        ValidateUser annotation = method.getAnnotation(ValidateUser.class);
        if (method.isAnnotationPresent(ValidateUser.class)) {
            int bookAmount = annotation.maximumBooks();

            if (member.getBooks().size() < bookAmount) {
                throw new IllegalArgumentException("User has exceeded maximum borrowing limit.");
            }
        }
    }

    public void validateEmail() {

    }
}
