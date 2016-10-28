package it.marcoberri.ms.service.user;

import java.util.logging.Logger;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import it.marcoberri.ms.service.user.restcontroller.AccountRestController;

public abstract class AbstractRestController {

	@Autowired
	AccountRestController accountRestController;

	@Test
	public void validAccountNumber() {
		Logger.getGlobal().info("Start validAccountNumber test");
		Logger.getGlobal().info("End validAccount test");
	}

}
