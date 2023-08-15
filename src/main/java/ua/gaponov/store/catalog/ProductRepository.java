package ua.gaponov.store.catalog;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Andriy Gaponov
 */
public interface ProductRepository extends JpaRepository<Product, String> {

}
