package com.construccion.ciudadela2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = { "com.construccion.ciudadela2", "domain.usecases", "materiales", "web.materiales" })
@EnableReactiveMongoRepositories(basePackages = "web.materiales")
public class Ciudadela2Application {

	public static void main(String[] args) {
		SpringApplication.run(Ciudadela2Application.class, args);
		System.out.println("hola a todos");
	}

}
