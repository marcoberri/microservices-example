package it.marcoberri.ms.service.logger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableDiscoveryClient
@Import(LoggerConfiguration.class)
public class ServiceLogger {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "service-logger");
		SpringApplication.run(ServiceLogger.class, args);
	}
}
