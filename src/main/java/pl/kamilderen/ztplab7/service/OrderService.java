package pl.kamilderen.ztplab7.service;

import org.springframework.stereotype.Service;
import pl.kamilderen.ztplab7.model.Order;
import pl.kamilderen.ztplab7.repository.OrderRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Flux<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Mono<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Mono<Order> placeOrder(Order order) {
        return orderRepository.save(order);
    }
}
