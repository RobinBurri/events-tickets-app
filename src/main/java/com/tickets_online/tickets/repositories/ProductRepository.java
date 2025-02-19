package com.tickets_online.tickets.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.tickets_online.tickets.models.Product;

@Repository
public class ProductRepository {

    private final List<Product> products = List.of(
            new Product(801, 501, "Standard", "Standard Conference Tickets", new BigDecimal("499.00")),
            new Product(802, 501, "Premium", "Premium Conference Tickets", new BigDecimal("640.00")),
            new Product(803, 501, "Standard", "Developer Day Tickets", new BigDecimal("195.50")),
            new Product(804, 501, "Regular", "Regular Entrance", new BigDecimal("35.00")),
            new Product(805, 501, "VIP", "VIP Bonus Entrence", new BigDecimal("65.00")));

    public List<Product> findByEventId(int eventId) {
        return products.stream().filter(product -> product.eventId() == eventId).toList();
    }
}
