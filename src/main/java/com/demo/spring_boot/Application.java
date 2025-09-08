package com.demo.spring_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Application {

	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
	}
	//REST API endpoint
	@GetMapping
	public String HelloWorld(){
        return "Hi, Welcome to Spring Boot Project";
	}
}
