package com.pepsiwyl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ShiroBootApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ShiroBootApplication.class, args);
    }
}
