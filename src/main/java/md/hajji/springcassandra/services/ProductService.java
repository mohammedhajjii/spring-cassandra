package md.hajji.springcassandra.services;

import md.hajji.springcassandra.dtos.ProductDTO;
import md.hajji.springcassandra.models.Product;

import java.util.List;
import java.util.UUID;

public interface ProductService {

    Product create(ProductDTO productDTO);
    Product update(UUID id, ProductDTO product);
    void delete(UUID id);
    Product get(UUID id);
    List<Product> getAll();

}
