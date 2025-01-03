package md.hajji.springcassandra.models;


import jakarta.annotation.PostConstruct;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.UUID;

@Table("PRODUCTS")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@ToString
public class Product {
    @Id
    @PrimaryKey
    private UUID id;
    private String name;
    private double price;
    private int quantity;
}
