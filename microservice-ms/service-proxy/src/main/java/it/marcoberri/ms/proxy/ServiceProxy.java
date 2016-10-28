package it.marcoberri.ms.proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ServiceProxy {

	public static void main(String[] args) {
		SpringApplication.run(ServiceProxy.class, args);
	}

}
