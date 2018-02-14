package com.sys.org.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.sys.org.spring.config", "com.sys.org.spring.controller", "com.sys.org.spring.ignitecache.store", "com.sys.org.spring.converter"})
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
