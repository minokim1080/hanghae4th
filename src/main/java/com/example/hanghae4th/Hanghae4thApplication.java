package com.example.hanghae4th;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Hanghae4thApplication {

    public static void main(String[] args) {
        SpringApplication.run(Hanghae4thApplication.class, args);
    }

}
