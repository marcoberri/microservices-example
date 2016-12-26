package it.marcoberri.ms.service.message.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.model.Account;
import it.marcoberri.ms.common.model.Message;
import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.commons.exception.AccountNotFoundExcepion;
import it.marcoberri.ms.commons.exception.MessageNotFoundExcepion;
import it.marcoberri.ms.service.message.repository.MessageRepository;

@RestController
@RequestMapping(value = "/api/message/")
public class MessageRestController extends CommonRestController<MessageRestController, MessageRepository, Message> {

	
	 
	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Account not found")
	@ExceptionHandler(value = AccountNotFoundExcepion.class)
	public String handleException(AccountNotFoundExcepion e) {
		return e.getMessage();
	}
	 
	
	@RequestMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Message info(@PathVariable("id") Long id) throws MessageNotFoundExcepion {
	
		return repository.findOne(id);

	}
}
