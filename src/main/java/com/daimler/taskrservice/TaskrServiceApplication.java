package com.daimler.taskrservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/*
This is the entry point for the application. Run this file to put the service up
 */
@EnableSwagger2
@SpringBootApplication
public class TaskrServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskrServiceApplication.class, args);
	}

}
