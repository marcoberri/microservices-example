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

import it.marcoberri.ms.common.model.Profile;
import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.commons.exception.ProfileNotFoundExcepion;
import it.marcoberri.ms.service.user.repository.ProfileRepository;

@RestController
@RequestMapping(value = "/api/profile")
public class ProfileRestController extends CommonRestController<ProfileRestController, ProfileRepository, Profile> {

	private static final Logger logger = Logger.getLogger(ProfileRestController.class);

	@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Profile not found")
	@ExceptionHandler(value = ProfileNotFoundExcepion.class)
	public String handleException(ProfileNotFoundExcepion e) {
		return e.getMessage();
	}

	/**
	 * @param name
	 * @return
	 * @throws ProfileNotFoundExcepion
	 */
	@RequestMapping(value = "/{nameOrId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Profile info(@PathVariable("nameOrId") String nameOrId) throws ProfileNotFoundExcepion {
		logger.debug("find by key:" + nameOrId);
		return findByNameOrId(nameOrId);
	}

	private Profile findByNameOrId(String nameOrId) throws ProfileNotFoundExcepion {

		logger.debug("*************** find by key 2:" + nameOrId);

		if (StringUtils.isNumeric(nameOrId)) {
			logger.debug("*************** StringUtils.isNumeric(usernameOrId):" + StringUtils.isNumeric(nameOrId));

			Long id = new Long(nameOrId);

			logger.debug("*************** new Long(usernameOrId):" + id);

			Profile a = repository.findById(id);
			if (a == null)
				throw new ProfileNotFoundExcepion();
			return a;
		}

		logger.debug("*************** find by key 3:" + nameOrId);

		Profile a = repository.findByName(nameOrId);

		if (a == null)
			throw new ProfileNotFoundExcepion();

		return a;

	}

}
