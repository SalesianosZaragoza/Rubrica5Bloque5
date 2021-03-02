package AuthorsBooks.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = { "AuthorsBooks.*" })
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


}

