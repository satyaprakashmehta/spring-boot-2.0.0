package com.sp.mehta.applications.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String 	userName;
	private String 	password;
	private String 	email;
	private Boolean active;
	
	public User() {
		super();
	}

	public User(Integer id) {
		this.id = id;
	}

	public User(String userName, String password, String email, Boolean active) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.active = active;
	}

	public User(User user) {
		this.id=user.getId();
		this.userName = user.getUserName();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.active = user.getActive();	
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", length = 11, unique = true, nullable = false)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="user_name",unique = true,length=60,nullable=false)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="password",length=60,nullable=false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name="email",length=60,nullable=false)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="active",nullable=false,length=1)
	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	
}
