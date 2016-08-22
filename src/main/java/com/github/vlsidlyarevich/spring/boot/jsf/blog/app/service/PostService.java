package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.service;

import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.dto.PostDTO;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Post;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by vlad on 22.08.16.
 */
@Service
@Transactional
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public List<Post> findAll() {
        return postRepository.findAll();
    }

    public Post findOnePostById(Long id) {
        return postRepository.findOnePostById(id);
    }

    public void save(Post post) {
        postRepository.save(post);
    }

    public void deletePostById(Long id) {
        postRepository.delete(id);
    }

    public void updateContentById(PostDTO postDTO) {
        postRepository.updateContentById(postDTO.getContent(), postDTO.getId());
    }

    public void deleteAllPosts() {
        postRepository.deleteAll();
    }
}