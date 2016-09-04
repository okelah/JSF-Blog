package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by vlad on 21.08.16.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/**/index.xhtml").permitAll()
                .antMatchers("/**/about.xhtml").permitAll()
                .antMatchers("/**/posts.xhtml").authenticated()
                .antMatchers("/**/newPost.xhtml").authenticated()
                .antMatchers("/").permitAll();

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

}