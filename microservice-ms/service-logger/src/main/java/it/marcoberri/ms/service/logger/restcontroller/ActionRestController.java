package it.marcoberri.ms.service.logger.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import it.marcoberri.ms.common.restcontroller.CommonRestController;
import it.marcoberri.ms.service.logger.model.Action;
import it.marcoberri.ms.service.logger.repository.ActionRepository;

@RestController
@RequestMapping(value = "/api/action/")
public class ActionRestController extends CommonRestController {

	@Autowired
	private ActionRepository actionRepository;

	@RequestMapping(value = "/{application}/{userid}/{action}/{object}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public  Action save(@PathVariable("object") String object, @PathVariable("application") String application, @PathVariable("userid") Long userid, @PathVariable("action") String action, @RequestParam String message) {
		final Action act = new Action();
		act.setApplication(application);
		act.setAction(action);
		act.setUser(userid);
		act.setObject(object);
		act.setMessage(message);
		return actionRepository.save(act);
	}
}
