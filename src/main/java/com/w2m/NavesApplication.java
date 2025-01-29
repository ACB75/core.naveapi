package com.w2m;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class NavesApplication {

    public static void main(String[] args) {
        SpringApplication.run(NavesApplication.class, args);
        new SpringApplicationBuilder()
                .sources(NavesApplication.class)
                .properties("h2")
                .run(args);
    }
}
