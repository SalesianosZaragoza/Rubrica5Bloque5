package com.AuthorsBooks.B5R5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.AuthorsBooks.*"})
public class B5R5Application {

	public static void main(String[] args) {
		SpringApplication.run(B5R5Application.class, args);
	}
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(B5R5Application.class);
	}

}
