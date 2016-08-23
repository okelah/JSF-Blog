package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.utils;

import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.dto.PostDTO;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Comment;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Post;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

/**
 * Created by vlad on 22.08.16.
 */
@Component
@Transactional
public class EntityUtils {
    private static final int MAX_STRING_LENGTH = 25;
    private static final int START_INCLUSIVE = 5000;
    private static final int END_INCLUSIVE = 100000;

    private static String getRandomString(int length) {
        return RandomStringUtils.random(length, true, true);
    }

    private static Long getRandomLong() {
        return RandomUtils.nextLong(START_INCLUSIVE, END_INCLUSIVE);
    }

    public static Post generatePost() {
        return new Post(getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }

    public static PostDTO generatePostDTO() {
        return new PostDTO(getRandomLong(),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }

    public static Comment generateComment() {
        return new Comment(getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH),
                getRandomString(MAX_STRING_LENGTH));
    }
}