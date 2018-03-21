package com.sp.mehta.applications.common.vo;

import java.io.Serializable;

public class RolesVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer userId;
	private String role;
	private Boolean active;

	public RolesVo() {
		super();
	}

	public RolesVo(Integer id) {
		super();
		this.id = id;
	}

	public RolesVo(Integer userId, String role, Boolean active) {
		super();
		this.userId = userId;
		this.role = role;
		this.active = active;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

}
