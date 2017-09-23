package com.yangx.picture.dao.user;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yangx.picture.domain.user.UserInfo;

/**
 * 用户Dao接口
 * @author yangx
 * 2017-09-12 13:55:54
 */
@Mapper
public interface UserMapper {

	/**
	 * 获取所有的用户信息
	 * @author yangx
	 * 2017-09-12 14:06:03
	 */
	List<UserInfo> getUserInfo();
	
	/**
	 * 查询指定用户名的数目
	 * @param username
	 * @return
	 */
	Integer hasUsername(@Param("username")String username);
	
	/**
	 * 注册用户
	 * @author yangx
	 * 2017-09-18 16:07:06
	 */
	void insertUser(UserInfo user);
}
