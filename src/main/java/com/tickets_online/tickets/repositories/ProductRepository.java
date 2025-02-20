package com.tickets_online.tickets.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tickets_online.tickets.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    
    List<Product> findByEventId(int eventId);
}
