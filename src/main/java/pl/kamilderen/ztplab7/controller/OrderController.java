package pl.kamilderen.ztplab7.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.kamilderen.ztplab7.model.Order;
import pl.kamilderen.ztplab7.service.CartService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private CartService cartService;

    @GetMapping
    public Flux<Order> getAllOrders() {
        return cartService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Mono<Order> getOrderById(@PathVariable int id) {
        return cartService.getOrderById(id);
    }
}
