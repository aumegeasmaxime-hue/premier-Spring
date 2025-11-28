package com.maxime.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication  // annotation permet appeler
@RestController
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);}
/*
        @GetMapping("/hello")
        public String helloworld () {
            return "hello";
        }

 */
}
