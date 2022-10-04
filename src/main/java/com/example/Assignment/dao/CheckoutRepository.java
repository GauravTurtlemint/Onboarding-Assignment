package com.example.Assignment.dao;

import com.example.Assignment.Models.Checkout;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckoutRepository extends MongoRepository<Checkout, String> {
    List<Object> findByRequestId(String requestId);

    void deleteByRequestId(String requestId);
}
