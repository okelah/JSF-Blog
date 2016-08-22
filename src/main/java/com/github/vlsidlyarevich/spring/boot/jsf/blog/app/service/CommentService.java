package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.service;

import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.dto.CommentDTO;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Comment;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vlad on 22.08.16.
 */
@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepository commentRepository;

    public Comment findOneCommentById(Long id) {
        return commentRepository.findOneCommentById(id);
    }

    public List<Comment> findAll() {
        return commentRepository.findAll();
    }

    public List<Comment> findAllCommentsFromPostById(Long id) {
        return commentRepository.findAllCommentsFromPostById(id);
    }

    public void save(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteCommentById(Long id) {
        commentRepository.delete(id);
    }

    public void addNewCommentToPost(Long id, Comment comment) {
        comment.setPostId(id);
        commentRepository.save(comment);
    }

    public void updateReviewById(CommentDTO commentDTO) {
        commentRepository.updateReviewById(commentDTO.getReview(), commentDTO.getId());
    }
}
