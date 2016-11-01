package it.marcoberri.ms.common.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.marcoberri.ms.common.model.InfoRestModel;

public class CommonRestController/*<T, A>*/ {

	@Autowired
	Environment environment;

//	@Autowired
//	private T repository;
//
//	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	public A save(@RequestBody A profile) {
//		return repository..save(profile);
//	}

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
