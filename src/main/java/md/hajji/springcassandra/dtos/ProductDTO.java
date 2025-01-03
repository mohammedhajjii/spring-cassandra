package md.hajji.springcassandra.dtos;

public record ProductDTO(
        String name,
        double price,
        int quantity
) {
}
