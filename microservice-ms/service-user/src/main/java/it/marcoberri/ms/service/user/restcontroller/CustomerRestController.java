package it.marcoberri.ms.service.user.restcontroller;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.model.Customer;
import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.commons.exception.CustomerNotFoundExcepion;
import it.marcoberri.ms.service.user.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerRestController extends CommonRestController<CustomerRestController, CustomerRepository, Customer> {

	private static final Logger logger = Logger.getLogger(CustomerRestController.class);

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Customer not found")
	@ExceptionHandler(value = CustomerNotFoundExcepion.class)
	public String handleException(CustomerNotFoundExcepion e) {
		return e.getMessage();
	}

	/**
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{nameOrId}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Customer info(@PathVariable("nameOrId") String nameOrId) throws CustomerNotFoundExcepion {
		logger.debug("*************** find by key:" + nameOrId);
		return findByNameOrId(nameOrId);

	}

	private Customer findByNameOrId(String nameOrId) throws CustomerNotFoundExcepion {

		logger.debug("*************** find by key 2:" + nameOrId);

		if (StringUtils.isNumeric(nameOrId)) {
			logger.debug("*************** StringUtils.isNumeric(usernameOrId):" + StringUtils.isNumeric(nameOrId));

			Long id = new Long(nameOrId);

			logger.debug("*************** new Long(usernameOrId):" + id);

			Customer a = repository.findById(id);
			if (a == null)
				throw new CustomerNotFoundExcepion();
			return a;
		}

		logger.debug("*************** find by key 3:" + nameOrId);

		Customer a = repository.findByName(nameOrId);

		if (a == null)
			throw new CustomerNotFoundExcepion();

		return a;

	}

}
