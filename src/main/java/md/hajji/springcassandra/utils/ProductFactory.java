package md.hajji.springcassandra.utils;

import md.hajji.springcassandra.models.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class ProductFactory {


    private static final List<String> NAMES =
            List.of("Iphone 8", "Pixel 6a", "HP eliteBook");

    private static final Random RANDOM = new Random();
    public static Product get(){

        return Product.builder()
                .id(UUID.randomUUID())
                .name(NAMES.get(RANDOM.nextInt(NAMES.size())))
                .quantity(RANDOM.nextInt(10))
                .price(RANDOM.nextDouble(10000))
                .build();
    }
}
