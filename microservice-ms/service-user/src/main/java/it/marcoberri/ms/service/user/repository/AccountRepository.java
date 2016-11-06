package it.marcoberri.ms.service.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.marcoberri.ms.common.model.Account;

@Transactional
public interface AccountRepository extends CrudRepository<Account, Long> {

	public Account findByUsername(String Username);

	public Account findById(Long id);

}
