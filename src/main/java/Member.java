import java.util.List;

public class Member {
    private String id;
    private String name;
    @Email
    private String email;
    private int age;

    private List<Book> books;

    public Member(String id, String name, String email, int age, List<Book> books) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.books = books;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Book> getBooks() {
        return books;
    }
}
