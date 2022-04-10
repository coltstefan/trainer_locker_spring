package com.example.licenta_spring.services;

import com.example.licenta_spring.domains.Comment;
import com.example.licenta_spring.repositories.CommentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public Comment save(Comment comment){
        return commentRepository.save(comment);
    }

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }

    public Optional<Comment> findCommentById(String id){
        return commentRepository.findById(id);
    }

    public List<Comment> findCommentByTraniningPlanId(String id){
        return commentRepository.findCommentByTrainingPlanId(id);
    }

}
