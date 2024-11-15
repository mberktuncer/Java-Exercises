package BookList;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("The Great Gatsby", 10, "F. Scott Fitzgerald", "1925"));
        books.add(new Book("1984", 10, "George Orwell", "1949"));
        books.add(new Book("To Kill a Mockingbird", 281, "Harper Lee", "1960"));
        books.add(new Book("Pride and Prejudice", 279, "Jane Austen", "1813"));
        books.add(new Book("The Catcher in the Rye", 277, "J.D. Salinger", "1951"));
        books.add(new Book("The Hobbit", 310, "J.R.R. Tolkien", "1937"));
        books.add(new Book("Moby Dick", 585, "Herman Melville", "1851"));
        books.add(new Book("War and Peace", 1225, "Leo Tolstoy", "1869"));
        books.add(new Book("The Odyssey", 541, "Homer", "8th Century BC"));
        books.add(new Book("The Divine Comedy", 798, "Dante Alighieri", "1320"));

        Map<String, String> map = books.stream()
                .collect(Collectors.toMap(Book::getName, Book::getAuthorName));

        map.forEach((key, value) -> System.out.println("Book Name: " + key + ", Author: " + value));

        List<Book> booksWithMoreThan100Page = books
                .stream()
                .filter(a -> a.getPageCount() > 100)
                .toList();

        for (Book book: booksWithMoreThan100Page)
        {
            System.out.println(book.toString());
        }
    }

}
