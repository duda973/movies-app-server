package com.moviebase.moviebaseapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.moviebase")
public class MoviesDatabaseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MoviesDatabaseApiApplication.class, args);
	}

}
