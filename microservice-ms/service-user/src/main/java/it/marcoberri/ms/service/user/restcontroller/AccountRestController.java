package it.marcoberri.ms.service.user.restcontroller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.model.Account;
import it.marcoberri.ms.common.model.BaseReponseSimpleObject;
import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.commons.exception.AccountNotFoundExcepion;
import it.marcoberri.ms.service.user.repository.AccountRepository;

@RestController
@RequestMapping(value = "/api/account/")
public class AccountRestController extends CommonRestController<AccountRestController, AccountRepository, Account> {

	private static final Logger logger = Logger.getLogger(AccountRestController.class);

	/**
	 * @param e
	 * @return


	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public List<Account> findAll() {
		return repository.findAll();
	}

	@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Account save(@RequestBody Account accountToSave) {
		if (accountToSave.getUsername() != null) {
			Account check = repository.findByUsername(accountToSave.getUsername());
			if (check != null && check.getId() != null) {
				accountToSave.setId(check.getId());
				accountToSave.setLastModifyTs(new Date());
			}
		}
		return repository.save(accountToSave);
	}

	/**
	 * @param usernameOrId
	 * @return
	 * @throws AccountNotFoundExcepion
	 */
	@RequestMapping(value = "/{usernameOrId}", produces = "application/hal+json", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Account info(@PathVariable("usernameOrId") String usernameOrId) throws AccountNotFoundExcepion {
		logger.debug("*************** find by key:" + usernameOrId);
		return findByNameOrId(usernameOrId);

	}

	/**
	 * @param usernameOrId
	 * @return
	 * @throws AccountNotFoundExcepion
	 */

	@RequestMapping(value = "/{usernameOrId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.DELETE)
	public BaseReponseSimpleObject delete(@PathVariable("usernameOrId") String usernameOrId) throws AccountNotFoundExcepion {

		final BaseReponseSimpleObject result = new BaseReponseSimpleObject();
		result.setInfo(this.info());

		logger.error("find by key:" + usernameOrId);
		Account account = findByNameOrId(usernameOrId);
		if (account == null) {
			result.setOperation(false);
			return result;

		}
		repository.delete(account);
		result.setOperation(true);
		return result;
	}

	/**
	 * @param usernameOrId
	 * @return
	 * @throws AccountNotFoundExcepion
	 */

	private Account findByNameOrId(String usernameOrId) throws AccountNotFoundExcepion {

		logger.debug("*************** find by key 2:" + usernameOrId);

		if (StringUtils.isNumeric(usernameOrId)) {
			logger.debug("*************** StringUtils.isNumeric(usernameOrId):" + StringUtils.isNumeric(usernameOrId));

			Long id = new Long(usernameOrId);

			logger.debug("*************** new Long(usernameOrId):" + id);

			Account a = repository.findById(id);
			if (a == null)
				throw new AccountNotFoundExcepion();
			return a;
		}

		logger.debug("*************** find by key 3:" + usernameOrId);

		Account a = repository.findByUsername(usernameOrId);

		if (a == null)
			throw new AccountNotFoundExcepion();

		return a;

	}

}
