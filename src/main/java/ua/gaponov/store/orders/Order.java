package ua.gaponov.store.orders;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

/**
 * @author Andriy Gaponov
 */
@Entity
@Table(name = "orders")
public class Order {

    @Id
    @Column(name = "order_guid")
    private String guid;
    @Column(name = "order_number")
    private String number;
    @Column(name = "order_comment")
    private String comment;
    @Column(name = "agent_name")
    private String agentName;
    @Column(name = "summa_doc")
    private double documentSum;
    @Column(name = "order_date")
    private LocalDateTime date;

}
