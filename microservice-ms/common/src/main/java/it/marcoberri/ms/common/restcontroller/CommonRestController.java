package it.marcoberri.ms.common.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import it.marcoberri.ms.common.model.Account;
import it.marcoberri.ms.common.model.InfoRestModel;
import it.marcoberri.ms.common.model.Profile;
import it.marcoberri.ms.commons.exception.RestNotFoundExcepion;

public class CommonRestController<C, R extends CrudRepository<M, Long>, M> {

	@Autowired
	Environment environment;

	@Autowired
	public R repository;

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Resources not found")
	@ExceptionHandler(value = RestNotFoundExcepion.class)
	public String handleException(RestNotFoundExcepion e) {
		return e.getMessage();
	}
	
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public M save(@RequestBody M model) {
		return repository.save(model);
	}

	// @Autowired
	// private T repository;
	//
	// @RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE,
	// consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	// public A save(@RequestBody A profile) {
	// return repository..save(profile);
	// }

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
