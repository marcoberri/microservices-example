package it.marcoberri.ms.service.user.restcontroller;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.model.Account;
import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.service.user.repository.AccountRepository;

@RestController
@RequestMapping(value = "/api/account/")
public class AccountRestController extends CommonRestController {

	@Autowired
	private AccountRepository accountRepository;

	private static final Logger logger = Logger.getLogger(AccountRestController.class);

	
	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Account save(@RequestBody Account accountToSave) {
		if (accountToSave.getUsername() != null) {
			Account check = accountRepository.findByUsername(accountToSave.getUsername());
			if (check != null && check.getId() != null) {
				accountToSave.setId(check.getId());
				accountToSave.setLastModifyTs(new Date());

			}
		}
		return accountRepository.save(accountToSave);
	}

	@RequestMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Account info(@PathVariable("username") String username) {
		logger.debug("find by key:" + username);
		return findByUsernameOrId(username);
	}

	private Account findByUsernameOrId(String key) {
		Account account = accountRepository.findByUsername(key);
		if (account != null)
			return account;
		try {
			Long id = new Long(key);

			return accountRepository.findById(id);
		} catch (final Exception e) {
			logger.error(e.getMessage(), e);
			return new Account("-", "-");
		}
	}

}
