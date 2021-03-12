package com.hibernate.week18;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
@SpringBootApplication
public class Week18Application {

	public static void main(String[] args) {
		SpringApplication.run(Week18Application.class, args);
	}

}
