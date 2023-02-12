package com.example.springbootb5r5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.*")
public class SpringbootB5r5Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootB5r5Application.class, args);
	}

}
