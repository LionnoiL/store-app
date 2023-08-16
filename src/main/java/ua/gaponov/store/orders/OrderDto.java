package ua.gaponov.store.orders;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

/**
 * @author Andriy Gaponov
 */
public class OrderDto {

    @Id
    @Column(name = "order_guid")
    private String guid;
    @Column(name = "order_number")
    private String number;
}
