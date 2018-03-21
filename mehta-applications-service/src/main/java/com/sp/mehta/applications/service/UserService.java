package com.sp.mehta.applications.service;

import com.sp.mehta.applications.common.vo.UserVo;

public interface UserService {

	public Integer createUser(UserVo testVo, String userId);

	public Integer updateUser(UserVo testVo, String userId);

	public UserVo readUser(Integer id, String userId);

	public Object listUser();

}
