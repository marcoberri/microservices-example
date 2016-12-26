package it.marcoberri.ms.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

@Entity
@Audited
@Table(name = "message")
public class Message extends BaseModel {

	public Message() {

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "message_id", unique = true, nullable = false)
	private Long id;

	@OneToOne
	private Account accoutFrom;

	@OneToOne
	private AccountTarget accountTo;

	@Column(length = 5000)
	private String msg;

	private Boolean readingFromUser = false;

	public AccountTarget getAccountTo() {
		return accountTo;
	}

	public void setAccountTo(AccountTarget accountTo) {
		this.accountTo = accountTo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Account getAccoutFrom() {
		return accoutFrom;
	}

	public void setAccoutFrom(Account accoutFrom) {
		this.accoutFrom = accoutFrom;
	}

//	public Account getAccountTo() {
//		return accountTo;
//	}
//
//	public void setAccountTo(Account accountTo) {
//		this.accountTo = accountTo;
//	}

}