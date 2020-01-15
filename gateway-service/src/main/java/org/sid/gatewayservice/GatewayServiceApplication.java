package org.sid.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GatewayServiceApplication.class, args);
	}

	RouteLocator staticRoutes(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/customers/**").uri("http://localhost:8081/").id("r1"))
				.route(r -> r.path("/products/**").uri("http://localhost:8082/").id("r2"))
				.build();
	}

}
