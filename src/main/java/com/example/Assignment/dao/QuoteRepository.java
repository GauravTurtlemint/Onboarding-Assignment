package com.example.Assignment.dao;

import com.example.Assignment.Models.Quotes;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface QuoteRepository extends MongoRepository<Quotes,String> {

    Quotes findByRequestId(String requestId);
    void deleteByRequestId(String requestId);
}
