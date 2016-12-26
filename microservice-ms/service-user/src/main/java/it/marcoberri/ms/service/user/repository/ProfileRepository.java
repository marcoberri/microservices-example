package it.marcoberri.ms.service.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import it.marcoberri.ms.common.model.Profile;

@Transactional
public interface ProfileRepository extends PagingAndSortingRepository<Profile, Long> {

	public Profile findByName(String name);

	public Profile findById(Long id);

}
