package com.myorg.apacheCamel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.myorg.apacheCamel.example_1.CamelHelloWorld;
import com.myorg.apacheCamel.example_1.CamelHelloWorldRouteBuilder;

@SpringBootApplication
public class ApacheCamelApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("camelHelloWorld")
	public CamelHelloWorld camelHelloWorld;

	@Autowired
	@Qualifier("camelHelloWorldRouteBuilder")
	CamelHelloWorldRouteBuilder camelHelloWorldRouteBuilder;

	public static void main(String[] args) {
		SpringApplication.run(ApacheCamelApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Camel - Hello World example
		executeCamelExample1();
	}

	public void executeCamelExample1() {
		camelHelloWorld.executeHelloWorld(camelHelloWorldRouteBuilder);
	}
}
