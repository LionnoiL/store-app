package ua.gaponov.store.catalog;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Andriy Gaponov
 */
@RequiredArgsConstructor
@Service
public class ProductServiceImpl implements ProductService{

    private ProductRepository productRepository;

    @Override
    public ProductDto getByGuid(String productGuid) {
        return null;
    }

    @Override
    public void add(ProductDto productDto) {

    }

    @Override
    public void delete(String productGuid) {

    }

    @Override
    public void update(ProductDto productDto) {

    }
}
