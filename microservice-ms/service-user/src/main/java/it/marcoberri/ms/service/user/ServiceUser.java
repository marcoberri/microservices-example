package it.marcoberri.ms.service.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(UserConfiguration.class)
public class ServiceUser {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "service-user");
		SpringApplication.run(ServiceUser.class, args);
	}
}
