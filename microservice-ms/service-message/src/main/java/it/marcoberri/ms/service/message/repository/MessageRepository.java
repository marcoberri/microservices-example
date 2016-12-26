package it.marcoberri.ms.service.message.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.marcoberri.ms.common.model.Message;


@Transactional
public interface MessageRepository extends CrudRepository<Message, Long> {
	


}
