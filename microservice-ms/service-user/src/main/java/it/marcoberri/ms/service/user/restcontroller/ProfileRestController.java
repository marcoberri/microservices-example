package it.marcoberri.ms.service.user.restcontroller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.model.Profile;
import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.service.user.repository.ProfileRepository;

@RestController
@RequestMapping(value = "/api/profile")
public class ProfileRestController extends CommonRestController {

	@Autowired
	private ProfileRepository profileRepository;

	private static final Logger logger = Logger.getLogger(ProfileRestController.class);

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public Profile save(@RequestBody Profile profile) {
		return profileRepository.save(profile);
	}

	/**
	 * @param name
	 * @return
	 */
	@RequestMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public Profile info(@PathVariable("name") String name) {
		logger.debug("find by key:" + name);
		return findByNameOrId(name);
	}

	/**
	 * @param key
	 * @return
	 */
	private Profile findByNameOrId(String key) {
		Profile profile = profileRepository.findByName(key);
		if (profile != null)
			return profile;
		try {
			Long id = new Long(key);

			return profileRepository.findById(id);
		} catch (final Exception e) {
			logger.error(e.getMessage(), e);
			return new Profile();
		}
	}

}
