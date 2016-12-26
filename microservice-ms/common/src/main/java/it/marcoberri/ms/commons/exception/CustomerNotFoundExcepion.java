package it.marcoberri.ms.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Account not found 1")
public class CustomerNotFoundExcepion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
