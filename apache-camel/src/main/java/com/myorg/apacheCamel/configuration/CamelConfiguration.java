package com.myorg.apacheCamel.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.myorg.apacheCamel.example_1.CamelHelloWorld;
import com.myorg.apacheCamel.example_1.CamelHelloWorldRouteBuilder;

@Configuration
public class CamelConfiguration {
	@Bean(name = "camelHelloWorld")
	public CamelHelloWorld camelHelloWorld() {
		return new CamelHelloWorld();
	}

	@Bean(name = "camelHelloWorldRouteBuilder")
	public CamelHelloWorldRouteBuilder camelHelloWorldRouteBuilder() {
		return new CamelHelloWorldRouteBuilder();
	}
}
