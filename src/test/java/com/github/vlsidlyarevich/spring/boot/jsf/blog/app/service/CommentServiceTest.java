package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.service;

import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.Application;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Comment;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.utils.EntityUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by vlad on 24.08.16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Transactional
@SpringApplicationConfiguration(Application.class)
public class CommentServiceTest {

    @Autowired
    CommentService commentService;

    @Autowired
    PostService postService;

    @Test
    public void findCommentByIdTest() {
        Comment saved = new Comment("test author", "test review", "test date");
        commentService.save(saved);

        Assert.assertEquals(commentService.findOneCommentById(saved.getId()), saved);
    }

    @Test
    public void findAllTest() {
        List<Comment> saved = new LinkedList<>();
        saved.add(EntityUtils.generateComment());
        saved.add(EntityUtils.generateComment());
        commentService.save(saved.get(0));
        commentService.save(saved.get(1));

        List<Comment> found = commentService.findAll();
        Assert.assertTrue(saved.containsAll(found) && found.containsAll(saved));
    }

    @Test
    public void findAllCommentsFromPostByIdTest() {
        Comment saved1 = EntityUtils.generateComment();
        Comment saved2 = EntityUtils.generateComment();

        commentService.addNewCommentToPost(0L, saved1);
        commentService.addNewCommentToPost(0L, saved2);

        List<Comment> saved = new LinkedList<>();
        saved.add(saved1);
        saved.add(saved2);

        List<Comment> found = commentService.findAllCommentsFromPostById(0L);
        Assert.assertTrue(saved.containsAll(found) && found.containsAll(saved));
    }

    @Test
    public void deleteCommentByIdTest() {
        Comment saved = EntityUtils.generateComment();
        commentService.save(saved);

        commentService.deleteCommentById(saved.getId());
        Assert.assertEquals(commentService.findOneCommentById(saved.getId()), null);
    }
}