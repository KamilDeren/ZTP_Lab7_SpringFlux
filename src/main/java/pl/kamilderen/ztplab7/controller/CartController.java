package pl.kamilderen.ztplab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.kamilderen.ztplab7.model.Book;
import pl.kamilderen.ztplab7.model.Order;
import pl.kamilderen.ztplab7.service.CartService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public Flux<Book> getCartContents() {
        return cartService.getCartContents();
    }

    @PostMapping("/add")
    public Mono<ResponseEntity<String>> addToCart(@RequestBody Book book) {
        return cartService.addToCart(book)
                .then(Mono.just(ResponseEntity.ok("Book added to cart successfully")));
    }

    @DeleteMapping("/remove/{isbn}")
    public Mono<ResponseEntity<String>> removeFromCart(@PathVariable String isbn) {
        return cartService.removeFromCart(isbn)
                .then(Mono.just(ResponseEntity.ok("Book removed from cart successfully")));
    }

    @PostMapping("/order")
    public Mono<ResponseEntity<Order>> placeOrder() {
        return cartService.placeOrder()
                .map(order -> ResponseEntity.ok(order));
    }
}
