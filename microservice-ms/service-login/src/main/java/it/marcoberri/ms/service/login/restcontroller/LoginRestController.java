package it.marcoberri.ms.service.login.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.service.login.model.InfoRestModel;

@RestController
public class LoginRestController {

	@Autowired
	Environment environment;


	@RequestMapping(value = "/echo",produces = MediaType.APPLICATION_JSON_VALUE)
	public InfoRestModel info() {

		String port = environment.getProperty("local.server.port");

		return new InfoRestModel(System.getProperty("spring.config.name"), Integer.parseInt(port));

	}
}
