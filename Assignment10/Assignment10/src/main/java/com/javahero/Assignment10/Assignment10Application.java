package com.javahero.Assignment10;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScan("com")
@SpringBootApplication
public class Assignment10Application {

	public static void main(String[] args) {
		SpringApplication.run(Assignment10Application.class, args);
	}

}
