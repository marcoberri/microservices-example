package it.marcoberri.ms.service.logger.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.marcoberri.ms.service.logger.model.Action;


@Transactional
public interface ActionRepository extends CrudRepository<Action, Long> {

}
