package it.marcoberri.ms.service.logger.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import it.marcoberri.ms.common.model.BaseModel;

@Entity
@Table(name = "action")
public class Action extends BaseModel {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "action_id", unique = true, nullable = false)
	private Long id;
	private String application;
	private Long user;
	private String action;
	private String object;
	private String message;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApplication() {
		return application;
	}

	public void setApplication(String application) {
		this.application = application;
	}

	public Long getUser() {
		return user;
	}

	public void setUser(Long user) {
		this.user = user;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public String getObject() {
		return object;
	}

	public void setObject(String object) {
		this.object = object;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}