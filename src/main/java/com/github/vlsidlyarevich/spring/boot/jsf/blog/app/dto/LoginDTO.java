package com.github.vlsidlyarevich.spring.boot.jsf.blog.app.dto;

import java.io.Serializable;

/**
 * Created by vlad on 06.09.16.
 */
public class LoginDTO implements Serializable {
    private String login;
    private String password;

    public LoginDTO() {
    }

    public LoginDTO(String login, String password) {
        this.login = login;
        this.password = password;
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
}
