package it.marcoberri.ms.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class ServiceEureka 
{
    public static void main( String[] args )
    {
		// Tell server to look for registration.properties or registration.yml
		System.setProperty("spring.config.name", "service-eureka");

		SpringApplication.run(ServiceEureka.class, args);
    }
}
