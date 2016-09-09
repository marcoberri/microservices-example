package it.marcoberri.ms.service.login.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginRestController {

	@Autowired
	Environment environment;

	@RequestMapping(value = "/echo")
	public String available() {

		String port = environment.getProperty("local.server.port");

		return "Spring in Action on " + System.getProperty("spring.config.name") + " on " + port;
	}

}
