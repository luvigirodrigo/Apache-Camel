package com.myorg.apacheCamel.example_1;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.camel.builder.RouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelHelloWorldRouteBuilder extends RouteBuilder {

	Logger logger = LoggerFactory.getLogger(CamelHelloWorldRouteBuilder.class);

	@Override
	public void configure() throws Exception {
		System.out.println("Hello World Camel");
		logger.trace("CamelHelloWorldRouteBuilder -> configure() method was invoked");
	}

	@PostConstruct
	public void setUp() {
		logger.trace("CamelHelloWorldRouteBuilder bean was initialized");
	}

	@PreDestroy
	public void tearDown() {
		logger.trace("CamelHelloWorldRouteBuilder bean was destroyed");
	}
}
