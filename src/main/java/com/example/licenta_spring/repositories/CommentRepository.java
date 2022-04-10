package com.example.licenta_spring.repositories;

import com.example.licenta_spring.domains.Comment;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface CommentRepository
        extends MongoRepository<Comment, String> {

    Optional<Comment> getCommentById(String id);
    List<Comment> findAll();
    List<Comment> findCommentByTrainingPlanId(String id);
}
