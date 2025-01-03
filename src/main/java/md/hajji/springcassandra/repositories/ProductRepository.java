package md.hajji.springcassandra.repositories;

import md.hajji.springcassandra.models.Product;
import org.springframework.data.cassandra.repository.CassandraRepository;

import java.util.UUID;

public interface ProductRepository extends CassandraRepository<Product, UUID> {
}
