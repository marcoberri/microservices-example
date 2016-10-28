package it.marcoberri.ms.common.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.marcoberri.ms.common.model.InfoRestModel;
import it.marcoberri.ms.commons.security.RemoteTokenServices;

public class CommonRestController {

	@Autowired
	Environment environment;

	@RequestMapping(value = "/echo", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public InfoRestModel info() {
		String portS = environment.getProperty("server.port");
		int port = 0;

		try {
			port = Integer.parseInt(portS);
		} catch (final Exception e) {

		}
		return new InfoRestModel(System.getProperty("spring.config.name"), port);

	}

	
}
