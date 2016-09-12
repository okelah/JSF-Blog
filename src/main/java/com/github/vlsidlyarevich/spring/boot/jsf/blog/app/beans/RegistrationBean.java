package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.beans;

import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.beans.models.UserModelBean;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.Authority;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.model.User;
import com.github.vlsidlyarevich.spring.boot.jsf.blog.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by vlad on 11.09.16.
 */
@Component
@Scope("request")
public class RegistrationBean implements Serializable {

    @Autowired
    private UserService userService;

    @Autowired
    private UserModelBean userModel;

    public RegistrationBean() {
    }

    public void saveUser() {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(new Authority("ROLE_USER"));

        userService.save(new User(
                userModel.getNickname(),
                userModel.getEmail(),
                userModel.getLogin(),
                userModel.getPassword(),
                authorities
        ));
    }

    public UserModelBean getUserModel() {
        return userModel;
    }

    public void setUserModel(UserModelBean userModel) {
        this.userModel = userModel;
    }

    @Override
    public String toString() {
        return "RegistrationBean{" +
                "userService=" + userService +
                ", userModel=" + userModel +
                '}';
    }
}
