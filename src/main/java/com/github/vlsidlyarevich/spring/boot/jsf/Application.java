package com.github.vlsidlyarevich.spring.boot.jsf;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import javax.faces.webapp.FacesServlet;

@SpringBootApplication
@ComponentScan("com.github.vlsidlyarevich.spring.boot.jsf")
@EnableAutoConfiguration
public class Application extends SpringBootServletInitializer {

    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        return new ServletRegistrationBean(servlet, "*.xhtml");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}