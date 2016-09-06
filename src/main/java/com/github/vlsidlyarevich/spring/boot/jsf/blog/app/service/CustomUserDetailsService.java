package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by vlad on 06.09.16.
 */
@Component
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.User user = userService.findUserByLogin(login);

        Collection<SimpleGrantedAuthority> grantedAuthorities = user.getAuthorities().stream().map(authority ->
                new SimpleGrantedAuthority(authority.getName())).collect(Collectors.toCollection(ArrayList::new));

        return new User(user.getLogin(),
                user.getPassword(), grantedAuthorities);
    }
}