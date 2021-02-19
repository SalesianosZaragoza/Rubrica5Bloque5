package Bloque5.Rubrica5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"Bloque5.Rubrica5.*"})
public class Bloque5Rubrica5Application {

	public static void main(String[] args) {
		SpringApplication.run(Bloque5Rubrica5Application.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(Bloque5Rubrica5Application.class);
	}
}
