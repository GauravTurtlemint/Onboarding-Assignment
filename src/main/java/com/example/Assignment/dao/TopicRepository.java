package com.example.Assignment.dao;

import com.example.Assignment.Models.Topic;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface TopicRepository extends MongoRepository<Topic, String> {
    // CrudRepository <Entity, topic id type>
}
