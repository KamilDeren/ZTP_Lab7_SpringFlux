package pl.kamilderen.ztplab7.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import pl.kamilderen.ztplab7.model.Order;

@Repository
public interface OrderRepository extends ReactiveCrudRepository<Order, Long> {
}
