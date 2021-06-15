package com.jong960107.study03_04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class Study0304Application {

    public static void main(String[] args) {
        SpringApplication.run(Study0304Application.class, args);
    }

}
