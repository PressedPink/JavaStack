package com.Stack;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.Stack")
public class StackApplication {

	public static void main(String[] args) {
		SpringApplication.run(StackApplication.class, args);
	}

}
