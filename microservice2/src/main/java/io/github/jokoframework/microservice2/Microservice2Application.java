package io.github.jokoframework.microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@EnableDiscoveryClient
@EnableCircuitBreaker
@EnableHystrixDashboard
@EnableResourceServer
@SpringBootApplication
@RefreshScope
public class Microservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}

}
