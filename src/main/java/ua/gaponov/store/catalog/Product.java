package ua.gaponov.store.catalog;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * @author Andriy Gaponov
 */
@Entity
@Table(name = "products")
public class Product {

    @Id
    @Column(name = "product_guid")
    private String guid;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_code")
    private String code;
}
