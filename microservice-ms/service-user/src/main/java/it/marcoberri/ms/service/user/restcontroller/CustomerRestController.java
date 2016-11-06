package it.marcoberri.ms.service.user.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.model.Customer;
import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.service.user.repository.CustomerRepository;

@RestController
@RequestMapping(value = "/api/customer")
public class CustomerRestController extends CommonRestController {

	@Autowired
	private CustomerRepository customerRepository;

	private static final Logger logger = Logger.getLogger(CustomerRestController.class);

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Customer save(@RequestBody Customer customer) {
		return customerRepository.save(customer);
	}

	/**
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Customer info(@PathVariable("name") String name) {
		logger.debug("find by key:" + name);
		return findByNameOrId(name);
	}

	/**
	 * @param key
	 * @return
	 */
	private Customer findByNameOrId(String key) {
		Customer customer = customerRepository.findByName(key);
		if (customer != null)
			return customer;
		try {
			
			Long id = new Long(key);

			return customerRepository.findById(id);
		} catch (final Exception e) {
			logger.warn(e.getMessage(), e);
			return new Customer();
		}
	}

}
