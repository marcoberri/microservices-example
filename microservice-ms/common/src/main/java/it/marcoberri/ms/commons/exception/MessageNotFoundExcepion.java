package it.marcoberri.ms.commons.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Message not found")
public class MessageNotFoundExcepion extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
