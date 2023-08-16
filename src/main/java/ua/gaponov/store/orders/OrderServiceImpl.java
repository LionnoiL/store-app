package ua.gaponov.store.orders;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Andriy Gaponov
 */
@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public OrderDto getByGuid(String productGuid) {
        return null;
    }

    @Override
    public void add(OrderDto orderDto) {

    }

    @Override
    public void delete(String productGuid) {

    }

    @Override
    public void update(OrderDto orderDto) {

    }
}
