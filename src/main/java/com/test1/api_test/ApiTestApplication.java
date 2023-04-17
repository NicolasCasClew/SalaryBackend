package com.test1.api_test;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ApiTestApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiTestApplication.class, args);
	}
	

}
