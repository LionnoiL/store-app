package ua.gaponov.store.orders;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andriy Gaponov
 */
public interface OrderRepository extends JpaRepository<Order, String> {

}
