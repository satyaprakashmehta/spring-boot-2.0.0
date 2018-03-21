package com.sp.mehta.applications.common.vo;

import java.io.Serializable;

public class UserVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private String userName;
	private String password;
	private String email;
	private Boolean active;

	public UserVo() {
		super();
	}

	public UserVo(Integer id) {
		super();
		this.id = id;
	}

	public UserVo(String userName, String password, String email, Boolean active) {
		super();
		this.userName = userName;
		this.password = password;
		this.email = email;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
