package pl.kamilderen.ztplab7.model;

import lombok.Getter;
import java.util.List;

@Getter
public class Order {
    private static int counter = 0;
    private final int id;
    private List<Book> books;

    public Order() {
        this.id = ++counter;
    }

    public Order(List<Book> books) {
        this();
        this.books = books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public static void setCounter(int counter) {
        Order.counter = counter;
    }
}
