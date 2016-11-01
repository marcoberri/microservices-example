package it.marcoberri.ms.service.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import it.marcoberri.ms.common.model.Customer;

@Transactional
public interface CustomerRepository extends CrudRepository<Customer, Long> {

	public Customer findByName(String name);

	public Customer findById(Long id);

}
