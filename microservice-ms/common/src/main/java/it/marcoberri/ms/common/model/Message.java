package it.marcoberri.ms.service.message.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.marcoberri.ms.common.model.Account;
import it.marcoberri.ms.common.model.BaseModel;

@Entity
@Table(name = "message")
public class Message extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "message_id", unique = true, nullable = false)
	private Long id;

	private Account from;

	private Account to;
	
	private String msg;
	
	private Boolean readingFromUser = false;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Account getFrom() {
		return from;
	}

	public void setFrom(Account from) {
		this.from = from;
	}

	public Account getTo() {
		return to;
	}

	public void setTo(Account to) {
		this.to = to;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Boolean getReadingFromUser() {
		return readingFromUser;
	}

	public void setReadingFromUser(Boolean readingFromUser) {
		this.readingFromUser = readingFromUser;
	}
	
	

}