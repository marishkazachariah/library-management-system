package dayThreeStreamsSessionTwo;

import java.time.Year;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
a. Find the total number of books in the list.

b. Find the average price of the books.

c. Find the most expensive book.

d. Find the books published in the last 5 years (current year - 5).

e. Create a map of authors to the list of books they have written.

f. Find the author with the most books in the list.

g. Find the number of books with titles starting with the letter 'A'.

h. Sort the books by price in descending order and display the top 5 most expensive books.

i. Group the books by the decade of their publication year (e.g., 2000-2009, 2010-2019) and count the number of books in each decade.

 */


public class Main {
    private static long totalNumberOfBooks(List<Book> books) {
        return books.stream().count();
    }

    public static double averagePrice(List<Book> books) {
        return books.stream().mapToDouble(Book::getPrice).average().orElse(0);
    }

    public static Book mostExpensiveBook(List<Book> books) {
        return books.stream().max((b1, b2) -> Double.compare(b1.getPrice(), b2.getPrice())).orElse(null);
    }

    public static List<Book> lastFiveYears(List<Book> books) {
        Year getCurrentYear = Year.now();
        int lastFiveYears = getCurrentYear.getValue() - 5;
        return books.stream().filter(book -> book.getPublicationYear() >= lastFiveYears).collect(Collectors.toList());
    }

    public static long startsWithA(List<Book> books) {
        return books.stream().filter(book -> book.getTitle().startsWith("A")).count();
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book("Book of Cats", "Tom Jones", 1994, 12.50));
        books.add(new Book("All About Love", "Catherine Zetta", 2008, 12.50));
        books.add(new Book("Insects and Buggos", "Abraham Ponce", 1954, 54.64));
        books.add(new Book("Dogs All Over", "Tom Jones", 2022, 34.78));
        books.add(new Book("Space 6", "Priscilla Hannah", 1991, 44.65));
        books.add(new Book("Black Beauty", "Robyn Stacey", 2021, 26.74));
        books.add(new Book("Something Else", "Anna Toos", 1899, 15.75));
        books.add(new Book("Last Novel", "Maria Ex", 1994, 45.32));

        // Display results of exercises
        // a
        System.out.println(totalNumberOfBooks(books));
        // b
        System.out.println(averagePrice(books));
        // c
        System.out.println(mostExpensiveBook(books));
        // d
        System.out.println(lastFiveYears(books));
        // e
        Map<String, List<Book>> authorOfBooks = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
        System.out.println("Map of Authors to Their Books:");
        authorOfBooks.forEach((author, booksOfAuthor) -> System.out.println(author + booksOfAuthor));
        // f
        String authorWithMostBooks = authorOfBooks.entrySet().stream()
                .max(Comparator.comparing(entry -> entry.getValue().size())).orElseThrow().getKey();
        System.out.println("Author with most books: " + authorWithMostBooks);
        // g
        System.out.println(startsWithA(books));
        // h
        List<Book> mostExpensiveBooks = books.stream()
                .sorted(Comparator.comparingDouble(Book::getPrice).reversed())
                .limit(5)
                .collect(Collectors.toList());

        System.out.println("\nTop 5 Most Expensive Books:");
        mostExpensiveBooks.forEach(book -> System.out.println(book));
        // i - had to google this solution...
        Map<String, Long> booksByDecade = books.stream()
                .collect(Collectors.groupingBy(
                        book -> Integer.toString(book.getPublicationYear() / 10 * 10) + "-" + (book.getPublicationYear() / 10 * 10 + 9),
                        Collectors.counting()
                ));
        System.out.println(booksByDecade);
    }

}
