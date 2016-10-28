package it.marcoberri.ms.service.message.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.service.message.repository.MessageRepository;

@RestController
@RequestMapping(value = "/api/message/")
public class MessageRestController extends CommonRestController {

	@Autowired
	private MessageRepository messageRepository;
}
