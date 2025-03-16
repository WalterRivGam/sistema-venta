package edu.cibertec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AppConfiguration {

	public static void main(String[] args) {
		SpringApplication.run(AppConfiguration.class, args);
	}

}
