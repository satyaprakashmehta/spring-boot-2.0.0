package com.sp.mehta.applications.service;

import java.util.List;

import com.sp.mehta.applications.common.vo.RolesVo;

public interface RolesService {

	public Integer createRoles(RolesVo rolesVo, String userId);
	
	public Integer updateRoles(RolesVo rolesVo, String userId);

	public RolesVo readRoles(Integer id, String userId);

	public List<RolesVo> listRoles();
}
