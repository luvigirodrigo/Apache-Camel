package com.myorg.apacheCamel.example_1;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CamelHelloWorld {

	Logger logger = LoggerFactory.getLogger(CamelHelloWorld.class);

	public void executeHelloWorld(RouteBuilder routeBuilder) {
		CamelContext camelContext = new DefaultCamelContext();
		try {
			camelContext.addRoutes(routeBuilder);
			camelContext.start();
			camelContext.close();
		} catch (IOException ioe) {
			logger.error("CamelHelloWorld -> executeHelloWorld, IOException occured : " + ioe);
		} catch (Exception e) {
			logger.error("CamelHelloWorld -> executeHelloWorld, Exception occured : " + e);
		}
		logger.trace("CamelHelloWorld -> executeHelloWorld was invoked");
	}

	@PostConstruct
	public void setUp() {
		logger.trace("CamelHelloWorld bean was initialized");
	}

	@PreDestroy
	public void tearDown() {
		logger.trace("CamelHelloWorld bean was destroyed");
	}
}
