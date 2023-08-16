package ua.gaponov.store.orders;

/**
 * @author Andriy Gaponov
 */
public interface OrderService {

    OrderDto getByGuid(String productGuid);
    void add(OrderDto orderDto);
    void delete(String productGuid);
    void update(OrderDto orderDto);
}
