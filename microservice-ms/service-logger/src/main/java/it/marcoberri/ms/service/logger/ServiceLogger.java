package it.marcoberri.ms.service.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableFeignClients
@Import(LoginConfiguration.class)
public class LoginServer {
	public static void main(String[] args) {
		System.setProperty("spring.config.name", "login-server");

		SpringApplication.run(LoginServer.class, args);

	}
}
