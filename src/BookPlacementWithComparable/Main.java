package BookPlacementWithComparable;


import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {

        Book book1 = new Book("Java", 130, "Mustafa", "12.12.12");
        Book book2 = new Book("Python", 200, "Berk", "12.12.12");
        Book book3 = new Book("C#", 120, "Tuncer", "12.12.12");
        Book book4 = new Book("AI", 100, "Joe", "12.12.12");
        Book book5 = new Book("Go", 150, "Josh", "12.12.12");

        Set<Book> books = new TreeSet<>();
        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);
        books.add(book5);

        for (Book book : books){
            System.out.println(book.toString());
        }

    }

}
