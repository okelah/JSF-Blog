package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.beans.models;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.Serializable;

/**
 * Created by vlad on 11.09.16.
 */
@Component
@Scope("request")
public class UserModelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nickname;

    private String email;

    private String login;

    private String password;

    @PostConstruct
    public void init() {
        nickname = "";
        email = "";
        login = "";
        password = "";
    }

    public UserModelBean() {

    }

    public UserModelBean(String nickname, String email, String login, String password) {
        this.nickname = nickname;
        this.email = email;
        this.login = login;
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "UserModelBean{" +
                "nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
