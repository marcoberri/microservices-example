package it.marcoberri.ms.common.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@Table(name = "account")
public class Account extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "account_id", unique = true, nullable = false)
	private Long id;

	@JsonIgnore
	public String password;

	public boolean enabled;

	@Column(unique = true, nullable = false)
	public String username;

	@Column(length = 100)
	public String name;

	@Column(length = 100)
	public String surname;

	@Column(length = 30)
	public String phone;

	@Column(length = 30)
	public String mobile;

	@Column(length = 40)
	public String email;

	@ElementCollection(targetClass = Profile.class)
	private Set<Profile> profiles;

	//@ElementCollection(targetClass = Message.class)
	//private Set<Message> messagesFrom;

	//@ElementCollection(targetClass = Message.class)
	//private Set<Message> messagesTo;

	@ElementCollection(targetClass = Customer.class)
	private Set<Customer> customers;

	public Long getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public Account(String name, String password) {
		this.username = name;
		this.password = password;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	Account() { // jpa only
	}

	public String getName() {
		return name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}


	@OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
	public Set<Profile> getProfiles() {
		return profiles;
	}

	public void setProfiles(java.util.Set<Profile> profiles) {
		this.profiles = profiles;
	}

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	public Set<Customer> getCustomers() {
		return customers;
	}

	public void setCustomers(Set<Customer> customers) {
		this.customers = customers;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}