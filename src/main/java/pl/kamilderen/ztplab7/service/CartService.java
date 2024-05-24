package pl.kamilderen.ztplab7.service;

import org.springframework.stereotype.Service;
import pl.kamilderen.ztplab7.model.Book;
import pl.kamilderen.ztplab7.model.Order;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {
    private final List<Book> cart = new ArrayList<>();
    private final List<Order> orders = new ArrayList<>();

    public Flux<Book> getCartContents() {
        return Flux.fromIterable(cart);
    }

    public Mono<Void> addToCart(Book book) {
        cart.add(book);
        return Mono.empty();
    }

    public Mono<Void> removeFromCart(String isbn) {
        cart.removeIf(book -> book.getIsbn().equals(isbn));
        return Mono.empty();
    }

    public Mono<Order> placeOrder() {
        Order order = new Order(new ArrayList<>(cart));
        orders.add(order);
        cart.clear();
        return Mono.just(order);
    }

    public Flux<Order> getAllOrders() {
        return Flux.fromIterable(orders);
    }

    public Mono<Order> getOrderById(int id) {
        return Mono.justOrEmpty(orders.stream().filter(order -> order.getId() == id).findFirst());
    }
}
