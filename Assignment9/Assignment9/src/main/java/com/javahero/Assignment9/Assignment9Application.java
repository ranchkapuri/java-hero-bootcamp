package com.javahero.Assignment9;


import java.io.IOException;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;




@ComponentScan("com")
@SpringBootApplication
public class Assignment9Application {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Assignment9Application.class, args);
		
		
		
	}

}
