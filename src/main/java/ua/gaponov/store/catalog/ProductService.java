package ua.gaponov.store.catalog;

/**
 * @author Andriy Gaponov
 */
public interface ProductService {

    ProductDto getByGuid(String productGuid);
    void add(ProductDto productDto);
    void delete(String productGuid);
    void update(ProductDto productDto);
}
