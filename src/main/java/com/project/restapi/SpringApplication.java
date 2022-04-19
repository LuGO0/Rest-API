package com.project.restapi;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // It enables auto config + ComponentScanning
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
	}
}
