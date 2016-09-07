package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Created by vlad on 21.08.16.
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/console/**").permitAll()
                .antMatchers("/**/index.xhtml").permitAll()
                .antMatchers("/**/about.xhtml").permitAll()
                .antMatchers("/**/login.xhtml").permitAll()
                .antMatchers("/**/new_post.xhtml").authenticated()
                .antMatchers("/**/posts.xhtml").authenticated()
                .antMatchers("/").permitAll();
        httpSecurity
                .formLogin().failureUrl("/views/login.xhtml?error")
                .defaultSuccessUrl("/views/posts.xhtml")
                .loginPage("/views/login.xhtml")
                .permitAll()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/views/logout.xhtml")).logoutSuccessUrl("/views/login.xhtml")
                .permitAll();

        httpSecurity.csrf().disable();
        httpSecurity.headers().frameOptions().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}