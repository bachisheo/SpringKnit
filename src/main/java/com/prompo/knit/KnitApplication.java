package com.prompo.knit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
		import org.springframework.boot.CommandLineRunner;
		import org.springframework.context.ApplicationContext;
		import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class KnitApplication {

	public static void main(String[] args) {
		SpringApplication.run(KnitApplication.class, args);
	}
}