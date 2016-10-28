package it.marcoberri.ms.service.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(MessageConfiguration.class)
public class ServiceMessage {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "service-message");
		SpringApplication.run(ServiceMessage.class, args);
	}
}
