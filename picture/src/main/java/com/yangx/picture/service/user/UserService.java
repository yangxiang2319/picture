package com.yangx.picture.service.user;

import java.util.List;

import com.yangx.picture.domain.user.UserInfo;

public interface UserService {

	/**
	 * 获取所有的用户信息
	 * @author yangx
	 * 2017-09-12 17:59:45
	 */
	List<UserInfo> getUserInfo();
	
	/**
	 * 是否用户名有重复
	 * @param username
	 * @return
	 */
	boolean  hasUsername(String username);
	
	/**
	 * 注册用户
	 * @author yangx
	 * 2017-09-18 16:16:23
	 */
	void registUser(UserInfo user);
}
