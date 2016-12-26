package it.marcoberri.ms.commons.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class GlobalExceptionHander extends ResponseEntityExceptionHandler {

	@ExceptionHandler(value= Exception.class)
	protected ResponseEntity<Object>  handleConflict(RuntimeException e, WebRequest request){
		String body="error 1";
		return handleExceptionInternal(e, body, new HttpHeaders(), HttpStatus.CONFLICT, request);
	}
}
