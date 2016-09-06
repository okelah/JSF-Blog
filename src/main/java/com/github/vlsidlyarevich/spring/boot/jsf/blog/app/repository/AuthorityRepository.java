package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.repository;

import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by vlad on 06.09.16.
 */
@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
}
