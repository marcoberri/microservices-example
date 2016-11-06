package it.marcoberri.ms.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class ServiceProxy {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "service-proxy");
		SpringApplication.run(ServiceProxy.class, args);
	}

}
