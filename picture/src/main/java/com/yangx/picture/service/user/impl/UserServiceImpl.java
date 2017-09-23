package com.yangx.picture.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yangx.picture.dao.user.UserMapper;
import com.yangx.picture.domain.user.UserInfo;
import com.yangx.picture.service.user.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;

	/**
	 * 获取所有用户信息
	 * @author yangx
	 * 2017-09-12 18:02:41
	 */
	@Override
	public List<UserInfo> getUserInfo() {
		return userMapper.getUserInfo();
	}

	/**
	 * 用户名是否重复
	 */
	@Override
	public boolean hasUsername(String username) {
		return userMapper.hasUsername(username)>0?true:false;
	}

	/**
	 * 注册用户
	 * @author yangx
	 * 2017-09-18 16:16:46
	 */
	@Override
	public void registUser(UserInfo user) {
	    userMapper.insertUser(user);
	}

}
