package md.hajji.springcassandra.services.impl;

import lombok.RequiredArgsConstructor;
import md.hajji.springcassandra.dtos.ProductDTO;
import md.hajji.springcassandra.models.Product;
import md.hajji.springcassandra.repositories.ProductRepository;
import md.hajji.springcassandra.services.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
import java.util.function.Function;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public Product create(ProductDTO productDTO) {

        if(productDTO.name() == null || productDTO.name().isBlank())
            throw new IllegalArgumentException("Name cannot be null or empty");

        if(productDTO.price() < 0)
            throw new IllegalArgumentException("Price cannot be negative");

        if(productDTO.quantity() < 0)
            throw new IllegalArgumentException("Quantity cannot be negative");

        Product product = Product.builder()
                .id(UUID.randomUUID())
                .name(productDTO.name())
                .price(productDTO.price())
                .quantity(productDTO.quantity())
                .build();

        return productRepository.save(product);
    }

    @Override
    public Product update(UUID id, ProductDTO product) {

        Product current = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));


        if (product.name() != null && !product.name().isBlank())
            current.setName(product.name());

        if (product.price() > 0)
            current.setPrice(product.price());
        if (product.quantity() > 0)
            current.setQuantity(product.quantity());

        productRepository.save(current);

        return current;
    }



    @Override
    public void delete(UUID id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product get(UUID id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
