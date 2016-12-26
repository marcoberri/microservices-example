package it.marcoberri.ms.service.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import it.marcoberri.ms.common.model.Account;

@Transactional
public interface AccountRepository extends PagingAndSortingRepository<Account, Long> {

	public Account findByUsername(String Username);

	public Account findById(Long id);

	public List<Account> findAll();
	
}
